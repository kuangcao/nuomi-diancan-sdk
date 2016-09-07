package com.jiabangou.nuomi.diancan.sdk.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiabangou.nuomi.diancan.sdk.api.DiancanConfigStorage;
import com.jiabangou.nuomi.diancan.sdk.api.LogListener;
import com.jiabangou.nuomi.diancan.sdk.api.OrderService;
import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Order;
import com.jiabangou.nuomi.diancan.sdk.model.PayType;
import okhttp3.OkHttpClient;

import java.util.HashMap;

/**
 * 订单服务
 * Created by freeway on 16/9/6.
 */
public class OrderServiceImpl extends DiancanBaseServiceImpl implements OrderService {

    private static final String DIANCAIUI_QUERYORDER = "/diancaiui/queryorder";

    public OrderServiceImpl(OkHttpClient client, DiancanConfigStorage configStorage, LogListener logListener) {
        super(client, configStorage, logListener);
    }

    @Override
    public Order getByMchIdAndCodeNum(Long tpMerchantId, String codeNum) throws NuomiErrorException {
        return getByMchIdAndCodeNum(tpMerchantId, codeNum, PayType.PAY_FIRST);
    }

    @Override
    public Order getByMchIdAndCodeNum(Long tpMerchantId, String codeNum, int payType) throws NuomiErrorException {
        JSONObject jsonObject = execute(DIANCAIUI_QUERYORDER, new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpMerchantId));
            put("code_num", codeNum);
            put("pay_type", String.valueOf(payType));
        }});
        return jsonObject.getObject(DATA, Order.class);
    }

    @Override
    public Order getByMchIdAndMobileSuffix(Long tpMerchantId, String mobileSuffix) throws NuomiErrorException {
        return getByMchIdAndMobileSuffix(tpMerchantId, mobileSuffix, PayType.PAY_FIRST);
    }

    @Override
    public Order getByMchIdAndMobileSuffix(Long tpMerchantId, String mobileSuffix, int payType) throws NuomiErrorException {
        JSONObject jsonObject = execute(DIANCAIUI_QUERYORDER, new HashMap<String, String>() {{
            put("tp_merchant_id", String.valueOf(tpMerchantId));
            put("menu_num", mobileSuffix);
            put("pay_type", String.valueOf(payType));
        }});
        return jsonObject.getObject(DATA, Order.class);
    }

}
