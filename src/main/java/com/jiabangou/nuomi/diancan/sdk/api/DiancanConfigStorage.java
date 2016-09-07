package com.jiabangou.nuomi.diancan.sdk.api;

/**
 * 饿了么配置存储
 * Created by freeway on 16/7/11.
 */
public interface DiancanConfigStorage {

    String BASE_URL = "https://t10ocs.nuomi.com";
    String getAppKey();
    String getAppSecret();

    /**
     *
     * @return
     */
    default String getBashUrl() {
        return BASE_URL;
    }
}
