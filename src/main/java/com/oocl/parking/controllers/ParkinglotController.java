package com.oocl.parking.controllers;


import com.oocl.parking.dto.ParkinglotDto;
import com.oocl.parking.entities.Parkinglot;
import com.oocl.parking.exceptions.BadRequestException;
import com.oocl.parking.serviceImps.ParkinglotServiceImp;
import com.oocl.parking.services.ParkinglotService;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/parkinglots")
public class ParkinglotController {

    private ParkinglotService parkinglotService;

    @Autowired
    public ParkinglotController(ParkinglotService parkinglotService){
        this.parkinglotService = parkinglotService;
    }

    @GetMapping("")
    public List<ParkinglotDto> getAllParkinglots(){
        List<ParkinglotDto> parkinglotDtos = parkinglotService.getAllParkinglots();
        if(parkinglotDtos.size() == 0){
            throw new BadRequestException();
        }
        return parkinglotDtos;
    }

    @PostMapping("")
    public ResponseEntity createParkinglot(@RequestBody Parkinglot parkinglot){
        if(parkinglotService.save(parkinglot)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new BadRequestException();
    }

}
