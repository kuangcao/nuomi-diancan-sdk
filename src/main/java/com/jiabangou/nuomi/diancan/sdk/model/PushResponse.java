package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 推送返回
 * Created by freeway on 16/9/8.
 */
public class PushResponse implements Serializable {

    private int errno = 0;

    private String msg = "success";

    private String sequence;

    private JSONObject data;

    public static PushResponse create() {
        return new PushResponse();
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PushResponse{" +
                "errno=" + errno +
                ", msg='" + msg + '\'' +
                ", sequence='" + sequence + '\'' +
                ", data=" + data +
                '}';
    }
}
