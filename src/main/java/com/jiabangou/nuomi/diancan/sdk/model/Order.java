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
    @JSONField(name = "tp_merchant_id")
    private Long tpShopid;
    @JSONField(name = "mobile")
    private String mobile;
    @JSONField(name = "total_money")
    private Integer totalMoney;
    @JSONField(name = "coupon_code")
    private Integer couponCode;
    @JSONField(name = "menu_num")
    private String mobileSuffix;
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

    public Long getTpShopid() {
        return tpShopid;
    }

    public void setTpShopid(Long tpShopid) {
        this.tpShopid = tpShopid;
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

    public String getMobileSuffix() {
        return mobileSuffix;
    }

    public void setMobileSuffix(String mobileSuffix) {
        this.mobileSuffix = mobileSuffix;
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
                ", tpShopid=" + tpShopid +
                ", mobile='" + mobile + '\'' +
                ", totalMoney=" + totalMoney +
                ", couponCode=" + couponCode +
                ", mobileSuffix='" + mobileSuffix + '\'' +
                ", status=" + status +
                ", orderTime=" + orderTime +
                ", tableName='" + tableName + '\'' +
                ", tableId='" + tableId + '\'' +
                ", payDetail=" + payDetail +
                ", dishes=" + dishes +
                '}';
    }

    /**
     * 菜品对象
     * Created by freeway on 16/9/6.
     */
    public static class Dish implements Serializable {

        @JSONField(name = "tp_dish_id")
        private String tpDishId;
        @JSONField(name = "dish_count")
        private int count;
        @JSONField(name = "dish_price")
        private int price;
        @JSONField(name = "dish_name")
        private String name;

        /**
         * 第三方菜品id
         * @return
         */
        public String getTpDishId() {
            return tpDishId;
        }

        /**
         * 设置第三方菜品id
         * @param tpDishId
         */
        public void setTpDishId(String tpDishId) {
            this.tpDishId = tpDishId;
        }

        /**
         * 数量
         * @return
         */
        public int getCount() {
            return count;
        }

        /**
         * 数量
         * @param count
         */
        public void setCount(int count) {
            this.count = count;
        }

        /**
         * 价格
         * @return
         */
        public int getPrice() {
            return price;
        }

        /**
         * 价格
         * @param price
         */
        public void setPrice(int price) {
            this.price = price;
        }

        /**
         * 菜品名称
         * @return
         */
        public String getName() {
            return name;
        }

        /**
         * 菜品名称
         * @param name
         */
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Dish{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    ", count=" + count +
                    ", tpDishId='" + tpDishId + '\'' +
                    '}';
        }

    }
}
