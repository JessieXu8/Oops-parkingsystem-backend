package com.oocl.parking.entities;

import javax.persistence.*;

@Table(name = "orders")
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String carId;

    private String type;

    private String status;

    private String operation;

    private Long boyId;

    private Long parkingLotId;

    public Long getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(Long parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Long getBoyId() {
        return boyId;
    }

    public void setBoyId(Long boyId) {
        this.boyId = boyId;
    }

    public Orders() {
    }

    public Orders(String carId, String type) {
        this.carId = carId;
        this.type = type;
    }

    public Orders(String carId, String type, String status, String operation) {
        this.carId = carId;
        this.type = type;
        this.status = status;
        this.operation = operation;
    }

    public Orders(String carId, String type, String status, String operation, Long boyId, Long parkingLotId) {
        this.carId = carId;
        this.type = type;
        this.status = status;
        this.operation = operation;
        this.boyId = boyId;
        this.parkingLotId = parkingLotId;
    }
}
