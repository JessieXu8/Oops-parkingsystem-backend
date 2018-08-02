//package com.oocl.parking.security;
//
//import com.oocl.parking.entities.Role;
//import com.oocl.parking.entities.User;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
///**
// * Created by linyuan on 2017/12/9.
// */
//public class MyUserDetails implements UserDetails {
//
//    private User user;
//
//    public MyUserDetails(User user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Role role = user.getRole();
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        if(role!=null) {
//            authorities.add(new SimpleGrantedAuthority(role.getRole()));
//            return authorities;
//        }
//
//        return AuthorityUtils.commaSeparatedStringToAuthorityList("");
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getName();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
