package com.jiabangou.nuomi.diancan.sdk.api.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import com.jiabangou.nuomi.diancan.sdk.api.DiancanConfigStorage;
import com.jiabangou.nuomi.diancan.sdk.api.LogListener;
import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import okhttp3.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * 基础服务
 * Created by freeway on 16/9/6.
 */
public class DiancanBaseServiceImpl {

    public static final String DATA = "data";

    protected DiancanConfigStorage configStorage;
    protected LogListener logListener;
    protected OkHttpClient client;

    public DiancanBaseServiceImpl(OkHttpClient client, DiancanConfigStorage configStorage, LogListener logListener) {
        this.configStorage = configStorage;
        this.client = client;
        this.logListener = logListener;
    }

    private void logging(String cmd, boolean isSuccess, String request, String response) {
        if (logListener != null) {
            logListener.requestEvent(cmd, isSuccess, request, response);
        }
    }

    /**
     * 构造签名和公用参数
     * @param params 请求参数
     * @return 在请求参数基础上混入了签名和公用参数
     */
    protected Map<String, String> buildRealParams(Map<String, String> params) {
        Map<String, String> realParams = new HashMap<>(params.size()+2);
        realParams.put("service", configStorage.getAppKey());
        realParams.put("sequence", String.valueOf(System.currentTimeMillis() / 1000));
        realParams.putAll(params);

        List<String> sortStrings = realParams.keySet().stream()
                .filter(key -> (!"intToken".equals(key)) && (!"log_id".equals(key)) && realParams.get(key) != null)
                .sorted().map(key->key+":"+realParams.get(key)).collect(toList());
        sortStrings.add(configStorage.getAppSecret());

        realParams.put("token", DigestUtils.md5Hex(StringUtils.join(sortStrings, "_")));
        return realParams;
    }

    /**
     * 判断是否是有效的签名
     * @param params 包含了签名和公用参数
     * @return 在请求参数基础上混入了签名和公用参数
     */
    protected boolean isValidSign(Map<String, String> params) {
        String sign = params.get("token");
        if (sign == null || StringUtils.isBlank(sign)) {
            return false;
        }
        if (!configStorage.getAppKey().equals(params.get("service"))) {
            return false;
        }
        List<String> sortStrings = params.keySet().stream()
                .filter(key -> (!"intToken".equals(key)) && (!"log_id".equals(key)) && (!"token".equals(key)))
                .sorted().map(key->key+":"+params.get(key)).collect(toList());
        sortStrings.add(configStorage.getAppSecret());
        String buildSign = DigestUtils.md5Hex(StringUtils.join(sortStrings, "_"));
        return buildSign.equals(sign);
    }

    protected JSONObject execute(String url, Object obj) throws NuomiErrorException {
        JSONObject jsonObject = (JSONObject)JSONObject.toJSON(obj);
        final Map<String, String> params = new HashMap<>();
        jsonObject.entrySet().stream()
                .filter(entry->entry.getValue() != null)
                .forEach(entry->params.put(entry.getKey(), TypeUtils.castToString(entry.getValue())));

        return execute(url, params);
    }

    protected JSONObject execute(String url, Map<String, String> params) throws NuomiErrorException {
        Map<String, String> realParams = buildRealParams(params);
        Request.Builder builder = new Request.Builder();
        String realUrl = configStorage.getBaseUrl() + url;
        builder.url(realUrl)
                .post(createFormBody(realParams));
        try {
            client.newCall(builder.build()).execute();
            Response response = client.newCall(builder.build()).execute();
            String responseString = response.body().string();
            JSONObject jsonObject = JSONObject.parseObject(responseString);
            int errno = jsonObject.getIntValue("errno");
            boolean isSuccess = errno == 0;
            logging(url, isSuccess, "POST " + realUrl + "\nBody:" + JSON.toJSONString(realParams), responseString);
            if (isSuccess) {
                return jsonObject;
            }
            throw new NuomiErrorException(errno, jsonObject.getString("msg"),
                    realUrl, realParams, responseString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private RequestBody createFormBody(Map<String, String> params) {
        FormBody.Builder formBodyBuilder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            formBodyBuilder.add(entry.getKey(), entry.getValue());
        }
        return formBodyBuilder.build();
    }

}
