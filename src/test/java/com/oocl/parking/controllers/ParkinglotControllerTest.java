package com.oocl.parking.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.parking.dto.ParkinglotDto;
import com.oocl.parking.entities.Parkinglot;
import com.oocl.parking.services.ParkinglotService;
import com.sun.xml.internal.ws.api.pipe.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ParkinglotController.class)
public class ParkinglotControllerTest {

    @Autowired
    private ObjectMapper mapper;
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private ParkinglotService parkinglotService;
    
    @Test
    public void should_get_parkinglot_dto_list_when_get_parkinglots() throws Exception {
    // given
        Parkinglot parkinglot = new Parkinglot("test1", 10, "open");
        given(parkinglotService.getAllParkinglots()).willReturn(Arrays.asList(new ParkinglotDto(parkinglot)));
    // when
    // then
        mockMvc.perform(get("/api/v1/parkinglots").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("test1")))
                .andExpect(jsonPath("$[0].size", is(10)))
                .andExpect(jsonPath("$[0].status", is("open")))
        ;
    }

    @Test
    public void should_return_no_content_when_post_parkinglot() throws Exception{
    // given
        Parkinglot parkinglot = new Parkinglot("lot1", 10, "opem");
        given(parkinglotService.save(any(Parkinglot.class))).willReturn(true);
    // when
    // then
        mockMvc.perform(post("/api/v1/parkinglots").contentType(MediaType.APPLICATION_JSON_VALUE)
                                                        .content(mapper.writeValueAsString(parkinglot)))
                .andExpect(status().isNoContent());
    }
}