package com.jiabangou.nuomi.diancan.sdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.nuomi.diancan.sdk.api.DiancanConfigStorage;
import com.jiabangou.nuomi.diancan.sdk.api.LogListener;
import com.jiabangou.nuomi.diancan.sdk.api.ShopService;
import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.BusinessTime;
import com.jiabangou.nuomi.diancan.sdk.model.DishCategory;
import com.jiabangou.nuomi.diancan.sdk.model.Table;
import com.jiabangou.nuomi.diancan.sdk.model.TableCategory;
import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

/**
 * 商户服务实现
 * Created by freeway on 16/9/7.
 */
public class ShopServiceImpl extends DiancanBaseServiceImpl implements ShopService {

    private static final String DIANCAIUI_BINDTPINFO = "/diancaiui/bindtpinfo";
    private static final String DIANCAIUI_SYNCTABLEINFO = "/diancaiui/synctableinfo";
    private static final String DIANCAIUI_UPDATEBASICINFO = "/diancaiui/updatebasicinfo";


    public ShopServiceImpl(OkHttpClient client, DiancanConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public void bind(Long shopId, Long tpShopId) throws NuomiErrorException {

        if (shopId == null) {
            throw new NuomiErrorException(-1, "merchantId is required.");
        }
        if (tpShopId == null) {
            throw new NuomiErrorException(-1, "tpMerchantId is required.");
        }

        execute(DIANCAIUI_BINDTPINFO, new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpShopId));
            put("merchant_id", String.valueOf(shopId));
        }});
    }

    @Override
    public void syncTablesAndCategories(Long tpShopId, List<Table> tables, List<TableCategory> tableCategories)
        throws NuomiErrorException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tables", JSONObject.toJSON(tables));
        jsonObject.put("categories", JSONObject.toJSON(tableCategories));
        execute(DIANCAIUI_SYNCTABLEINFO, new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpShopId));
            put("menu_info", jsonObject.toJSONString());
        }});
    }

    @Override
    public void updateBasicInfo(Long tpShopId, int serviceState, int tableType,
                                List<BusinessTime> businessTimes, List<DishCategory> dishCategories)
            throws NuomiErrorException {
        Map<String, String> params = new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpShopId));
            put("poi_state", String.valueOf(serviceState));
            put("table_type", String.valueOf(tableType));
        }};

        if (businessTimes != null && (!businessTimes.isEmpty())) {
            params.put("business_time", JSONObject.toJSON(businessTimes).toString());
        }
        if (dishCategories != null && !dishCategories.isEmpty()) {
            params.put("class_sort",
                JSONObject.toJSON(dishCategories.stream()
                    .collect(toMap(DishCategory::getId, Function.identity()))).toString());
        }
        execute(DIANCAIUI_UPDATEBASICINFO, params);
    }

}
