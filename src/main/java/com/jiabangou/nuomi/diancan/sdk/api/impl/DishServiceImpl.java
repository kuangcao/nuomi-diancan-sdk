package com.jiabangou.nuomi.diancan.sdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jiabangou.nuomi.diancan.sdk.api.DiancanConfigStorage;
import com.jiabangou.nuomi.diancan.sdk.api.DishService;
import com.jiabangou.nuomi.diancan.sdk.api.LogListener;
import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Dish;
import com.jiabangou.nuomi.diancan.sdk.model.DishStatus;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 菜品服务实现
 * Created by freeway on 16/9/7.
 */
public class DishServiceImpl implements DishService {


    private static final String DISH_INFO = "/dish/info";
    private static final String DISH_STATUS = "/dish/status";

    protected DiancanConfigStorage configStorage;
    protected LogListener logListener;
    protected OkHttpClient client;

    public DishServiceImpl(OkHttpClient client, DiancanConfigStorage configStorage, LogListener logListener) {
        this.configStorage = configStorage;
        this.client = client;
        this.logListener = logListener;
    }

    private void logging(String cmd, boolean isSuccess, String request, String response) {
        if (logListener != null) {
            logListener.requestEvent(cmd, isSuccess, request, response);
        }
    }

    /**
     * 构造签名和公用参数
     *
     * @param jsonObject 请求参数
     * @return 在请求参数基础上混入了签名和公用参数
     */
    protected JSONObject buildRealParams(JSONObject jsonObject) {
        jsonObject.put("site_name", configStorage.getDishClientID());
        jsonObject.put("sign", configStorage.getDishClientSecret());
        return jsonObject;
    }

    protected JSONObject execute(String url, JSONObject jsonParams) throws NuomiErrorException {
        JSONObject realParams = buildRealParams(jsonParams);
        Request.Builder builder = new Request.Builder();
        String realUrl = configStorage.getDishBaseUrl() + url;
        builder.url(realUrl)
                .post(createJsonBody(realParams));
        try {
            client.newCall(builder.build()).execute();
            Response response = client.newCall(builder.build()).execute();
            String responseString = response.body().string();
            JSONObject jsonObject = JSONObject.parseObject(responseString);
            int status = jsonObject.getIntValue("status");
            boolean isSuccess = status == 0;
            logging(url, isSuccess, "POST " + realUrl + "\nBody:" + JSON.toJSONString(realParams), responseString);
            if (isSuccess) {
                return jsonObject;
            }
            throw new NuomiErrorException(status, jsonObject.getString("msg"),
                    realUrl, realParams, responseString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final MediaType MEDIA_TYPE_JSON
            = MediaType.parse("application/json; charset=utf-8");

    private RequestBody createJsonBody(JSONObject jsonObject) {
        return RequestBody.create(MEDIA_TYPE_JSON, jsonObject.toJSONString());
    }

    @Override
    public void uploadDishes(List<Dish> dishs) throws NuomiErrorException {
        if (dishs == null || dishs.isEmpty()) {
            return;
        }
        List<Dish> partDishs = new ArrayList<>(10);
        for (int i = 0; i < dishs.size(); i++) {
            partDishs.add(dishs.get(i));
            if (partDishs.size() == 10 || i == dishs.size() - 1) {
                final List<Dish> updatePartDishs = new ArrayList<>(partDishs);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("count", updatePartDishs.size());
                jsonObject.put("data", JSONObject.toJSON(updatePartDishs));
                execute(DISH_INFO, jsonObject);
                partDishs = new ArrayList<>(10);
            }
        }
    }

    @Override
    public void updateDishOnlineStatuses(List<DishStatus> dishStatuses) throws NuomiErrorException {
        if (dishStatuses == null || dishStatuses.isEmpty()) {
            return;
        }
        List<DishStatus> partDishStatuses = new ArrayList<>(10);
        for (int i = 0; i < dishStatuses.size(); i++) {
            partDishStatuses.add(dishStatuses.get(i));
            if (partDishStatuses.size() == 10 || i == dishStatuses.size() - 1) {
                final List<DishStatus> updatePartDishStatuses = new ArrayList<>(partDishStatuses);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("count", updatePartDishStatuses.size());
                jsonObject.put("data", JSONObject.toJSON(updatePartDishStatuses));
                execute(DISH_STATUS, jsonObject);
                partDishStatuses = new ArrayList<>(10);
            }
        }
    }

    @Override
    public void online(String tpShopId, List<String> tpDishIds) throws NuomiErrorException {
        if (tpDishIds == null || tpDishIds.isEmpty()) {
            return;
        }
        updateDishOnlineStatuses(tpDishIds.stream().map(dishId-> {
            DishStatus dishStatus = new DishStatus();
            dishStatus.setId(dishId);
            dishStatus.setTpShopId(tpShopId);
            dishStatus.setOnlineState(Dish.ONLINE_STATE_ONLINE);
            return dishStatus;
        }).collect(toList()));
    }

    @Override
    public void online(String tpShopId, String tpDishId) throws NuomiErrorException {
        online(tpShopId, new ArrayList<String>() {{
            add(tpDishId);
        }});
    }

    @Override
    public void delete(String tpShopId, List<String> tpDishIds) throws NuomiErrorException {
        if (tpDishIds == null || tpDishIds.isEmpty()) {
            return;
        }
        updateDishOnlineStatuses(tpDishIds.stream().map(dishId-> {
            DishStatus dishStatus = new DishStatus();
            dishStatus.setId(dishId);
            dishStatus.setTpShopId(tpShopId);
            dishStatus.setOnlineState(Dish.ONLINE_STATE_DELETED);
            return dishStatus;
        }).collect(toList()));
    }

    @Override
    public void delete(String tpShopId, String tpDishId) throws NuomiErrorException {
        delete(tpShopId, new ArrayList<String>() {{
            add(tpDishId);
        }});
    }

    @Override
    public void offline(String tpShopId, List<String> tpDishIds) throws NuomiErrorException {
        if (tpDishIds == null || tpDishIds.isEmpty()) {
            return;
        }
        updateDishOnlineStatuses(tpDishIds.stream().map(dishId-> {
            DishStatus dishStatus = new DishStatus();
            dishStatus.setId(dishId);
            dishStatus.setTpShopId(tpShopId);
            dishStatus.setOnlineState(Dish.ONLINE_STATE_OFFLINE);
            return dishStatus;
        }).collect(toList()));
    }

    @Override
    public void offline(String tpShopId, String tpDishId) throws NuomiErrorException {
        offline(tpShopId, new ArrayList<String>() {{
            add(tpDishId);
        }});
    }

    @Override
    public void sellOut(String tpShopId, List<String> tpDishIds) throws NuomiErrorException {
        if (tpDishIds == null || tpDishIds.isEmpty()) {
            return;
        }
        updateDishOnlineStatuses(tpDishIds.stream().map(dishId-> {
            DishStatus dishStatus = new DishStatus();
            dishStatus.setId(dishId);
            dishStatus.setTpShopId(tpShopId);
            dishStatus.setOnlineState(Dish.ONLINE_STATE_SELL_OUT);
            return dishStatus;
        }).collect(toList()));
    }

    @Override
    public void sellOut(String tpShopId, String tpDishId) throws NuomiErrorException {
        sellOut(tpShopId, new ArrayList<String>() {{
            add(tpDishId);
        }});
    }

}
