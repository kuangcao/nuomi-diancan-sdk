package com.jiabangou.nuomi.diancan.sdk.api.impl;

import com.jiabangou.nuomi.diancan.sdk.api.DiancanConfigStorage;
import com.jiabangou.nuomi.diancan.sdk.api.LogListener;
import com.jiabangou.nuomi.diancan.sdk.api.MerchantService;
import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import okhttp3.OkHttpClient;

import java.util.HashMap;

/**
 * 商户服务实现
 * Created by freeway on 16/9/7.
 */
public class MerchantServiceImpl extends DiancanBaseServiceImpl implements MerchantService {

    private static final String DIANCAIUI_BINDTPINFO = "/diancaiui/bindtpinfo";

    public MerchantServiceImpl(OkHttpClient client, DiancanConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public void bind(Long merchantId, Long tpMerchantId) throws NuomiErrorException {
        execute(DIANCAIUI_BINDTPINFO, new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpMerchantId));
            put("merchant_id", String.valueOf(merchantId));
        }});
    }


}
