# 百度糯米点餐SDK

[TOC]


## 公共参数说明

由于百度糯米点餐SDK有的概念显得不太符合常规命名，接口也都是由几部分人开发的，命名有些地方也不统一，所以在代码的实现中将其命名做了统一，用来消除歧义。

| 百度糯米参数命名 | 当前SDK命名 |
|--------|--------|
| service | clientId |
| token(用于生成签名的token) | clientSecret |
| token(生成的inttoken作为token摘要) | sign（其实就是签名） |
| site_name(/dish/info上传菜品接口) | dishClientKey |
| sign(/dish/info上传菜品接口) | dishClientSecret |
| shop_id(/dish/info上传菜品接口) | tp_shop_id |
| tp_merchant_id | tp_shop_id |
| dish_code(/dish/info上传菜品接口) | tp_dish_id |

## 附属帮助

可以访问如下URL信息来验证是否上传菜品成功：
<http://xxx.xxx.xxx.xxx:xxxx/diancai/getdishes?sequence=123&merchant_id=xxxxx>




## 百度糯米文档订正

### 3.3.1 获取订单详情

POST： /diancaiui/queryorder

| 参数 | 说明 | 必须 | 参数类型 | 示例/备注
|--------|--------|--------|--------|--------|
| tp_merchant_id | TP方门店id | Y | longint | |
| code_num | 6位取餐码 | N (menu_num、code_num二选一) | string | 123456  |
| menu_num | 手机号后四位 | N (menu_num、code_num二选一) | string | 0123  |
| pay_type | 支付模式 | N | int | 0:表示后付（默认值是0），1表示先付

返回字段说明

```json
{
    "errno": 0,
    "msg": "success",
    "sequence": "2",
    "data": {
        "order_id": 123456,
        "tp_merchant_id": 1455690,
        "mobile": "1455****690",//（中间四位打星号）
        " total_money ": 1000,
        "coupon_code": 123456,
        "menu_num":1234（手机后4位）
        "status": 40,
        "pay_detail":{
 "order_id":"44444","uid":"11111","tp_order_id":"131222","total_money":"1400","no_discount_money":"0","merchant_discount_money":"0","discount_money":"93","red_packet_money":"0","gift_card_money":"0","pay_money":"1307","vouchers_money":"0","merchant_gift_card_money":"0","storecard_money":"0","status":"200","mobile":"123123123","desc":"pay_success","tp_callback_params":{"sequence":160906000400723},"market_price":"0","current_price":"0","shoping_max_discount":"0","preferential_type":"3","coupon_code":"555555","pay_time":"1473136658","merchant_id":"3504530","sequence":"1473136659"},
        "order_time": 1455690,
        "table_info": , "5号桌", //桌号名称
        "table_id": "123abc", //TP方的桌号id
        "dishes": [
            {
                "tp_dish_id": "1396766",
                "dish_count": 2,
                "dish_price": 300,
                "dish_name": "烤鱼"
            },
            {
                "tp_dish_id": "1396767",
                "dish_count": 2,
                "dish_price": 300,
                "dish_name": "烤鱼"
            }
        ]
    }
}
```