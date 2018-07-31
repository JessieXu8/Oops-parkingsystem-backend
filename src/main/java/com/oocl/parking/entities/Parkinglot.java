package com.oocl.parking.entities;


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

    @OneToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;


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

    public Parkinglot(String name, int size, String status, Employee employee) {
        this.name = name;
        this.size = size;
        this.status = status;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getCountOfCars() {
        return countOfCars;
    }

    public void setCountOfCars(int countOfCars) {
        this.countOfCars = countOfCars;
    }
}
