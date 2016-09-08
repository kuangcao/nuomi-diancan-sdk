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
    void uploadDishs(List<Dish> dishs) throws NuomiErrorException;

    /**
     * 更新菜品状态
     * @param dishStatuses
     * @throws NuomiErrorException
     */
    void updateDishOnlineStatus(List<DishStatus> dishStatuses) throws NuomiErrorException;
}
