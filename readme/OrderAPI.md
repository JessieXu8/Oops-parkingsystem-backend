### 1 请求停车
+ action : post 
+ url : /api/v1/orders/
+ request : order 
```javascript
{

    "carId":"xin粤234",
    "type":"存车"

}
```
+ response : order
```javascript
{
        "id": 1,
        "carId": "粤A12345",
        "type": "存车",
        "status": "无人处理",
        "operation": "指派",
        "boyId": null,
        "parkinglotId": null,
        "createdTime": null
}
```
* * *

### 2 boy抢单
+ action : patch 
+ url : /api/v1/orders/{id}?boyId=1
+ request : order 
```javascript
{

    "carId":"xin粤234",
    "type":"存车"

}
```
+ response :order
```javascript
{
    "id": 1,
    "carId": "粤A12345",
    "type": "存车",
    "status": "停取中",
    "operation": null,
    "boyId": 1,
    "parkinglotId": null,
    "createdTime": null
}
```
* * *

### 3 boy停车
+ action : patch 
+ url : /api/v1/orders/{id}/park?parkingLotId=1
+ response : order 
```javascript
{
    "id": 1,
    "carId": "粤A12345",
    "type": "存车",
    "status": "停取中",
    "operation": null,
    "boyId": 1,
    "parkinglotId": 1,
    "createdTime": null
}
```
* * *

### 4 请求取车
+ action : post
+ url : /api/v1/orders/{id}
+ response : order 
```javascript
{
    "id": 1,
    "carId": "粤A12345",
    "type": "取车",
    "status": "停取中",
    "operation": null,
    "boyId": 1,
    "parkinglotId": 1,
    "createdTime": null
}
```
* * *

### 5 boy取车
+ action : delete
+ url : /api/v1/parkinglots/{id}/park/{parkingLotId}
+ response : HTTP status 204
* * *

### 6 获取所有未完成订单（包括状态为停取中和无人处理的订单）
+ action : get
+ url : /api/v1/orders
+ response : [{order}]
* * *

### 7 获取所有无人处理订单
+ action : get
+ url : /api/v1/orders/nohandle
+ response : [{order}]
* * *

### 8 获取某个特定订车员的已完成订单
+ action : get
+ url : /api/v1/orders/complete/{parkingBoyId}
+ response : [{order}]
* * *

### 9 获取某个特定停车员的所有未完成订单
+ action : get
+ url : /api/v1/orders/{parkingBoyId}
+ response : [{order}]
* * *

###  10 获取boy历史订单
+ action : get 
+ url : /api/v1/orders/complete/{parkingBoyId}
+ response : [{order}]
* * *

### 11 根据订单号，车牌号，类型或状态进行组合搜索
+ action : get
+ url : 
```
        /api/v1/orders/search?id=""
        /api/v1/orders/search?carId=""
        /api/v1/orders/search?type=""
        /api/v1/orders/search?status=""
```
+ response : [{order}]
* * *


