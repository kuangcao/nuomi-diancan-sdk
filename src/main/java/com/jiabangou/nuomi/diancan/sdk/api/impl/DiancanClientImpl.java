package com.jiabangou.nuomi.diancan.sdk.api.impl;

import com.jiabangou.nuomi.diancan.sdk.api.*;
import okhttp3.OkHttpClient;

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
    public ShopService getMerchantService() {
        if (merchantService == null) {
            merchantService = new ShopServiceImpl(getClient(), configStorage, logListener);
        }
        return merchantService;
    }

}
