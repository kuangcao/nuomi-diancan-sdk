package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 订单支付状态
 * Created by freeway on 16/9/8.
 */
public class OrderPayStatus implements Serializable {

    @JSONField(name = "tp_order_id")
    private Long tpOrderId;

    @JSONField(name = "status")
    private int status;

    @JSONField(name = "total_money")
    private Integer totalMoney;

    @JSONField(name = "pay_money")
    private Integer payMoney;

    @JSONField(name = "pay_method")
    private Integer payMethod;

    @JSONField(name = "pay_status")
    private Integer payStatus;

    public Long getTpOrderId() {
        return tpOrderId;
    }

    public void setTpOrderId(Long tpOrderId) {
        this.tpOrderId = tpOrderId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    @Override
    public String toString() {
        return "OrderPayStatus{" +
                "tpOrderId=" + tpOrderId +
                ", status=" + status +
                ", totalMoney=" + totalMoney +
                ", payMoney=" + payMoney +
                ", payMethod=" + payMethod +
                ", payStatus=" + payStatus +
                '}';
    }
}
