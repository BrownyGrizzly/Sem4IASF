package com.example.practicaltest.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private BigInteger salary;

    public Employee() {

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public BigInteger getSalary() {
        return salary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSalary(BigInteger salary) {
        this.salary = salary;
    }

    public Employee(Long id, String name, Integer age, BigInteger salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
