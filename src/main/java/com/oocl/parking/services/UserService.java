package com.oocl.parking.services;


import com.oocl.parking.entities.User;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service("userService")
public class UserService {
    public List<User> findAllUser(Pageable pageable) {
        return null;
    }
}
