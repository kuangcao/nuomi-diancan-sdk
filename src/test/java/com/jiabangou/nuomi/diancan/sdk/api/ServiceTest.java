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
                return "cdd6d544297af47cf41a4ec403db3f24";
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
                return "http://220.181.163.63:8989";
            }

            @Override
            public String getDishBaseUrl() {
                return "http://61.135.186.174";
            }
        });
    }
}
