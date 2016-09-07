package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 订单信息
 * Created by freeway on 16/9/6.
 */
public class Order implements Serializable {

    @JSONField(name = "order_id")
    private Long orderId;
    @JSONField(name = "tpMerchantId")
    private Long tp_merchant_id;
    @JSONField(name = "mobile")
    private String mobile;
    @JSONField(name = "total_money")
    private Integer totalMoney;
    @JSONField(name = "coupon_code")
    private Integer couponCode;
    @JSONField(name = "menu_num")
    private String mobile_suffix;
    @JSONField(name = "status")
    private Integer status;
    @JSONField(name = "order_time")
    private Long orderTime;
    @JSONField(name = "table_info")
    private String tableName;
    @JSONField(name = "table_id")
    private String tableId;
    @JSONField(name = "pay_detail")
    private PayDetail payDetail;
    @JSONField(name = "dishes")
    private List<Dish> dishes;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getTp_merchant_id() {
        return tp_merchant_id;
    }

    public void setTp_merchant_id(Long tp_merchant_id) {
        this.tp_merchant_id = tp_merchant_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(Integer couponCode) {
        this.couponCode = couponCode;
    }

    public String getMobile_suffix() {
        return mobile_suffix;
    }

    public void setMobile_suffix(String mobile_suffix) {
        this.mobile_suffix = mobile_suffix;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public PayDetail getPayDetail() {
        return payDetail;
    }

    public void setPayDetail(PayDetail payDetail) {
        this.payDetail = payDetail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", tp_merchant_id=" + tp_merchant_id +
                ", mobile='" + mobile + '\'' +
                ", totalMoney=" + totalMoney +
                ", couponCode=" + couponCode +
                ", mobile_suffix='" + mobile_suffix + '\'' +
                ", status=" + status +
                ", orderTime=" + orderTime +
                ", tableName='" + tableName + '\'' +
                ", tableId='" + tableId + '\'' +
                ", payDetail=" + payDetail +
                ", dishes=" + dishes +
                '}';
    }
}
