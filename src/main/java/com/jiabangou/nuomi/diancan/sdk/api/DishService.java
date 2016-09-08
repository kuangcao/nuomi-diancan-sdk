package com.jiabangou.nuomi.diancan.sdk.api;

import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Dish;
import com.jiabangou.nuomi.diancan.sdk.model.DishStatus;

import java.util.List;

/**
 * 菜品服务
 * Created by freeway on 16/9/7.
 */
public interface DishService {

    /**
     * 上传菜品
     * @param dishs
     * @throws NuomiErrorException
     */
    void uploadDishes(List<Dish> dishs) throws NuomiErrorException;

    /**
     * 更新菜品状态, 用于混合的状态更新
     * @param dishStatuses
     * @throws NuomiErrorException
     */
    void updateDishOnlineStatuses(List<DishStatus> dishStatuses) throws NuomiErrorException;

    /**
     * 上线菜品
     * @param tpShopId
     * @param tpDishIds
     * @throws NuomiErrorException
     */
    void online(String tpShopId, List<String> tpDishIds) throws NuomiErrorException;

    /**
     * 上线菜品
     * @param tpShopId
     * @param tpDishId
     * @throws NuomiErrorException
     */
    void online(String tpShopId, String tpDishId) throws NuomiErrorException;

    /**
     * 删除菜品
     * @param tpShopId
     * @param tpDishIds
     * @throws NuomiErrorException
     */
    void delete(String tpShopId, List<String> tpDishIds) throws NuomiErrorException;

    /**
     * 删除菜品
     * @param tpShopId
     * @param tpDishId
     * @throws NuomiErrorException
     */
    void delete(String tpShopId, String tpDishId) throws NuomiErrorException;

    /**
     * 下线菜品
     * @param tpShopId
     * @param tpDishIds
     * @throws NuomiErrorException
     */
    void offline(String tpShopId, List<String> tpDishIds) throws NuomiErrorException;

    /**
     * 下线菜品
     * @param tpShopId
     * @param tpDishId
     * @throws NuomiErrorException
     */
    void offline(String tpShopId, String tpDishId) throws NuomiErrorException;

    /**
     * 菜品售罄
     * @param tpShopId
     * @param tpDishIds
     * @throws NuomiErrorException
     */
    void sellOut(String tpShopId, List<String> tpDishIds) throws NuomiErrorException;

    /**
     * 菜品售罄
     * @param tpShopId
     * @param tpDishId
     * @throws NuomiErrorException
     */
    void sellOut(String tpShopId, String tpDishId) throws NuomiErrorException;
}
