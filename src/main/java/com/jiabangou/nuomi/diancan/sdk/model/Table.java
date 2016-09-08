package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 桌位信息
 * Created by freeway on 16/9/7.
 */
public class Table implements Serializable {

    @JSONField(name = "id")
    private Long id;

    @JSONField(name = "m_id")
    private Long tpShopId;

    @JSONField(name = "class_id")
    private Long categoryId;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "lp")
    private int minimumCapacity;

    @JSONField(name = "mp")
    private int maximumCapacity;

    @JSONField(name = "status")
    private short status;

    /**
     * 桌位ID
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 桌位ID
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 门店ID
     * @return
     */
    public Long getTpShopId() {
        return tpShopId;
    }

    /**
     * 门店ID
     * @param tpShopId
     */
    public void setTpShopId(Long tpShopId) {
        this.tpShopId = tpShopId;
    }

    /**
     * 桌位分类ID
     * @return
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * 桌位分类ID
     * @param categoryId
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 桌位名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 桌位名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 最小容纳人数
     * @return
     */
    public int getMinimumCapacity() {
        return minimumCapacity;
    }

    /**
     * 最小容纳人数
     * @param minimumCapacity
     */
    public void setMinimumCapacity(int minimumCapacity) {
        this.minimumCapacity = minimumCapacity;
    }

    /**
     * 最大容纳人数
     * @return
     */
    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    /**
     * 最大容纳人数
     * @param maximumCapacity
     */
    public void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    /**
     * 是否可用 (0可用，1不可用)
     * @return
     */
    public short getStatus() {
        return status;
    }

    /**
     * 是否可用 (0可用，1不可用)
     * @param status
     */
    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", tpShopId=" + tpShopId +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", minimumCapacity=" + minimumCapacity +
                ", maximumCapacity=" + maximumCapacity +
                ", status=" + status +
                '}';
    }
}
