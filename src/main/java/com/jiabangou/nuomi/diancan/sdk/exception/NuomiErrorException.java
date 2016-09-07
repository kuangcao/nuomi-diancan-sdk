package com.jiabangou.nuomi.diancan.sdk.exception;

import java.util.Map;

/**
 * 糯米点餐错误异常
 * Created by freeway on 16/9/06.
 */
public class NuomiErrorException extends Exception {

    protected int code;
    protected String responseString;
    protected String requestUrl;
    protected Map<String, String> requestParams;

    public NuomiErrorException(int code, String message, String requestUrl, Map<String, String> requestParams, String responseString) {
        super(message);
        this.code = code;
        this.responseString = responseString;
        this.requestUrl = requestUrl;
        this.requestParams = requestParams;
    }

    public NuomiErrorException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getResponseString() {
        return responseString;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    @Override
    public String toString() {
        return "ElemeErrorException{" +
                "code=" + code + "\n" +
                ", message=" + getMessage() + "\n" +
                ", responseString='" + responseString + '\'' + "\n" +
                ", requestUrl='" + requestUrl + '\'' + "\n" +
                ", requestParams=" + requestParams +
                '}';
    }
}
