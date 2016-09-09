package com.jiabangou.nuomi.diancan.sdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiabangou.nuomi.diancan.sdk.api.*;
import com.jiabangou.nuomi.diancan.sdk.model.Order;
import com.jiabangou.nuomi.diancan.sdk.model.OrderPayStatus;
import com.jiabangou.nuomi.diancan.sdk.model.PushResponse;
import okhttp3.OkHttpClient;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * 点餐客户端
 * Created by freeway on 16/9/8.
 */
public class DiancanClientImpl implements DiancanClient {

    private DiancanConfigStorage configStorage;
    private LogListener logListener;
    private PushConsumer pushConsumer;
    private OkHttpClient client;

    private DishService dishService;
    private FirstPayOrderService firstPayOrderService;
    private ShopService merchantService;

    public DiancanClientImpl(DiancanConfigStorage configStorage) {
        this.configStorage = configStorage;
    }

    @Override
    public void setLogListener(LogListener logListener) {
        this.logListener = logListener;
    }

    @Override
    public void setPushConsumer(PushConsumer pushConsumer) {
        this.pushConsumer = pushConsumer;
    }

    private void logging(String cmd, boolean isSuccess, String request, String response) {
        if (logListener != null) {
            logListener.requestEvent(cmd, isSuccess, request, response);
        }
    }

    private OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient();
        }
        return client;
    }

    @Override
    public DishService getDishService() {
        if (dishService == null) {
            dishService = new DishServiceImpl(getClient(), configStorage, logListener);
        }
        return dishService;
    }

    @Override
    public FirstPayOrderService getFirstPayOrderService() {
        if (firstPayOrderService == null) {
            firstPayOrderService = new FirstPayOrderServiceImpl(getClient(), configStorage, logListener);
        }
        return firstPayOrderService;
    }

    @Override
    public ShopService getShopService() {
        if (merchantService == null) {
            merchantService = new ShopServiceImpl(getClient(), configStorage, logListener);
        }
        return merchantService;
    }

    @Override
    public PushResponse pushHandle(int pushAction, Map<String, String> params) {
        if (isValidSign(params)) {
            PushResponse pushResponse = new PushResponse();
            pushResponse.setErrno(3);
            pushResponse.setMsg("sign error");
            return pushResponse;
        }
        if (pushAction == PushConsumer.PUSH_ACTION_ADD_ORDER) {
            JSONObject jsonObject = (JSONObject)JSON.toJSON(params);
            jsonObject.put("pay_detail", JSON.parseObject(jsonObject.getString("pay_detail")));
            jsonObject.put("dishes", JSON.parseArray(jsonObject.getString("dishes")));

            Order order = JSONObject.toJavaObject(jsonObject, Order.class);

            String tpOderId = pushConsumer.addOrder(order);
            PushResponse pushResponse = PushResponse.create();
            pushResponse.setData(new JSONObject() {{
                put("order_status", order.getStatus());
                put("tp_order_id", tpOderId);
            }});
            pushResponse.setSequence(params.get("sequence"));
            return pushResponse;
        } else if (pushAction == PushConsumer.PUSH_ACTION_CHANGE_ORDER_PAY_STATUS) {
            JSONObject jsonObject = (JSONObject)JSON.toJSON(params);
            OrderPayStatus orderPayStatus = JSONObject.toJavaObject(jsonObject, OrderPayStatus.class);
            String tpOderId = pushConsumer.changeOrderPayStatus(orderPayStatus);

            PushResponse pushResponse = PushResponse.create();
            pushResponse.setData(new JSONObject() {{
                put("order_status", orderPayStatus.getStatus());
                put("tp_order_id", tpOderId);
            }});
            pushResponse.setSequence(params.get("sequence"));
            return pushResponse;

        } else if (pushAction == PushConsumer.PUSH_ACTION_GET_ORDER_STATUS) {
            int status = pushConsumer.getOrderStatus(Long.valueOf(params.get("tp_order_id")));
            PushResponse pushResponse = PushResponse.create();
            pushResponse.setData(new JSONObject() {{
                put("status", String.valueOf(status));
                put("tp_order_id", params.get("tp_order_id"));
            }});
            pushResponse.setSequence(params.get("sequence"));
            return pushResponse;
        }
        return null;
    }


    /**
     * 判断是否是有效的签名
     * @param params 包含了签名和公用参数
     * @return 在请求参数基础上混入了签名和公用参数
     */
    protected boolean isValidSign(Map<String, String> params) {
        String sign = params.get("token");
        if (sign == null || StringUtils.isBlank(sign)) {
            return false;
        }
        List<String> sortStrings = params.keySet().stream()
                .filter(key -> (!"intToken".equals(key)) && (!"log_id".equals(key)) && (!"token".equals(key)))
                .sorted().map(key->key+":"+params.get(key)).collect(toList());
        sortStrings.add(configStorage.getAppSecret());
        String buildSign = DigestUtils.md5Hex(StringUtils.join(sortStrings, "_"));
        return buildSign.equals(sign);
    }
}
