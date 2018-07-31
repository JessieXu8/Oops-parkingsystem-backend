package com.oocl.parking.controllers;

import com.oocl.parking.entities.Start;
import com.oocl.parking.repositories.StartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://10.222.232.140:3000")
@RestController
@RequestMapping("/start")
public class StartController {

    private StartRepository startRepository;

    @Autowired
    public StartController (StartRepository startRepository){
        this.startRepository = startRepository;
    }

    @GetMapping("/begin")
    public String getHello(){
        return "hello world";
    }
    //@CrossOrigin(origins = "http://10.222.232.140:3000")
    @GetMapping("")
    public List<Start> getStart(){
        List<Start> start = startRepository.findAll();
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return start;
    }

    @PostMapping("")
    public ResponseEntity postStart(@RequestBody Start start){
        startRepository.save(start);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
