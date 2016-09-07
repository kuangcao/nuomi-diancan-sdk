package com.jiabangou.nuomi.diancan.sdk.model;

/**
 * 支付状态
 * Created by freeway on 16/9/6.
 */
public interface PayStatus {

    /**
     * 支付成功
     */
    int PAY_SUCCESS = 200;
    /**
     * 支付失败
     */
    int PAY_FAILURE = 201;
    /**
     * 退款中
     */
    int REFUNDING = 300;
    /**
     * 退款成功
     */
    int REFUND_SUCCESS = 500;
    /**
     * 退款失败
     */
    int REFUND_FAILURE = 501;

}
