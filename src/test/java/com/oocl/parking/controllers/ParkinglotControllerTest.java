//package com.oocl.parking.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.oocl.parking.dto.ParkinglotDto;
//import com.oocl.parking.entities.Parkinglot;
//import com.oocl.parking.services.ParkinglotService;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.runner.RunWith;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.config.EnableSpringDataWebSupport;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import java.util.Arrays;
//import static org.hamcrest.Matchers.hasSize;
//import static org.hamcrest.Matchers.is;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.BDDMockito.given;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ParkinglotController.class)
//@EnableSpringDataWebSupport
//public class ParkinglotControllerTest {
//
//    @Autowired
//    private ObjectMapper mapper;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ParkinglotService parkinglotService;
//
//    @BeforeAll
//    void init(){
//    }
//
//    @Test
//    public void should_get_parkinglot_dto_list_when_get_parkinglots() throws Exception {
//    // given
//        Parkinglot parkinglot = new Parkinglot("test1", 10, "open");
//        given(parkinglotService.getAllParkinglots(any(Pageable.class), any(String.class))).willReturn(Arrays.asList(new ParkinglotDto(parkinglot)));
//    // when
//    // then
//        mockMvc.perform(get("/api/v1/parkinglots?page=0&size=1&status=open").contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is("test1")))
//                .andExpect(jsonPath("$[0].size", is(10)))
//                .andExpect(jsonPath("$[0].status", is("open")))
//        ;
//    }
//
//    @Test
//    public void should_return_is_created_when_post_parkinglot() throws Exception{
//    // given
//        Parkinglot parkinglot = new Parkinglot("lot1", 10, "opem");
//        given(parkinglotService.save(any(Parkinglot.class))).willReturn(new ParkinglotDto(parkinglot));
//    // when
//    // then
//        mockMvc.perform(post("/api/v1/parkinglots").contentType(MediaType.APPLICATION_JSON_VALUE)
//                                                        .content(mapper.writeValueAsString(parkinglot)))
//                .andExpect(status().is2xxSuccessful());
//    }
//
//    @Test
//    public void should_get_pakinglot_when_get_by_id() throws Exception{
//    // given
//        Parkinglot parkinglot = new Parkinglot(1L, "lot1", 10, "open");
//        given(parkinglotService.getById(anyLong())).willReturn(new ParkinglotDto(parkinglot));
//    // when
//    // then
//        mockMvc.perform(get("/api/v1/parkinglots/1").contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(jsonPath("name", is("lot1")))
//                .andExpect(jsonPath("size", is(10)))
//                .andExpect(jsonPath("status", is("open")))
//                ;
//    }
//
//    @Test
//    public void should_get_no_content_when_change_status_by_id() throws Exception{
//    // given
//        Parkinglot parkinglot = new Parkinglot(1L, "lot1", 10, "open");
//        given(parkinglotService.changeStatusById(1L)).willReturn(true);
//    // when
//    // then
//        mockMvc.perform(patch("/api/v1/parkinglots/1").contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isNoContent());
//    }
//
//}