package com.oocl.parking.controllers;

import com.oocl.parking.entities.Role;
import com.oocl.parking.entities.User;
import com.oocl.parking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("")
    @ResponseBody
    public List<User> findAllUsers(Pageable pageable){
    return userService.findAllUser(pageable);
    }

    @GetMapping("/id={id}")
    @ResponseBody
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("")
    @ResponseBody
    public  User addUser(@RequestBody User user){
        return userService.addUser(user);
    }
    @PatchMapping("/id={id}")
    @ResponseBody
    public ResponseEntity updateUserByRole(@PathVariable Long id,@RequestBody Role role){
        userService.updateUserByRole(id,role);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
