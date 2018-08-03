package com.oocl.parking.controllers;

import com.oocl.parking.entities.Orders;
import com.oocl.parking.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    //用户停车请求
    @Transactional
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders parkOrder(@RequestBody Orders orders){
        return orderService.parkOrder(orders);
    }

    //用户请求取车
    @Transactional
    @PostMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders unparkOrder(@PathVariable Long id){
        return orderService.unparkOrder(id);
    }

    @Transactional
    @GetMapping("/search")
    public List<Orders> selectByParam(@RequestParam(required = false) Optional<Long> id,
                                    @RequestParam(required = false) Optional<String> carId,
                                    @RequestParam(required = false) Optional<String> type,
                                    @RequestParam(required = false) Optional<String> status){

        return orderService.selectByParam(id.orElse(null),carId.orElse(null),type.orElse(null),status.orElse(null));
    }

    @Transactional
    @GetMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Orders> getOrders(){
        return orderService.getOrders();
    }

    @Transactional
    @GetMapping(path = "/{parkingBoyId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Orders> getUncompletedOrdersByParkingBoyId(@PathVariable Long parkingBoyId){
        return orderService.getUncompletedOrdersByParkingBoyId(parkingBoyId);
    }

    @Transactional
    @GetMapping(path = "/nohandle",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Orders> getNoHandledOrders(){
        return orderService.getNoHandledOrders();
    }

    /*抢单or派单*/
    @Transactional
    @PatchMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders distributeOrderToParkingBoy(@PathVariable Long id,
                                              @RequestParam(required = false, value = "boyId") Optional<Long> boyId){
        return orderService.distributeOrderToParkingBoy(id,boyId.get());
    }
    /*根据订单停车*/
    @Transactional
    @PatchMapping(path = "/{id}/park",produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders distributeOrderToParkingLot(@PathVariable Long id,
                                              @RequestParam(required = false, value = "parkingLotId") Optional<Long> parkingLotId){
        return orderService.distributeOrderToParkingLot(id,parkingLotId.get());
    }

    

}
