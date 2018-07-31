package com.oocl.parking.servicesImpl;


import com.oocl.parking.entities.User;
import com.oocl.parking.services.UserService;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAllUser(Pageable pageable) {
        return null;
    }
}
