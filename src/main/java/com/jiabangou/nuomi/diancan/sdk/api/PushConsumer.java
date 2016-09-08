package com.jiabangou.nuomi.diancan.sdk.api;

import com.jiabangou.nuomi.diancan.sdk.model.Order;
import com.jiabangou.nuomi.diancan.sdk.model.OrderPayStatus;

/**
 * 推送处理接口, 需要业务自己实现推送后的处理
 * Created by freeway on 16/7/19.
 */
public interface PushConsumer {

    int PUSH_ACTION_ADD_ORDER = 1;
    int PUSH_ACTION_CHANGE_ORDER_PAY_STATUS = 2;
    int PUSH_ACTION_GET_ORDER_STATUS = 3;

    /**
     * 创建订单接口
     * @param order
     * @return tpOrderId
     */
    String addOrder(Order order);

    /**
     * 支付状态回调
     * @param orderPayStatus
     * @return tpOrderId
     */
    String changeOrderPayStatus(OrderPayStatus orderPayStatus);

    /**
     * 获取订单状态
     * @param tpOrderId
     * @return
     */
    int getOrderStatus(Long tpOrderId);

}
