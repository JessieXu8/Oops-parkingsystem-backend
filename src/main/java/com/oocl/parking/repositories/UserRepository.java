package com.oocl.parking.repositories;

import com.oocl.parking.entities.Role;
import com.oocl.parking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User,Long> {

    List<User> findByUsernameAndPassword(String username, String password);


    Optional<User> findByUsername(String username);
    List<User> findByNameLikeOrEmailLikeOrPhoneLikeOrId(String name, String email,String phone,Long id);
    List<User> findByworkStatusAndRole(String workStatus,Role role);
    List<User> findByRole(Role role);
}
