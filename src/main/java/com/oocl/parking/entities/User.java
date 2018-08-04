package com.oocl.parking.entities;


import javax.persistence.*;
import java.util.List;

@Table(name = "user")
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String name;
    private  String username;
    private String password;
    private String email;
    private String phone;
    private String account_status;
    private String workStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Parkinglot> parkinglots;



    public User() {

    }

    public User(Long id){
        this.id = id;
    }

    public User(String name) {
        this.name = name;
    }

    public String getAccount_status() {
        return account_status;
    }

    public void setAccount_status(String account_status) {
        this.account_status = account_status;
    }

    public String getWork_status() {
        return workStatus;
    }

    public void setWork_status(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Parkinglot> getParkinglots() {
        return parkinglots;
    }

    public void setParkinglots(List<Parkinglot> parkinglots) {
        this.parkinglots = parkinglots;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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


    public User(String name, String username, String password, String email, String phone, String account_status, String workStatus, Role role) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.account_status = account_status;
        this.workStatus = workStatus;
        this.role = role;
    }

    public User(String name, String username, String password, String email, String phone, String account_status, String workStatus, Role role, List<Parkinglot> parkinglots) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.account_status = account_status;
        this.workStatus = workStatus;
        this.role = role;
        this.parkinglots = parkinglots;
    }

    public void addParkinglot(Parkinglot parkinglot) {
        parkinglots.add(parkinglot  );
    }

    public Parkinglot deleteParkinglot(Long id){
        Parkinglot parkinglot = parkinglots.stream().filter(lot->lot.getId()==id).findFirst().orElse(null);
        if(parkinglot == null || !parkinglot.isEmpty()){
            return null;
        }
        return parkinglot;
    }

    public boolean lotsAllFull(){
        for(Parkinglot lot: parkinglots){
            if(!lot.isFull()){
                return false;
            }
        }
        return true;
    }
}
