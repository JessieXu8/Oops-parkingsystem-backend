//package com.oocl.parking.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.oocl.parking.entities.Role;
//import com.oocl.parking.entities.User;
//import com.oocl.parking.services.UserService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.web.config.EnableSpringDataWebSupport;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static io.restassured.RestAssured.given;
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
//import static org.hamcrest.core.StringContains.containsString;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//@EnableSpringDataWebSupport
//public class UserControllerTest {
//    @Autowired
//    private UserController userController;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @Autowired
//    private ObjectMapper mapper;
//
//
//    @Test
//    public void should_return_all_User() throws Exception {
//        //given
//        User user = new User("user-1");
//        List<User> userList = Arrays.asList(user);
//        //when
//        when(userService.findAllUser(any())).thenReturn(userList);
//        //then
//        ResultActions resultActions = mockMvc.perform(get("/api/v1/users").contentType(MediaType.APPLICATION_JSON));
//        resultActions.andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(1)))
//                .andExpect(jsonPath("$[0].name", is("user-1")));
//
//    }
//
//
//
//    @Test
//    public void should_return_one_User_when_input_User_id() throws Exception {
//        //given
//        User user = new User("user-1");
//        //when
//        when(userService.findUserById(any())).thenReturn(user);
//        //then
//        ResultActions resultActions = mockMvc.perform(get("/api/v1/users/id={param}", 1));
//        resultActions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is("user-1")));
//
//
//    }
//
//
//    @Test
//    public void should_return_new_User_when_input_User() throws Exception {
//        //given
//        User user = new User("user-1");
//        //when
//        when(userService.addUser(any(User.class))).thenReturn(user);
//        //then
//        ResultActions resultActions = mockMvc.perform(post("/api/v1/users", 1).contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(user)));
//        resultActions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.name", is("user-1")));
//
//
//    }
//
//
//    @Test
//    public void should_return_a_User_when_add_User_Role() throws Exception {
//        //given
//       Role role = new Role("parkingboy");
//       Long id = Long.valueOf(1);
//        //when
//
//        //then
//        ResultActions resultActions = mockMvc.perform(patch("/api/v1/users/id={param}", id).contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(role)));
//        resultActions.andExpect(status().is2xxSuccessful());
//
//
//    }
//
//
//
//
//
//
//
//}