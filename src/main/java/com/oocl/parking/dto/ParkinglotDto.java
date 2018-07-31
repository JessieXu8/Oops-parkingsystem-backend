package com.oocl.parking.dto;

import com.oocl.parking.entities.Parkinglot;

public class ParkinglotDto {
    private Long id;
    private String name;
    private int size;
    private String status;
    private int countOfCars;
    private Long employeeId;

    public ParkinglotDto() {
    }

    public ParkinglotDto(Parkinglot parkinglot) {
        this.id = parkinglot.getId();
        this.name = parkinglot.getName();
        this.size = parkinglot.getSize();
        this.status = parkinglot.getStatus();
        this.countOfCars = parkinglot.getCountOfCars();
        if(parkinglot.getEmployee() != null)
            this.employeeId = parkinglot.getEmployee().getId();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getStatus() {
        return status;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public int getCountOfCars() {
        return countOfCars;
    }
}
