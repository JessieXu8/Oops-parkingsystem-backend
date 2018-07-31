package com.oocl.parking.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "parkinglot")
@Entity
public class Parkinglot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int size;

    private int countOfCars;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;


    public Parkinglot() {
    }


    public Parkinglot(String name, int size, String status) {
        this.name = name;
        this.size = size;
        this.status = status;
    }

    public Parkinglot(Long id,String name, int size, String status) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.status = status;
    }

    public Parkinglot(String name, int size, String status, User user) {
        this.name = name;
        this.size = size;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCountOfCars() {
        return countOfCars;
    }

    public void setCountOfCars(int countOfCars) {
        this.countOfCars = countOfCars;
    }

    @JsonIgnore
    public boolean isEmpty(){
        return countOfCars==0;
    }

    @JsonIgnore
    public boolean isFull(){
        return countOfCars>=size;
    }
}
