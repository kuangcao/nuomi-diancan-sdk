package com.jiabangou.nuomi.diancan.sdk.api;

import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;

/**
 * 餐厅商户服务
 * Created by freeway on 16/9/7.
 */
public interface MerchantService {


    /**
     * 绑定糯米和商户的id
     * @param merchantId 糯米门店id
     * @param tpMerchantId TP方商户id
     * @throws NuomiErrorException
     */
    void bind(Long merchantId, Long tpMerchantId) throws NuomiErrorException;
}
