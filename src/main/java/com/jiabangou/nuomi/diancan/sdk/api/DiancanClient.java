package com.jiabangou.nuomi.diancan.sdk.api;

import com.jiabangou.nuomi.diancan.sdk.api.impl.DiancanClientImpl;

/**
 * 点餐客户端
 * Created by freeway on 16/7/11.
 */
public interface DiancanClient {

    void setLogListener(LogListener logListener);

    void setPushConsumer(PushConsumer pushConsumer);

    DishService getDishService();

    FirstPayOrderService getFirstPayOrderService();

    MerchantService getMerchantService();

    static DiancanClient create(DiancanConfigStorage configStorage) {
        return new DiancanClientImpl(configStorage);
    }
}
