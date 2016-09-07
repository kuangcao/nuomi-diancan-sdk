package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 菜品对象
 * Created by freeway on 16/9/6.
 */
public class Dish implements Serializable {

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
