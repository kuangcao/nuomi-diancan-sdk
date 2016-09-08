package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 菜品分类
 * Created by freeway on 16/9/8.
 */
public class DishCategory implements Serializable {

    @JSONField(name = "class_id")
    private Long id;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "parent_id")
    private int parentId;
    @JSONField(name = "level")
    private int level;
    @JSONField(name = "sort_id")
    private int sortId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSortId() {
        return sortId;
    }

    public void setSortId(int sortId) {
        this.sortId = sortId;
    }

    @Override
    public String toString() {
        return "DishCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", level=" + level +
                ", sortId=" + sortId +
                '}';
    }
}
