package com.jiabangou.nuomi.diancan.sdk.model;

import java.io.Serializable;
import java.util.List;

/**
 * 订单信息
 * Created by freeway on 16/9/6.
 */
public class Order implements Serializable {

    private Long order_id;
    private Long tp_merchant_id;
    private String mobile;
    private Integer total_money;
    private Integer coupon_code;
    private String menu_num;
    private Integer status;
    private Long order_time;
    private String table_info;
    private String table_id;
    private List<Dish> dishes;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
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

    public Integer getTotal_money() {
        return total_money;
    }

    public void setTotal_money(Integer total_money) {
        this.total_money = total_money;
    }

    public Integer getCoupon_code() {
        return coupon_code;
    }

    public void setCoupon_code(Integer coupon_code) {
        this.coupon_code = coupon_code;
    }

    public String getMenu_num() {
        return menu_num;
    }

    public void setMenu_num(String menu_num) {
        this.menu_num = menu_num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Long order_time) {
        this.order_time = order_time;
    }

    public String getTable_info() {
        return table_info;
    }

    public void setTable_info(String table_info) {
        this.table_info = table_info;
    }

    public String getTable_id() {
        return table_id;
    }

    public void setTable_id(String table_id) {
        this.table_id = table_id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", tp_merchant_id=" + tp_merchant_id +
                ", mobile='" + mobile + '\'' +
                ", total_money=" + total_money +
                ", coupon_code=" + coupon_code +
                ", menu_num='" + menu_num + '\'' +
                ", status=" + status +
                ", order_time=" + order_time +
                ", table_info='" + table_info + '\'' +
                ", table_id='" + table_id + '\'' +
                ", dishes=" + dishes +
                '}';
    }
}
