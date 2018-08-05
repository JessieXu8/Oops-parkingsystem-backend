//package com.oocl.parking.controllers;

//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.oocl.parking.entities.Orders;
//import com.oocl.parking.services.OrderService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(OrderController.class)
//public class OrdersControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper mapper;
//
//    @MockBean
//    private OrderService orderService;

//    @Test
//    public void should_return_order_when_call_addOrder()throws Exception {
//        Orders orders = new Orders("粤A123456", "存车");
//        when(orderService.parkOrder(any(Orders.class))).thenReturn(orders);
//        mockMvc.perform(post("/api/v1/orders").contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(mapper.writeValueAsString(orders)))
//                .andExpect(status().is2xxSuccessful())
//                .andDo(print());
//        System.out.println(orders.getId());
//    }

//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.oocl.parking.entities.Orders;
//import com.oocl.parking.services.OrderService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.ArrayList;
//import java.util.List;
//

//        mockMvc.perform(patch("/api/v1/orders/1")).andExpect(status().isOk())
//                .andExpect(jsonPath("carId").value("粤A123456"));
//    }
=======
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(OrderController.class)
//public class OrdersControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper mapper;
//
//    @MockBean
//    private OrderService orderService;
//
////    @Test
////    public void should_return_order_when_call_addOrder()throws Exception {
////        Orders orders = new Orders("粤A123456", "存车");
////        when(orderService.parkOrder(any(Orders.class))).thenReturn(orders);
////        mockMvc.perform(post("/api/v1/orders").contentType(MediaType.APPLICATION_JSON_VALUE)
////                .content(mapper.writeValueAsString(orders)))
////                .andExpect(status().is2xxSuccessful())
////                .andDo(print());
////        System.out.println(orders.getId());
////    }
////
////    @Test
////    public void should_return_order_lists_when_call_getOrders()throws Exception{
////        List<Orders> orders = new ArrayList<>();
////        Orders order = new Orders("粤A123456", "存车");
////        order.setStatus("无人处理");
////        order.setOperation("指派");
////        orders.add(order);
////        given(orderService.getOrders()).willReturn(orders);
////
////        mockMvc.perform(get("/api/v1/orders")).andExpect(status().isOk())
////                .andExpect(jsonPath("$[0].carId").value("粤A123456"))
////                .andExpect(jsonPath("$[0].type").value("存车"));
////    }
//
////    @Test
////    public void should_update_order_operation_when_call_updateOrderById()throws Exception{
////        List<Orders> orders = new ArrayList<>();
////        Orders order = new Orders("粤A123456", "存车");
////        order.setId(1l);
////        order.setStatus("无人处理");
////        order.setOperation("指派");
////        orders.add(order);
////        Orders newOrders = new Orders("粤A123456", "存车","停取中","");
////        newOrders.setId(1L);
////        given(orderService.distributeOrderToParkingBoy(order.getId(), boyId)).willReturn(newOrders);
////
////        mockMvc.perform(patch("/api/v1/orders/1")).andExpect(status().isOk())
////                .andExpect(jsonPath("carId").value("粤A123456"));
////    }

//}