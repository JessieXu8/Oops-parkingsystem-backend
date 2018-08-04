### 1 获取当前已分配停车场信息列表(显示在dashboard上)
+ action : get 
+ url : /api/v1/parkinglots/dashboard
+ response : [{parkinglots}]
```javascript
[
    {
        "id": 1,
        "name": "停车场A",
        "size": 10,
        "status": "open",
        "countOfCars": 0,
        "userId": 3,
        "userName": "Carol"
    },
    {
        "id": 2,
        "name": "停车场B",
        "size": 20,
        "status": "open",
        "countOfCars": 0,
        "userId": 3,
        "userName": "Carol"
    }
]
```
* * *


### 2 获取所有的停车场信息列表(包括未分配和已分配停车场)
+ action : get
+ url : /api/v1/parkinglots/
+ response : [{parkinglots}]
* * *

### 3 获取当前未分配停车场信息列表
+ action : get
+ url : /api/v1/parkinglots/noUser
+ response : [{parkinglots}]
* * *

### 4 根据停车场名，容量大于，容量小于进行组合搜索
+ action : get
+ url : /api/v1/parkinglots/combineSearch
+ response : [{parkinglots}]
* * *

### 5 新建停车场
+ action : post
+ url : /api/v1/parkinglots
+ request : 
```javascript
{
	"name":"停车场I",
	"size": 20
}
```
+ response :
```javascript
{
    "id": 8,
    "name": "停车场I",
    "size": 20,
    "status": "open",
    "countOfCars": 0,
    "userId": null,
    "userName": null
}
```
* * *

### 6 根据停车场唯一ID获取某个停车场的信息
+ action : get
+ url : /api/v1/parkinglots/{id}
+ response : {parkinglot}
* * *

### 7 根据停车场唯一ID修改某个停车场的状态（开放or注销）
+ action : patch
+ url : /api/v1/parkinglots/{id}
+ response : {parkinglot}
* * *

### 8 根据停车场唯一ID修改某个停车场的信息（停车场名，size）
+ action : put
+ url : /api/v1/parkinglots/{id}
+ response : {parkinglot}
* * *


