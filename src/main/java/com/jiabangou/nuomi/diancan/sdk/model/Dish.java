package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 菜品
 * Created by freeway on 16/9/6.
 */
public class Dish implements Serializable {

    private String tp_dish_id;
    private int dish_count;
    private int dish_price;
    private String dish_name;

    public String getTp_dish_id() {
        return tp_dish_id;
    }

    public void setTp_dish_id(String tp_dish_id) {
        this.tp_dish_id = tp_dish_id;
    }

    public int getDish_count() {
        return dish_count;
    }

    public void setDish_count(int dish_count) {
        this.dish_count = dish_count;
    }

    public int getDish_price() {
        return dish_price;
    }

    public void setDish_price(int dish_price) {
        this.dish_price = dish_price;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "tp_dish_id='" + tp_dish_id + '\'' +
                ", dish_count=" + dish_count +
                ", dish_price=" + dish_price +
                ", dish_name='" + dish_name + '\'' +
                '}';
    }
}
