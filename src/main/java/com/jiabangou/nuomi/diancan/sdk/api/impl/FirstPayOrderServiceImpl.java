package com.jiabangou.nuomi.diancan.sdk.api.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.nuomi.diancan.sdk.api.DiancanConfigStorage;
import com.jiabangou.nuomi.diancan.sdk.api.LogListener;
import com.jiabangou.nuomi.diancan.sdk.api.FirstPayOrderService;
import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Order;
import com.jiabangou.nuomi.diancan.sdk.model.OrderStatus;
import com.jiabangou.nuomi.diancan.sdk.model.PayType;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 订单服务
 * Created by freeway on 16/9/6.
 */
public class FirstPayOrderServiceImpl extends DiancanBaseServiceImpl implements FirstPayOrderService {

    private static final String DIANCAIUI_QUERYORDER = "/diancaiui/queryorder";
    private static final String DIANCAIUI_UPDATEORDER = "/diancaiui/updateorder";
    private static final String DIANCAIUI_POIORDER = "/diancaiui/poiorder";

    public FirstPayOrderServiceImpl(OkHttpClient client, DiancanConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public Order getByMchIdAndCodeNum(Long tpMerchantId, String codeNum) throws NuomiErrorException {
        return getByMchIdAndCodeNum(tpMerchantId, codeNum, PayType.PAY_FIRST);
    }

    @Override
    public Order getByMchIdAndMobileSuffix(Long tpMerchantId, String mobileSuffix) throws NuomiErrorException {
        return getByMchIdAndMobileSuffix(tpMerchantId, mobileSuffix, PayType.PAY_FIRST);
    }


    protected Order getByMchIdAndCodeNum(Long tpMerchantId, String codeNum, int payType) throws NuomiErrorException {
        JSONObject jsonObject = execute(DIANCAIUI_QUERYORDER, new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpMerchantId));
            put("code_num", codeNum);
            put("pay_type", String.valueOf(payType));
        }});
        return jsonObject.getObject(DATA, Order.class);
    }

    protected Order getByMchIdAndMobileSuffix(Long tpMerchantId, String mobileSuffix, int payType) throws NuomiErrorException {
        JSONObject jsonObject = execute(DIANCAIUI_QUERYORDER, new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpMerchantId));
            put("menu_num", mobileSuffix);
            put("pay_type", String.valueOf(payType));
        }});
        return jsonObject.getObject(DATA, Order.class);
    }


    @Override
    public void confirm(Long orderId, String tpOrderId) throws NuomiErrorException {
        updateOrderStatus(orderId, tpOrderId, OrderStatus.PAY_FIRST_CONFIRMED);
    }

    @Override
    public void cancel(Long orderId, String tpOrderId) throws NuomiErrorException {
        updateOrderStatus(orderId, tpOrderId, OrderStatus.CANCELED);
    }

    /**
     * 针对于先付只有确认和取消状态可用
     *
     * @param orderId
     * @param tpOrderId
     * @param status
     * @throws NuomiErrorException
     */
    protected void updateOrderStatus(Long orderId, String tpOrderId, int status) throws NuomiErrorException {
        execute(DIANCAIUI_UPDATEORDER, new HashMap<String, String>() {{
            put("order_id", String.valueOf(orderId));
            put("tp_order_id", tpOrderId);
            put("status", String.valueOf(status));
            put("update_time", String.valueOf(System.currentTimeMillis()/1000));
            //先付
            put("is_dinner", "0");
        }});
    }

    @Override
    public List<Order> getUnfinishedOrders(Long tpMerchantId) throws NuomiErrorException {
        JSONObject jsonObject = execute(DIANCAIUI_POIORDER, new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpMerchantId));
        }});
        JSONArray jsonArray = jsonObject.getJSONArray(DATA);
        return jsonArray.stream().map(json-> TypeUtils.castToJavaBean(json, Order.class)).collect(toList());
    }
}