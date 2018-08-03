package com.oocl.parking.services;

import com.oocl.parking.dto.UserDto;
import com.oocl.parking.dto.ParkinglotDto;
import com.oocl.parking.entities.*;
import com.oocl.parking.exceptions.BadRequestException;
import com.oocl.parking.exceptions.UserInfoException;
import com.oocl.parking.repositories.OrderRepository;
import com.oocl.parking.repositories.ParkinglotRepository;
import com.oocl.parking.repositories.RoleRepository;
import com.oocl.parking.repositories.UserRepository;
import com.oocl.parking.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ParkinglotRepository parkinglotRepository;

    @Autowired
    private OrderRepository orderRepository ;
    private  UserUtil userUtil = new UserUtil();
    public List<User> findAllUser(Pageable pageable) {

        return userRepository.findAll(pageable).getContent();

    }


    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null  );
    }


    public User addUser(User user) {
        String password =  userUtil.getRandomPassword();
        String encryptionPassword = userUtil.getEncryptionPassword(password);
        user.setPassword(encryptionPassword);
        user.setAccount_status("normal");
        User saveUser = userRepository.save(user);
        saveUser.setPassword(password);
        return saveUser;
    }
    public void updateUserByRole(Long id,Role role) {
        User user = userRepository.findById(id).get();
        List<Role> roleList = roleRepository.findByRole(role.getRole());
        if(roleList!=null&&roleList.size()!=0){
            user.setRole(roleList.get(0));
        }
        else
        {
            throw new BadRequestException("no role match!");
        }
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
        else
        {
            throw new BadRequestException("no role match!");
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

    public UserDto updateUser(Long id,User newUser) {
        User user = userRepository.getOne(id);
        if (newUser.getAccount_status() != null) {
            String status = user.getAccount_status().equals("normal") ? "abnormal" : "normal";
            user.setAccount_status(status);
        } else {
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            user.setName(newUser.getName());
            user.setPhone(newUser.getPhone());
            user.setPassword(newUser.getPassword());

        }
        UserDto userDto = new UserDto(user);
        userRepository.save(user);
        return userDto;
    }

    public List<ParkinglotDto> getParkinglots(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user == null || !user.getRole().getRole().equals("parkingboy")){
            return null;
        }
        return user.getParkinglots().stream().map(ParkinglotDto::new).collect(Collectors.toList());
    }

    public boolean setParkinglotToUser(Long userId, Long lotId) {
        User user = userRepository.findById(userId).orElse(null);
        Parkinglot parkinglot = parkinglotRepository.findById(lotId).orElse(null);
        if(user == null || parkinglot == null || !user.getRole().getRole().equals("parkingboy")){
            return false;
        }

        parkinglot.setUser(user);
        user.addParkinglot(parkinglot);

        parkinglotRepository.save(parkinglot);
        userRepository.save(user);
        return true;
    }
    public User validateUser(User user) {
        List<User> userList = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (userList != null && userList.size() != 0) {
            return userList.get(0);
        } else {
            throw new UserInfoException();
        }
    }

//    public  Optional<User> findUserName(String username) {
//        return userRepository.findByUsername(username);
//
//    }

    public List<User> selectByParam(String name,String email,String phone,Long id) {
        return userRepository.findByNameLikeOrEmailLikeOrPhoneLikeOrId("%"+name+"%","%"+email+"%","%"+phone+"%",id);
    }

    public List<User> selectAllAvailablePakingBoys() {
        Role role = roleRepository.findByRole("parkingboy").get(0);
        List<User> workingUsers = userRepository.findByworkStatusAndRole("working",role);
        List<Orders> orders = orderRepository.findByStatus("停取中");
        workingUsers.stream().filter(x ->{
            for(Orders o : orders){
                if(o.getBoyId()== x.getId())
                    return false;
            }
            return  true;
        });
        return  workingUsers;
    }

    public  Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}