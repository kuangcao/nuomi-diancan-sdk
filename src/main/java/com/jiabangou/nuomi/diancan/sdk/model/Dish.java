package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜品对象
 * Created by freeway on 16/9/7.
 */
public class Dish implements Serializable {

    @JSONField(name = "shop_id")
    private String shopId;
    @JSONField(name = "dish_code")
    private String id;
    @JSONField(name = "dish_thumb_image")
    private List<String> dishThumbImages;
    @JSONField(name = "dish_image")
    private List<String> dishImages;
    @JSONField(name="dish_type")
    private String categoryName;
    @JSONField(name="dish_name")
    private String name;
    @JSONField(name="dish_price")
    private int price;
    @JSONField(name="dish_unit")
    private String unit;
    @JSONField(name="dish_increase_unit")
    private int increase_unit;
    @JSONField(name="dish_sell_unit")
    private int sell_unit;
    @JSONField(name="sort_id")
    private int sort_id;
    @JSONField(name="dish_desc")
    private String desc;
    @JSONField(name="dish_score")
    private float score;
    @JSONField(name="dish_comment")
    private List<String> dish_comment;
    @JSONField(name="online_state")
    private int onlineState;
    @JSONField(name="dish_attr")
    private List<DishAttr> dishAttrs;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getDishThumbImages() {
        return dishThumbImages;
    }

    public void setDishThumbImages(List<String> dishThumbImages) {
        this.dishThumbImages = dishThumbImages;
    }

    public List<String> getDishImages() {
        return dishImages;
    }

    public void setDishImages(List<String> dishImages) {
        this.dishImages = dishImages;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getIncrease_unit() {
        return increase_unit;
    }

    public void setIncrease_unit(int increase_unit) {
        this.increase_unit = increase_unit;
    }

    public int getSell_unit() {
        return sell_unit;
    }

    public void setSell_unit(int sell_unit) {
        this.sell_unit = sell_unit;
    }

    public int getSort_id() {
        return sort_id;
    }

    public void setSort_id(int sort_id) {
        this.sort_id = sort_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public List<String> getDish_comment() {
        return dish_comment;
    }

    public void setDish_comment(List<String> dish_comment) {
        this.dish_comment = dish_comment;
    }

    public int getOnlineState() {
        return onlineState;
    }

    public void setOnlineState(int onlineState) {
        this.onlineState = onlineState;
    }

    public List<DishAttr> getDishAttrs() {
        return dishAttrs;
    }

    public void setDishAttrs(List<DishAttr> dishAttrs) {
        this.dishAttrs = dishAttrs;
    }

    public static class DishAttr implements Serializable {

        @JSONField(name = "attr_id")
        private String id;

        @JSONField(name = "name")
        private String name;

        @JSONField(name = "is_multi")
        private short isMulti;

        @JSONField(name = "options")
        private List<Option> options;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public short getIsMulti() {
            return isMulti;
        }

        public void setIsMulti(short isMulti) {
            this.isMulti = isMulti;
        }

        public List<Option> getOptions() {
            return options;
        }

        public void setOptions(List<Option> options) {
            this.options = options;
        }

        @Override
        public String toString() {
            return "DishAttr{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", isMulti=" + isMulti +
                    ", options=" + options +
                    '}';
        }
    }

    public static class Option implements Serializable {
        private String id;
        private String premium;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPremium() {
            return premium;
        }

        public void setPremium(String premium) {
            this.premium = premium;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Option{" +
                    "id='" + id + '\'' +
                    ", premium='" + premium + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Dish{" +
                "shopId='" + shopId + '\'' +
                ", id='" + id + '\'' +
                ", dishThumbImages=" + dishThumbImages +
                ", dishImages=" + dishImages +
                ", categoryName='" + categoryName + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", increase_unit=" + increase_unit +
                ", sell_unit=" + sell_unit +
                ", sort_id=" + sort_id +
                ", desc='" + desc + '\'' +
                ", score=" + score +
                ", dish_comment=" + dish_comment +
                ", onlineState=" + onlineState +
                '}';
    }
}
