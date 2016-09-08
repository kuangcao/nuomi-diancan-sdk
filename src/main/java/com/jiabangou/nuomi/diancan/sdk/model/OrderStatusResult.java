package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 订单状态
 * Created by freeway on 16/9/8.
 */
public class OrderStatusResult implements Serializable {

    @JSONField(name = "tp_order_id")
    private String tpOrderId;
    @JSONField(name = "status")
    private String status;

    public String getTpOrderId() {
        return tpOrderId;
    }

    public void setTpOrderId(String tpOrderId) {
        this.tpOrderId = tpOrderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderStatusResult{" +
                "tpOrderId='" + tpOrderId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
