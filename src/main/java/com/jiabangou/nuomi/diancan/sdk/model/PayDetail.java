package com.jiabangou.nuomi.diancan.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 支付详情
 * 各种金额间的关系说明：
 * 消费总金额=交易支付金额+百糯活动优惠金额+商家到店付优惠金额+使用的平台抵用券金额+使用的商家抵用券金额+使用的代金券金额+使用的储值卡金额；
 * 顾客应付金额=交易支付金额；
 * 商户应收金额=消费总金额-商家抵用券金额-商家到店付优惠金额
 * Created by freeway on 16/9/7.
 */
public class PayDetail implements Serializable {

    @JSONField(name = "order_id")
    private Long orderId;

    @JSONField(name = "tp_order_id")
    private Long tpOrderId;

    @JSONField(name = "total_money")
    private int totalMoney;

    @JSONField(name = "no_discount_money")
    private int noDiscountMoney;

    @JSONField(name = "merchant_discount_money")
    private int merchantDiscountMoney;

    @JSONField(name = "discount_money")
    private int discountMoney;

    @JSONField(name = "red_packet_money")
    private int redPacketMoney;

    @JSONField(name = "gift_card_money")
    private int giftCardMoney;

    @JSONField(name = "pay_money")
    private int payMoney;

    @JSONField(name = "vouchers_money")
    private int vouchersMoney;

    @JSONField(name = "merchant_gift_card_money")
    private int merchantGiftCardMoney;

    @JSONField(name = "storecard_money")
    private int storecardMoney;

    @JSONField(name = "status")
    private int status;

    @JSONField(name = "desc")
    private String desc;

    @JSONField(name = "pay_time")
    private Long payTime;

    @JSONField(name = "tp_callback_params")
    private TpCallbackParams tpCallbackParams = new TpCallbackParams();

    /**
     * 到店付订单id
     * @return
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置到店付订单id
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取第三方订单id
     * @return
     */
    public Long getTpOrderId() {
        return tpOrderId;
    }

    /**
     * 设置第三方订单id
     * @param tpOrderId
     */
    public void setTpOrderId(Long tpOrderId) {
        this.tpOrderId = tpOrderId;
    }

    /**
     * 消费总金额
     * @return
     */
    public int getTotalMoney() {
        return totalMoney;
    }

    /**
     * 消费总金额
     * @param totalMoney
     */
    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * 不可打折部分金额
     * @return
     */
    public int getNoDiscountMoney() {
        return noDiscountMoney;
    }

    /**
     * 不可打折部分金额
     * @param noDiscountMoney
     */
    public void setNoDiscountMoney(int noDiscountMoney) {
        this.noDiscountMoney = noDiscountMoney;
    }

    /**
     * 商家到店付优惠金额
     * @return
     */
    public int getMerchantDiscountMoney() {
        return merchantDiscountMoney;
    }

    /**
     * 商家到店付优惠金额
     * @param merchantDiscountMoney
     */
    public void setMerchantDiscountMoney(int merchantDiscountMoney) {
        this.merchantDiscountMoney = merchantDiscountMoney;
    }

    /**
     * 百糯活动优惠金额
     * @return
     */
    public int getDiscountMoney() {
        return discountMoney;
    }

    /**
     * 百糯活动优惠金额
     * @param discountMoney
     */
    public void setDiscountMoney(int discountMoney) {
        this.discountMoney = discountMoney;
    }

    /**
     * 使用的红包金额
     * @return
     */
    public int getRedPacketMoney() {
        return redPacketMoney;
    }

    /**
     * 使用的红包金额
     * @param redPacketMoney
     */
    public void setRedPacketMoney(int redPacketMoney) {
        this.redPacketMoney = redPacketMoney;
    }

    /**
     * 使用的平台抵用券金额
     * @return
     */
    public int getGiftCardMoney() {
        return giftCardMoney;
    }

    /**
     * 使用的平台抵用券金额
     * @param giftCardMoney
     */
    public void setGiftCardMoney(int giftCardMoney) {
        this.giftCardMoney = giftCardMoney;
    }

    /**
     * 交易支付金额
     * @return
     */
    public int getPayMoney() {
        return payMoney;
    }

    /**
     * 交易支付金额
     * @param payMoney
     */
    public void setPayMoney(int payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * 使用的代金券金额
     * @return
     */
    public int getVouchersMoney() {
        return vouchersMoney;
    }

    /**
     * 使用的代金券金额
     * @param vouchersMoney
     */
    public void setVouchersMoney(int vouchersMoney) {
        this.vouchersMoney = vouchersMoney;
    }

    /**
     * 使用的商家抵用券金额
     * @return
     */
    public int getMerchantGiftCardMoney() {
        return merchantGiftCardMoney;
    }

    /**
     * 使用的商家抵用券金额
     * @param merchantGiftCardMoney
     */
    public void setMerchantGiftCardMoney(int merchantGiftCardMoney) {
        this.merchantGiftCardMoney = merchantGiftCardMoney;
    }

    /**
     * 使用的储值卡金额
     * @return
     */
    public int getStorecardMoney() {
        return storecardMoney;
    }

    /**
     * 使用的储值卡金额
     * @param storecardMoney
     */
    public void setStorecardMoney(int storecardMoney) {
        this.storecardMoney = storecardMoney;
    }

    /**
     * 回调状态
     * 200：支付成功
     * 201：支付失败
     * 300：退款中
     * 500：退款成功
     * 501：退款失败
     * 参考 PayStatus
     * @return
     */
    public int getStatus() {
        return status;
    }

    /**
     *
     * 回调状态
     * 200：支付成功
     * 201：支付失败
     * 300：退款中
     * 500：退款成功
     * 501：退款失败
     * 参考 PayStatus
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 状态描述
     * pay_success：支付成功
     * refund：退款中
     * refund_done：退款完成
     * @return
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 状态描述
     * pay_success：支付成功
     * refund：退款中
     * refund_done：退款完成
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 支付时间
     * @return
     */
    public Long getPayTime() {
        return payTime;
    }

    /**
     * 支付时间
     * @param payTime
     */
    public void setPayTime(Long payTime) {
        this.payTime = payTime;
    }

    /**
     * 第三方透传参数 json字符串，例如{\"sequence\":\"1453124150183\",\"remark\":\"something\"}
     * 其中remark为用户下单时的备注信息，如“少辣”
     * @return
     */
    public TpCallbackParams getTpCallbackParams() {
        return tpCallbackParams;
    }

    /**
     * 第三方透传参数 json字符串，例如{\"sequence\":\"1453124150183\",\"remark\":\"something\"}
     * 其中remark为用户下单时的备注信息，如“少辣”
     * @param tpCallbackParams
     */
    public void setTpCallbackParams(TpCallbackParams tpCallbackParams) {
        this.tpCallbackParams = tpCallbackParams;
    }

    public static class TpCallbackParams {
        private long sequence;
        private String remark;

        public TpCallbackParams() {
            sequence = System.currentTimeMillis()/1000;
        }

        public long getSequence() {
            return sequence;
        }

        public void setSequence(long sequence) {
            this.sequence = sequence;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        @Override
        public String toString() {
            return "TpCallbackParams{" +
                    "sequence=" + sequence +
                    ", remark='" + remark + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PayDetail{" +
                "orderId=" + orderId +
                ", tpOrderId=" + tpOrderId +
                ", totalMoney=" + totalMoney +
                ", noDiscountMoney=" + noDiscountMoney +
                ", merchantDiscountMoney=" + merchantDiscountMoney +
                ", discountMoney=" + discountMoney +
                ", redPacketMoney=" + redPacketMoney +
                ", giftCardMoney=" + giftCardMoney +
                ", payMoney=" + payMoney +
                ", vouchersMoney=" + vouchersMoney +
                ", merchantGiftCardMoney=" + merchantGiftCardMoney +
                ", storecardMoney=" + storecardMoney +
                ", status=" + status +
                ", desc='" + desc + '\'' +
                ", payTime=" + payTime +
                ", tpCallbackParams=" + tpCallbackParams +
                '}';
    }
}
