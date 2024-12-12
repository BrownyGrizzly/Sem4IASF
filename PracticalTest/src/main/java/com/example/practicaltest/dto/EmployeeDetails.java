package com.example.practicaltest.dto;

import java.math.BigInteger;

public class EmployeeDetails {
    private String name;
    private Integer age;
    private BigInteger salary;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public BigInteger getSalary() {
        return salary;
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
}
