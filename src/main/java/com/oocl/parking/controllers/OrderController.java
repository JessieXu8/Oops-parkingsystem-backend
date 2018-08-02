package com.oocl.parking.controllers;

import com.oocl.parking.entities.Orders;
import com.oocl.parking.services.OrderService;
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
    public Orders addOrder(@RequestBody Orders orders){
        return orderService.addOrder(orders);
    }


    @Transactional
    @GetMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Orders> getOrders(){
        return orderService.getOrders();
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
