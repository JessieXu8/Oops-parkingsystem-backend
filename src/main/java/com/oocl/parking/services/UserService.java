package com.oocl.parking.services;

import com.oocl.parking.entities.User;

import java.awt.print.Pageable;
import java.util.List;

public interface UserService {
    List<User> findAllUser(Pageable pageable);
}
