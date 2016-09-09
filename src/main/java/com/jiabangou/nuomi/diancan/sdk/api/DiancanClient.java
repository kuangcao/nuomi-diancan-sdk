package com.jiabangou.nuomi.diancan.sdk.api;

import com.jiabangou.nuomi.diancan.sdk.api.impl.DiancanClientImpl;
import com.jiabangou.nuomi.diancan.sdk.model.PushAction;
import com.jiabangou.nuomi.diancan.sdk.model.PushResponse;

import java.util.Map;

/**
 * 点餐客户端
 * Created by freeway on 16/7/11.
 */
public interface DiancanClient {

    void setLogListener(LogListener logListener);

    void setPushConsumer(PushConsumer pushConsumer);

    DishService getDishService();

    FirstPayOrderService getFirstPayOrderService();

    ShopService getShopService();

    PushResponse pushHandle(PushAction pushAction, Map<String, String> params);

    static DiancanClient create(DiancanConfigStorage configStorage) {
        return new DiancanClientImpl(configStorage);
    }
}
