package com.oocl.parking.dto;

import com.oocl.parking.entities.Role;
import com.oocl.parking.entities.User;

public class UserDto {
    private final Long id;
    private final String name;
    private final  String username;
    private final String password;
    private final  String email;
    private final String phone;
    private final String account_status;
    private final String work_status;
    private final Role role;

    public UserDto(Long id, String name, String username, String password, String email, String phone, String account_status, String work_status, Role role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.account_status = account_status;
        this.work_status = work_status;
        this.role = role;
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.account_status = user.getAccount_status();
        this.email = user.getEmail();
        this.work_status = user.getWork_status();
        this.role = user.getRole();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAccount_status() {
        return account_status;
    }

    public Role getRole() {
        return role;
    }

    public String getWork_status() {
        return work_status;

    }
}
