package com.jiabangou.nuomi.diancan.sdk.model;

import java.io.Serializable;

/**
 * 订单更新对象
 * Created by freeway on 16/9/6.
 */
public class OrderUpdate implements Serializable {

    private Long order_id;
    private String tp_order_id;
    private int status;
    private String update_time;
    /**
     * 是否是正餐, 正餐就是后付费
     * 1：后付 0：先付 默认为0
     */
    private int is_dinner;

}
