package com.oocl.parking.services;

import com.oocl.parking.entities.Role;
import com.oocl.parking.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   
    public List<User> findAllUser(Pageable pageable) {
        return null;
    }

   
    public User findUserById(Long id) {
        return null;
    }

    
    public User addUser(User user) {
        return null;
    }

    public void updateUserByRole(Role role) {
    }
}
