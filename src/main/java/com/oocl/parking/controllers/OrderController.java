package com.oocl.parking.controllers;

import com.oocl.parking.entities.Orders;
import com.oocl.parking.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

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
    @PatchMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders updateOrderById(@PathVariable Long id){
        return orderService.updateOrderById(id);
    }

}
