package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 桌子分类
 * Created by freeway on 16/9/7.
 */
public class TableCategory implements Serializable {

    @JSONField(name = "class_id")
    private Long id;

    @JSONField(name = "m_id")
    private Long tpShopId;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "status")
    private short status;

    /**
     * 桌位分类id
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * 桌位分类id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 商户id
     * @return
     */
    public Long getTpShopId() {
        return tpShopId;
    }

    /**
     * 商户id
     * @param tpShopId
     */
    public void setTpShopId(Long tpShopId) {
        this.tpShopId = tpShopId;
    }

    /**
     * 分类名称
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 分类名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableCategory that = (TableCategory) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return tpShopId != null ? tpShopId.equals(that.tpShopId) : that.tpShopId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tpShopId != null ? tpShopId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TableCategory{" +
                "id=" + id +
                ", tpShopId=" + tpShopId +
                ", name=" + name +
                ", status=" + status +
                '}';
    }
}
