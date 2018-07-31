package com.oocl.parking.repositories;


import com.oocl.parking.entities.Parkinglot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ParkinglotRepository extends JpaRepository<Parkinglot, Long> {
    Page<Parkinglot> findAll(Pageable page);
}
