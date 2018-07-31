package com.oocl.parking.controllers;

import com.oocl.parking.entities.Order;
import com.oocl.parking.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public Order addOrder(Order order){
        return orderService.addOrder(order);
    }

    @Transactional
    @GetMapping(path = "/orders",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @Transactional
    @PatchMapping(path = "/orders/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Order updateOrderById(@PathVariable Long id){
        return orderService.updateOrderById(id);
    }

}
