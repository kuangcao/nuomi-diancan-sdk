package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;

/**
 * 菜品对象
 * Created by freeway on 16/9/7.
 */
public class Dish implements Serializable {

    @JSONField(name = "shop_id")
    private String tpMerchantId;
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
    private int increaseUnit;
    @JSONField(name="dish_sell_unit")
    private int sellUnit;
    @JSONField(name="sort_id")
    private int sortId;
    @JSONField(name="dish_desc")
    private String desc;
    @JSONField(name="dish_score")
    private float score;
    @JSONField(name="dish_comment")
    private List<String> dishComment;
    @JSONField(name="online_state")
    private int onlineState;
    @JSONField(name="dish_attr")
    private List<DishAttr> dishAttrs;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getScore() {
        return score;
    }

    /**
     * 评分(可选)
     * @param score
     */
    public void setScore(float score) {
        this.score = score;
    }

    public int getOnlineState() {
        return onlineState;
    }

    /**
     * 是否在线（0：沽清，1：在线，2：已下架，3：已删除）
     * @param onlineState
     */
    public void setOnlineState(int onlineState) {
        this.onlineState = onlineState;
    }

    public List<DishAttr> getDishAttrs() {
        return dishAttrs;
    }

    public void setDishAttrs(List<DishAttr> dishAttrs) {
        this.dishAttrs = dishAttrs;
    }

    public String getTpMerchantId() {
        return tpMerchantId;
    }

    public void setTpMerchantId(String tpMerchantId) {
        this.tpMerchantId = tpMerchantId;
    }

    public int getIncreaseUnit() {
        return increaseUnit;
    }

    public void setIncreaseUnit(int increaseUnit) {
        this.increaseUnit = increaseUnit;
    }

    public int getSellUnit() {
        return sellUnit;
    }

    public void setSellUnit(int sellUnit) {
        this.sellUnit = sellUnit;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    public List<String> getDishComment() {
        return dishComment;
    }

    public void setDishComment(List<String> dishComment) {
        this.dishComment = dishComment;
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
                "tpMerchantId='" + tpMerchantId + '\'' +
                ", id='" + id + '\'' +
                ", dishThumbImages=" + dishThumbImages +
                ", dishImages=" + dishImages +
                ", categoryName='" + categoryName + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", increaseUnit=" + increaseUnit +
                ", sellUnit=" + sellUnit +
                ", sortId=" + sortId +
                ", desc='" + desc + '\'' +
                ", score=" + score +
                ", dishComment=" + dishComment +
                ", onlineState=" + onlineState +
                ", dishAttrs=" + dishAttrs +
                '}';
    }
}
