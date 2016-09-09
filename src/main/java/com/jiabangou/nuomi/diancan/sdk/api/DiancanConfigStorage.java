package com.jiabangou.nuomi.diancan.sdk.api;

/**
 * 饿了么配置存储
 * Created by freeway on 16/7/11.
 */
public interface DiancanConfigStorage {

    String BASE_URL = "https://t10ocs.nuomi.com";
    /**
     * 测试环境
     * http://61.135.186.174
     */
    String DISH_BASE_URL = "http://dish.nuomi.com";

    String getClientID();

    String getClientSecret();

    /**
     * 等同于 site_name
     * @return
     */
    String getDishClientID();

    /**
     * 对应百度参数里面的sign
     * @return
     */
    String getDishClientSecret();

    /**
     * 获取调用的基础URL
     * @return
     */
    default String getBaseUrl() {
        return BASE_URL;
    }

    /**
     * 获取DishAPI的基础URL
     * @return
     */
    default String getDishBaseUrl() {
        return DISH_BASE_URL;
    }

}
