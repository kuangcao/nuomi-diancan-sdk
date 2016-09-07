package com.jiabangou.nuomi.diancan.sdk.api;

/**
 * 点餐客户端
 * Created by freeway on 16/7/11.
 */
public interface DiancanClient {

    void setDiancanConfigStorage(DiancanConfigStorage configStorage);

    void setLogListener(LogListener logListener);

    void setPushConsumer(PushConsumer pushConsumer);

}
