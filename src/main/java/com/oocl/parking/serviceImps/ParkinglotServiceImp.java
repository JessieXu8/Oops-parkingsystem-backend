package com.oocl.parking.serviceImps;

import com.oocl.parking.dto.ParkinglotDto;
import com.oocl.parking.repositories.ParkinglotRepository;
import com.oocl.parking.services.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("parkinglotService")
public class ParkinglotServiceImp implements ParkinglotService {

    private ParkinglotRepository parkinglotRepository;

    @Autowired
    public ParkinglotServiceImp(ParkinglotRepository parkinglotRepository){
        this.parkinglotRepository = parkinglotRepository;
    }

    @Override
    public List<ParkinglotDto> getAllParkinglots() {
        return parkinglotRepository.findAll()
            .stream().map(ParkinglotDto::new).collect(Collectors.toList());
    }
}
