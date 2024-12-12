package com.example.practicaltest.service;

import com.example.practicaltest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(Long id);
    Employee save(Employee employee);
    void deleteById(Long id);
    List<Employee> findByName(String name);
    List<Employee> findByNameContaining(String name);
}
