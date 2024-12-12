package com.example.practicaltest.controller;

import com.example.practicaltest.entity.Employee;
import com.example.practicaltest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Show list of employees with the create form
    @GetMapping
    public String showEmployeePage(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("employee", new Employee()); // For the create form
        return "employeePage"; // Combined list and form template
    }

    // Handle employee creation
    @PostMapping
    public String createEmployee(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    // Show employee edit form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Employee not found");
        }
        model.addAttribute("employee", employee); // Pre-fill the form with employee details
        model.addAttribute("employees", employeeService.findAll()); // Show the list as well
        return "employeePage"; // Same template for edit
    }

    // Handle employee edit
    @PostMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id, @ModelAttribute Employee updatedEmployee) {
        Employee existingEmployee = employeeService.findById(id);
        if (existingEmployee == null) {
            throw new RuntimeException("Employee not found");
        }

        // Update the existing employee's details
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setAge(updatedEmployee.getAge());
        existingEmployee.setSalary(updatedEmployee.getSalary());

        employeeService.save(existingEmployee); // Save the updated employee
        return "redirect:/employees";
    }

    // Handle employee deletion
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    // Search employees by name
    @PostMapping("/search")
    public String searchEmployees(@RequestParam String name, Model model) {
        model.addAttribute("employees", employeeService.findByNameContaining(name));
        model.addAttribute("employee", new Employee()); // Retain the form
        return "employeePage";
    }
}
