package com.oocl.parking.services;

import com.oocl.parking.entities.Orders;
import com.oocl.parking.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Orders addOrder(Orders orders) {
        orders.setStatus("无人处理");
        if (orders.getType().equals("存车")){
            orders.setOperation("指派");
        }
        orderRepository.save(orders);
        return orders;
    }

    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    public Orders updateOrderById(Long id) {
        Orders orders = orderRepository.findById(id).get();
        orders.setStatus("停取中");
        orders.setOperation(null);
        return orders;
    }
}
