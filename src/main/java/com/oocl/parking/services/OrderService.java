package com.oocl.parking.services;

import com.oocl.parking.entities.Order;
import com.oocl.parking.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order addOrder(Order order) {
        order.setStatus("无人处理");
        if (order.getType().equals("存车")){
            order.setOperation("指派");
        }
        orderRepository.save(order);
        return order;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrderById(Long id) {
        Order order = orderRepository.findById(id).get();
        order.setStatus("停取中");
        order.setOperation(null);
        return order;
    }
}
