package com.oocl.parking.services;

import com.oocl.parking.entities.Privilege;
import com.oocl.parking.entities.Role;
import com.oocl.parking.entities.User;
import com.oocl.parking.repositories.RoleRepository;
import com.oocl.parking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    public List<User> findAllUser(Pageable pageable) {

            return userRepository.findAll(pageable).getContent();

    }

   
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null  );
    }

    
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public void updateUserByRole(Long id,Role role) {
        User user = userRepository.findById(id).get();
        user.setRole(role);
        userRepository.save(user);
    }

    public List<Role> findAllRole(Pageable pageable) {
        return roleRepository.findAll(pageable).getContent();
    }

    public List<User> findAllUserByRole(String role, Pageable pageable) {

        List<Role> roleList = roleRepository.findByRole(role);
        Role userRole = new Role((long) -1,role);
        if(roleList!=null&&roleList.size()!=0){
            userRole.setId(roleList.get(0).getId());
        }

        User user = new User();
        user.setRole(userRole);

        ExampleMatcher matcher = ExampleMatcher.matching();

        Example<User> ex = Example.of(user, matcher);
      return userRepository.findAll(ex,pageable).getContent();
    }

    public List<Privilege> findAllAuthorities(Long id) {
          User user = userRepository.getOne(id);
          Role role = roleRepository.getOne(user.getRole().getId());
          List<Privilege> privileges = role.getPrivileges();
          return privileges;
    }
}
