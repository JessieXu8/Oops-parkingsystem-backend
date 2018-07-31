package com.oocl.parking.services;

import com.oocl.parking.entities.Role;
import com.oocl.parking.entities.User;
import com.oocl.parking.repositories.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    public List<User> findAllUser(Pageable pageable) {
        return userRepository.findAll(pageable).getContent();
    }

   
    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public void updateUserByRole(Long id,Role role) {
        User user = userRepository.findById(id).get();
        user.setRole(role);
        userRepository.save(user);
    }
}
