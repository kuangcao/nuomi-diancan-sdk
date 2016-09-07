package com.jiabangou.nuomi.diancan.sdk.model;

/**
 * 订单状态
 * Created by freeway on 16/9/6.
 */
public interface OrderStatus {

    /**
     * 订单创建, 待到店确认, 待支付
     */
    int CREATED = 10;

    /**
     * 已到店，待商家确认
     */
    int IN_RESTAURANT_NEED_CONFIRM = 20;

    /**
     * 商家确认，待支付
     */
    int CONFIRMED = 30;

    /**
     * 已支付
     */
    int PAYED = 40;

    /**
     * 只限于先付 已打印小票（有打印机）/商户已确认接单（无打印机）
     */
    int PAY_FIRST_CONFIRMED = 42;

    /**
     * 只限于先付 已完成
     */
    int FINISHED = 48;

    /**
     * 商家取消订单
     */
    int cancel = 50;
    /**
     * 后付 加菜待确认
     */
    int ADD_DISH_NEED_CONFIRM = 60;

    /**
     * 后付 加菜成功
     */
    int ADD_DISH_SUCCESS = 61;

    /**
     * 后付 加菜失败
     */
    int ADD_DISH_FAILURE = 62;

    /**
     * 先付 退款中
     */
    int REFUNDING = 70;

    /**
     * 先付 退款成功
     */
    int REFUND_SUCCESS = 71;

    /**
     * 先付 退款失败
     */
    int REFUND_FAILURE = 72;

}
