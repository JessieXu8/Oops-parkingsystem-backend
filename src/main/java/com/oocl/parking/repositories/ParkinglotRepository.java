package com.oocl.parking.repositories;


import com.oocl.parking.entities.Parkinglot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


public interface ParkinglotRepository extends JpaRepository<Parkinglot, Long> {
    Page<Parkinglot> findAll(Pageable page);

//    @Transactional
//    @Query("select Parkinglot as p from parkinglot where p.status=:status and p.userId<>0 ")
    List<Parkinglot> findByStatus(Pageable page,String status);

    List<Parkinglot> findByStatus(String status);
    List<Parkinglot> findByStatusAndUserNotNull(Pageable page, String status);
}
