package com.oocl.parking.repositories;


import com.oocl.parking.entities.Parkinglot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface ParkinglotRepository extends JpaRepository<Parkinglot, Long> {
    Page<Parkinglot> findAll(Pageable page);

//    @Transactional
//    @Query("select Parkinglot as p from parkinglot where p.status=:status and p.userId<>0 ")
    List<Parkinglot> findByStatus(Pageable page,String status);

    List<Parkinglot> findByStatus(String status);
    List<Parkinglot> findByStatusAndUserNotNull(Pageable page, String status);

    List<Parkinglot> findAllByStatusAndUserNull(String status, Pageable page);

//    @Modifying(clearAutomatically = true)
//    @Transactional
//    @Query("select Parkinglot as p from parkinglot where p.size > :min and p.size < :max order by p.id")
//    List<Parkinglot> findBetween(int min, int max);

    List<Parkinglot> findAllBySizeGreaterThan(Pageable pageable, int min);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Parkinglot as p set p.status = :status where p.id = :id ")
    int changeStatus(@Param("id") Long id, @Param("status") String status);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Parkinglot as p set p.name = :name, p.size = :size where p.id = :id")
    int changeNameAndSizeById(@Param("id") Long id, @Param("size") int size, @Param("name") String name);

    Optional<Parkinglot> findByName(String name);
}
