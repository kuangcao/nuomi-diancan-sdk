package com.jiabangou.nuomi.diancan.sdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.nuomi.diancan.sdk.api.DiancanConfigStorage;
import com.jiabangou.nuomi.diancan.sdk.api.LogListener;
import com.jiabangou.nuomi.diancan.sdk.api.MerchantService;
import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Table;
import com.jiabangou.nuomi.diancan.sdk.model.TableCategory;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.List;

/**
 * 商户服务实现
 * Created by freeway on 16/9/7.
 */
public class MerchantServiceImpl extends DiancanBaseServiceImpl implements MerchantService {

    private static final String DIANCAIUI_BINDTPINFO = "/diancaiui/bindtpinfo";
    private static final String DIANCAIUI_SYNCTABLEINFO = "/diancaiui/synctableinfo";


    public MerchantServiceImpl(OkHttpClient client, DiancanConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public void bind(Long merchantId, Long tpMerchantId) throws NuomiErrorException {

        if (merchantId == null) {
            throw new NuomiErrorException(-1, "merchantId is required.");
        }
        if (tpMerchantId == null) {
            throw new NuomiErrorException(-1, "tpMerchantId is required.");
        }

        execute(DIANCAIUI_BINDTPINFO, new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpMerchantId));
            put("merchant_id", String.valueOf(merchantId));
        }});
    }

    @Override
    public void syncTablesAndCategories(Long tpMerchantId, List<Table> tables, List<TableCategory> tableCategories)
        throws NuomiErrorException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tables", JSONObject.toJSON(tables));
        jsonObject.put("categories", JSONObject.toJSON(tableCategories));
        execute(DIANCAIUI_BINDTPINFO, new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpMerchantId));
            put("menu_info", jsonObject.toJSONString());
        }});
    }

    @Override
    public void updateBasicInfo() throws NuomiErrorException {

    }


}
