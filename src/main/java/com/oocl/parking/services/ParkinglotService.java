package com.oocl.parking.services;

import com.oocl.parking.dto.ParkinglotDto;
import com.oocl.parking.entities.Parkinglot;

import java.util.List;

public interface ParkinglotService {
    List<ParkinglotDto> getAllParkinglots();

    Boolean save(Parkinglot parkinglot);

    ParkinglotDto getById(long id);
}
