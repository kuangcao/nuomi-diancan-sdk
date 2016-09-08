package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 创建订单回调数据
 * Created by freeway on 16/9/8.
 */
public class OrderResult implements Serializable {

    @JSONField(name = "tp_order_id")
    private String tpOrderId;
    @JSONField(name = "order_status")
    private String orderStatus;

    /**
     * 第三方订单id
     * @return
     */
    public String getTpOrderId() {
        return tpOrderId;
    }

    /**
     * 第三方订单id
     * @param tpOrderId
     */
    public void setTpOrderId(String tpOrderId) {
        this.tpOrderId = tpOrderId;
    }

    /**
     * 订单状态
     * 参考OrderStatus
     * @return
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * 订单状态
     * 参考OrderStatus
     * @param orderStatus
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "tpOrderId='" + tpOrderId + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}

