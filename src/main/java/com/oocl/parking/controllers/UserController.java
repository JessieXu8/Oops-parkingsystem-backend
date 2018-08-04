package com.oocl.parking.controllers;

import com.oocl.parking.dto.ParkinglotDto;
import com.oocl.parking.dto.UserDto;
import com.oocl.parking.entities.Privilege;
import com.oocl.parking.entities.Role;
import com.oocl.parking.entities.User;
import com.oocl.parking.exceptions.BadRequestException;
import com.oocl.parking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("")
    @ResponseBody
    public List<User> findAllUsers(@RequestParam(required=false,name="role")String role,Pageable pageable){
        System.out.println("role"+role);
        if(role!=""&&role!=null){
            return userService.findAllUserByRole(role,pageable);
        }else {
            return userService.findAllUser(pageable);
        }
    }


    @GetMapping("/role")
    @ResponseBody
    public List<Role> findAllRole(Pageable pageable){
        return userService.findAllRole(pageable);
    }

    @GetMapping("/id={id}")
    @ResponseBody
    public User findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/{id}/authorities")
    @ResponseBody
    public List<Privilege> getAllAuthorities(@PathVariable Long id){

        return userService.findAllAuthorities(id);
    }

    @PatchMapping("/{id}")
    @ResponseBody
    public UserDto updateUser(@PathVariable Long id, @RequestBody User user){

        return userService.updateUser(id,user);

    }
    @PostMapping("")
    @ResponseBody
    public  User addUser(@RequestBody User user){
        System.out.println(user.getRole());
        return userService.addUser(user);
    }
    @PatchMapping("/id={id}")
    @ResponseBody
    public ResponseEntity updateUserByRole(@PathVariable Long id,@RequestBody Role role){
        userService.updateUserByRole(id,role);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}/parkinglots")
    @ResponseBody
    public List<ParkinglotDto> getParkinglotsByUsers(@PathVariable Long id){
        List<ParkinglotDto> parkinglotDtos = userService.getParkinglots(id);
        if(parkinglotDtos == null){
            throw new BadRequestException("no parkinglots");
        }
        return parkinglotDtos;
    }

    @PatchMapping("/{userId}/parkinglots/{lotId}")
    @ResponseBody
    public ResponseEntity setParkinglotToUser(@PathVariable Long userId, @PathVariable Long lotId){
        if(userService.setParkinglotToUser(userId, lotId)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        throw new BadRequestException();
    }

    @DeleteMapping("/{userId}/parkinglots/{lotId}")
    @ResponseBody
    public User deleteParkinglotFromUser(@PathVariable Long userId, @PathVariable Long lotId){
        User user = userService.deleteParkinglotFromUser(userId, lotId);
        if(user == null){
            throw new BadRequestException();
        }
        return user;
    }
    
    @GetMapping("/search")
    public List<User> selectByParam(@RequestParam(required = false) Optional<String> name,
                                    @RequestParam(required = false) Optional<String> email,
                                    @RequestParam(required = false) Optional<String> phone,
                                    @RequestParam(required = false) Optional<Long> id){
        return userService.selectByParam(name.orElse(null),email.orElse(null),phone.orElse(null),id.orElse(null));

    }

    @GetMapping("/AvailableParkingBoys")
    public  List<User> selectAllAvailablePakingBoys(){

        return userService.selectAllAvailablePakingBoys();
    }
}
