package com.oocl.parking.repositories;

import com.oocl.parking.entities.Orders;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
    Orders findByCarId(String carId);
    List<Orders> findByBoyId(Long id);
    List<Orders> findByStatus(String status);
}
