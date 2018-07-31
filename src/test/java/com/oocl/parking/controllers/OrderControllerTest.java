package com.oocl.parking.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.parking.entities.Order;
import com.oocl.parking.services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OrderController.class)
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private OrderService orderService;

    @Test
    public void should_return_order_when_call_addOrder()throws Exception {
        Order order = new Order("粤A123456", "存车");
        when(orderService.addOrder(any(Order.class))).thenReturn(order);
        mockMvc.perform(post("/orders").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(order)))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
//        System.out.println(order.getId());
    }

    @Test
    public void should_return_order_lists_when_call_getOrders()throws Exception{
        List<Order> orders = new ArrayList<>();
        Order order = new Order("粤A123456", "存车");
        order.setStatus("无人处理");
        order.setOperation("指派");
        orders.add(order);
        given(orderService.getOrders()).willReturn(orders);

        mockMvc.perform(get("/orders")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].carId").value("粤A123456"))
                .andExpect(jsonPath("$[0].type").value("存车"));
    }

    @Test
    public void should_update_order_operation_when_call_updateOrderById()throws Exception{
        List<Order> orders = new ArrayList<>();
        Order order = new Order("粤A123456", "存车");
        order.setId(1l);
        order.setStatus("无人处理");
        order.setOperation("指派");
        orders.add(order);
        Order newOrder = new Order("粤A123456", "存车","停取中","");
        newOrder.setId(1L);
        given(orderService.updateOrderById(order.getId())).willReturn(newOrder);

        mockMvc.perform(patch("/orders/1")).andExpect(status().isOk())
                .andExpect(jsonPath("carId").value("粤A123456"));
    }
}