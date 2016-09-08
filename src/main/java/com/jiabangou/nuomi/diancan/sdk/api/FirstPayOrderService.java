package com.jiabangou.nuomi.diancan.sdk.api;

import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Order;

import java.util.List;

/**
 * 先付订单服务
 * Created by freeway on 16/9/6.
 */
public interface FirstPayOrderService {

    /**
     * 根据商户id和取餐码
     * @param tpShopId
     * @param codeNum
     * @return 先付逻辑
     * @throws NuomiErrorException
     */
    Order getByShopIdAndCodeNum(Long tpShopId, String codeNum) throws NuomiErrorException;

    /**
     * 根据商户id和手机号后四位
     * @param tpShopId 第三方店铺id
     * @param mobileSuffix 手机号后四位
     * @return
     * @throws NuomiErrorException
     */
    Order getByShopIdAndMobileSuffix(Long tpShopId, String mobileSuffix) throws NuomiErrorException;

    /**
     * 确认接单
     * @param orderId
     * @param tpOrderId
     * @throws NuomiErrorException
     */
    void confirm(Long orderId, String tpOrderId) throws NuomiErrorException;

    /**
     * 取消订单
     * @param orderId
     * @param tpOrderId
     * @throws NuomiErrorException
     */
    void cancel(Long orderId, String tpOrderId) throws NuomiErrorException;

    /**
     * 返回TP商户所有已支付未完成的订单，只返回昨天到现在的订单
     * @param tpShopId
     * @return
     * @throws NuomiErrorException
     */
    List<Order> getUnfinishedOrders(Long tpShopId) throws NuomiErrorException;


}
