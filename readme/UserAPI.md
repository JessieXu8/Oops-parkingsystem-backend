### 1 获取所有的用户详细信息
+ action : get 
+ url : /api/v1/users
+ response : [{user}]
* * *

### 2 获取所有的角色
+ action : get
+ url : /api/v1/users/role
+ response : [{role}]
* * *

### 3 通过ID号查找某个User
+ action : get
+ url : /api/v1/users/id={id}
+ response : {user}
* * *

### 4 获取某个User所有的Privilege列表
+ action : get
+ url : /api/v1/users/{id}/authorities
+ response : [{Privilege}]
* * *

### 5 修改某个员工信息
+ action : patch
+ url : /api/v1/users/{id}
+ request : {user}
+ response : {user}
* * *

### 6 新建员工
+ action : post
+ url : /api/v1/users
+ request : {user}
+ response : {user}
* * *

### 7 更改user的role
+ action : patch
+ url : /api/v1/users/id={id}
+ request : {role}
+ response : http status
* * *

### 8 获取某个user的parking lots
+ action : get
+ url : /api/v1/users/{id}/parkinglots
+ response : [{parkinglot}]
* * *

### 9 获取某个user管理的停车场车位是否为空
+ action : get
+ url : /api/v1/users/{id}/parkinglots/isfull
+ response : http status
* * *

### 10 给user分配停车场
+ action : patch
+ url : /api/v1/users/{userId}/parkinglots/{lotId}
+ response : http status
* * *

### 11 收回某user的parkinglot
+ action : delete
+ url : /api/v1/users/{userId}/parkinglots/{lotId}
+ response : http status
* * *

### 12 根据id，姓名，Email或电话号码进行组合搜索
+ action : get
+ url : /api/v1/users/search
```
    /api/v1/users/search?id=""
    /api/v1/users/search?name=""
    /api/v1/users/search?email=""
    /api/v1/users/search?phone=""
```
+ response : [{user}]
* * *

### 13 获取所有空闲的parking boys
+ action : get
+ url : /api/v1/users/AvailableParkingBoys
+ response : [{user}]
* * *

### 14 修改员工工作状态
+ action : patch
+ url : /api/v1/users/{id}/status
+ response : {user}
* * *