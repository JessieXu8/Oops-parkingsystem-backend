package com.oocl.parking.services;

import com.oocl.parking.dto.ParkinglotDto;

import java.util.List;

public interface ParkinglotService {
    List<ParkinglotDto> getAllParkinglots();
}
