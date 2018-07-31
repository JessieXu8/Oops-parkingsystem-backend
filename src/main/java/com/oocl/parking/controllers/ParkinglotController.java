package com.oocl.parking.controllers;


import com.oocl.parking.dto.ParkinglotDto;
import com.oocl.parking.entities.Parkinglot;
import com.oocl.parking.exceptions.BadRequestException;
import com.oocl.parking.services.ParkinglotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping(path = "/dashboard", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParkinglotDto> getDashboard(@PageableDefault(size = 6) Pageable page){
        List<ParkinglotDto> parkinglotDtos = parkinglotService.getDashboard(page, "open");
        if(parkinglotDtos.size() == 0){
            throw new BadRequestException("no parking lots available");
        }
        return parkinglotDtos;
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParkinglotDto> getAllParkinglots(Pageable page){
        List<ParkinglotDto> parkinglotDtos = parkinglotService.getAllParkinglots(page);
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

    @PutMapping(path = "/{id}/park", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity park(@PathVariable(value = "id") Long id){
        if(parkinglotService.park(id)){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        throw new BadRequestException("parked failed");
    }

    @DeleteMapping(path = "/{id}/park", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity unpark(@PathVariable(value = "id") Long id){
        if(parkinglotService.unpark(id)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new BadRequestException("unpark failed");
    }
}
