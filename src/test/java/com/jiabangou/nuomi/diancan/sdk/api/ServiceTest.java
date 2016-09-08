package com.jiabangou.nuomi.diancan.sdk.api;

import org.junit.BeforeClass;

/**
 * 服务基础对象
 * Created by freeway on 16/9/8.
 */
public abstract class ServiceTest {

    protected static DiancanClient diancanClient;

    @BeforeClass
    public static void BeforeClass() {

        diancanClient = DiancanClient.create(new DiancanConfigStorage() {

            @Override
            public String getAppKey() {
                return "xiaoyage";
            }

            @Override
            public String getAppSecret() {
                return "bc6df7d374dbc5c8df5c7106f2fd3ed4";
            }

            @Override
            public String getDishAppKey() {
                return "xiaoyage";
            }

            @Override
            public String getDishAppSecret() {
                return "a43db63a-4547-4855-8228-f060c1858618";
            }

            @Override
            public String getBaseUrl() {
                return "http://106.120.159.173:8999";
            }

            @Override
            public String getDishBaseUrl() {
                return "http://61.135.186.174";
            }
        });

        diancanClient.setLogListener((cmd, isSuccess, request, response) -> {
            System.out.println("cmd:" + cmd);
            System.out.println("isSuccess:" + isSuccess);
            System.out.println("request:\n" + request);
            System.out.println("response:\n" + response);
        });
    }
}
