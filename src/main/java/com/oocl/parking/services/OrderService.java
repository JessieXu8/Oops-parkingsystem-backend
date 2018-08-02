package com.oocl.parking.services;

import com.oocl.parking.entities.Orders;
import com.oocl.parking.exceptions.BadRequestException;
import com.oocl.parking.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ParkinglotService parkinglotService;

    public Orders parkOrder(Orders order) {
        order.setStatus("无人处理");
        order.setOperation("指派");
        orderRepository.save(order);

        return order;
    }

    public Orders unparkOrder(Long id) {
        Orders existOrder = orderRepository.findById(id).get();
        if (existOrder == null) {
            throw new BadRequestException("无效的订单号");
        }
        existOrder.setStatus("停取中");
        existOrder.setType("取车");
        return existOrder;
    }

    public List<Orders> getOrders() {
        return orderRepository.findAll()
                .stream()
                .filter(orders -> !(orders.getStatus().equals("订单完成")))
                .collect(Collectors.toList());
    }

    public Orders distributeOrderToParkingBoy(Long id, Long boyId) {
//        List<Orders> parkOrderList = orderRepository.findAll()
//                .stream()
//                .filter(order -> (order.getType().equals("停车") && (order.getBoyId().equals(boyId))))
//                .collect(Collectors.toList());
//        if (parkOrderList.size() != 0) {
//            return null;
//        }
        Orders order = orderRepository.findById(id).get();
        if (order.getBoyId() != null)
            throw new BadRequestException("order is already distribute");
        order.setBoyId(boyId);
        order.setStatus("停取中");
        order.setOperation(null);
        orderRepository.save(order);
        return order;
    }

    public Orders distributeOrderToParkingLot(Long id, Long parkingLotId) {
        Orders order = orderRepository.findById(id).get();
        order.setParkingLotId(parkingLotId);
        order.setStatus("停好");
//        parkinglotService.park(parkingLotId);
        orderRepository.save(order);
        return order;
    }

    public List<Orders> getNoHandledOrders() {
        return orderRepository.findAll()
                .stream()
                .filter(order -> order.getStatus().equals("无人处理"))
                .collect(Collectors.toList());
    }

    public List<Orders> getUncompletedOrdersByParkingBoyId(Long parkingBoyId) {
        return orderRepository.findByBoyId(parkingBoyId)
                .stream()
                .filter(orders -> !(orders.getStatus().equals("订单完成")))
                .collect(Collectors.toList());
    }


}
