package com.oocl.parking.controllers;

import com.oocl.parking.entities.Orders;
import com.oocl.parking.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Transactional
    @PostMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders addOrder(Orders orders){
        return orderService.addOrder(orders);
    }

    @Transactional
    @GetMapping(path = "/orders",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Orders> getOrders(){
        return orderService.getOrders();
    }

    @Transactional
    @PatchMapping(path = "/orders/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders updateOrderById(@PathVariable Long id){
        return orderService.updateOrderById(id);
    }

}
