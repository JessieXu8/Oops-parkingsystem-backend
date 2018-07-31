package com.oocl.parking.controllers;


import com.oocl.parking.dto.ParkinglotDto;
import com.oocl.parking.entities.Parkinglot;
import com.oocl.parking.exceptions.BadRequestException;
import com.oocl.parking.services.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParkinglotDto> getAllParkinglots(){
        List<ParkinglotDto> parkinglotDtos = parkinglotService.getAllParkinglots();
        if(parkinglotDtos.size() == 0){
            throw new BadRequestException("no parking lots available");
        }
        return parkinglotDtos;
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createParkinglot(@RequestBody Parkinglot parkinglot){
        if(parkinglotService.save(parkinglot)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        throw new BadRequestException();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ParkinglotDto getById(@PathVariable Long id){
        ParkinglotDto parkinglotDto = parkinglotService.getById(id);
        if(parkinglotDto == null){
            throw new BadRequestException();
        }
        return parkinglotDto;
    }

    @PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity changeStatusById(@PathVariable Long id){
        if(parkinglotService.changeStatusById(id)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new BadRequestException();
    }
}
