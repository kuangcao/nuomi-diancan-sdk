package com.jiabangou.nuomi.diancan.sdk.api;

import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Table;
import com.jiabangou.nuomi.diancan.sdk.model.TableCategory;

import java.util.List;

/**
 * 餐厅商户服务
 * Created by freeway on 16/9/7.
 */
public interface ShopService {

    /**
     * 绑定糯米和商户的id
     * @param shopId 糯米门店id
     * @param tpShopId TP方商户id
     * @throws NuomiErrorException
     */
    void bind(Long shopId, Long tpShopId) throws NuomiErrorException;

    /**
     * 接入TP方所有门店桌号数据信息，每次调用为以每个店铺为单位的该店铺全量桌号分类以及桌号数据信息
     * @param tpShopId
     * @param tables
     * @param tableCategories
     * @throws NuomiErrorException
     */
    void syncTablesAndCategories(Long tpShopId, List<Table> tables, List<TableCategory> tableCategories)
        throws NuomiErrorException;

    /**
     * 更新基本信息
     * @throws NuomiErrorException
     */
    void updateBasicInfo() throws NuomiErrorException;

}
