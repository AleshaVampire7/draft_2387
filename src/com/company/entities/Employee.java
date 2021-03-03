package com.company.entities;

import java.time.LocalDate;

public class Employee {
    protected int id;
    protected String name;
    protected int age;
    protected LocalDate dateofregistration;
    protected String status;
    protected String accname;
    protected String password;

    public Employee(String name, int age, LocalDate dateofregistration, String status, String accname, String password) {

        this.name = name;
        this.age = age;
        this.dateofregistration = dateofregistration;
        this.status=status;
        this.accname=accname;
        this.password=password;
    }
    public Employee(int id,String name,int age,String status){
        this.id=id;
        this.name=name;
        this.age=age;
        this.status=status;

    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateofregistration() {
        return dateofregistration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDateofregistration(LocalDate dateofregistration) {
        this.dateofregistration = dateofregistration;
    }


    public Employee(int id, String name, int age, LocalDate dateofregistration,String status,String accname,String password){
        this.id = id;
        this.name = name;
        this.age = age;
        this.dateofregistration = dateofregistration;
        this.status=status;
        this.accname=accname;
        this.password=password;

    }

    public Employee(){

        this.name = name;
        this.age = age;
        this.dateofregistration = dateofregistration;
        this.status=status;
        this.accname=accname;
        this.password=password;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dateofregistration=" + dateofregistration +
                ", status=" + status +
                ", accname='" + accname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
