package com.oocl.parking.services;

import com.oocl.parking.dto.ParkinglotDto;
import com.oocl.parking.entities.Parkinglot;
import com.oocl.parking.repositories.ParkinglotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("parkinglotService")
public class ParkinglotService {

    private ParkinglotRepository parkinglotRepository;

    @Autowired
    public ParkinglotService(ParkinglotRepository parkinglotRepository){
        this.parkinglotRepository = parkinglotRepository;
    }


    public List<ParkinglotDto> getAllParkinglots() {
        return parkinglotRepository.findAll()
            .stream().map(ParkinglotDto::new).collect(Collectors.toList());
    }


    public Boolean save(Parkinglot parkinglot) {
        if(parkinglotRepository.findById(parkinglot.getId()).orElse(null)!=null)
            return false;
        parkinglotRepository.save(parkinglot);
        return true;
    }


    public ParkinglotDto getById(long id) {
        Parkinglot parkinglot = parkinglotRepository.findById(id).orElse(null);
        if(parkinglot == null){
            return null;
        }
        return new ParkinglotDto(parkinglot);
    }


    public boolean changeStatusById(Long id) {
        Parkinglot parkinglot = parkinglotRepository.findById(id).orElse(null);
        if(parkinglot == null){
            return false;
        }

        if(parkinglot.getStatus().equals("open")) {
            parkinglot.setStatus("logout");
        }else{
            parkinglot.setStatus("open");
        }
        parkinglotRepository.save(parkinglot);
        return true;
    }
}
