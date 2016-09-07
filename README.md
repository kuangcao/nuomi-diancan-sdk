# 百度糯米点餐SDK

[TOC]


## 公共参数说明

由于百度糯米点餐SDK有的概念显得不太符合常规命名。所以，在SDK的实现上将名字有所调整，用来消除歧义。

| 百度糯米文档命名 | 当前SDK命名 |
|--------|--------|
| service | app_key |
| token(用于生成签名的token) | app_secret |
| token(生成的inttoken作为token摘要) | sign（其实就是签名） |

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
        "pay_detail":"[]", uid unset调
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