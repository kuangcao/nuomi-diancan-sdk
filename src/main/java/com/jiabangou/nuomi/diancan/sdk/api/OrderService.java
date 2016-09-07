package com.jiabangou.nuomi.diancan.sdk.api;

import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Order;

/**
 * 订单服务
 * Created by freeway on 16/9/6.
 */
public interface OrderService {

    /**
     * 根据商户id和取餐码
     * @param tpMerchantId
     * @param codeNum
     * @return 先付逻辑
     * @throws NuomiErrorException
     */
    Order getByMchIdAndCodeNum(Long tpMerchantId, String codeNum) throws NuomiErrorException;

    Order getByMchIdAndCodeNum(Long tpMerchantId, String codeNum, int payType) throws NuomiErrorException;

    Order getByMchIdAndMobileSuffix(Long tpMerchantId, String mobileSuffix) throws NuomiErrorException;

    Order getByMchIdAndMobileSuffix(Long tpMerchantId, String mobileSuffix, int payType) throws NuomiErrorException;


}
