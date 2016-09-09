package com.jiabangou.nuomi.diancan.sdk.model;

/**
 * 推送事件
 * Created by freeway on 16/9/9.
 */
public enum PushAction {

    ADD_ORDER(1, "addOrder"),
    CHANGE_ORDER_PAY_STATUS(2, "changeOrderPayStatus"),
    GET_ORDER_STATUS(3, "getOrderStatus");

    private long code;
    private String name;

    PushAction(int code, String name) {
        this.code = code;
        this.name = name;
    }

}
