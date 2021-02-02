package com.example.au.couchbasedemo.controller;

import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    // add employee
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // get all employee
    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    // get employee by id
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable String id) {
        return employeeRepository.existsById(id) ?
                employeeRepository.findById(id) : Optional.empty();
    }

    // delete employee by id
    @DeleteMapping("/employee/{id}")
    public void deleteById(@PathVariable String id) {
        employeeRepository.deleteById(id);
    }

    // get employee by location
    @GetMapping("/employee/location/{location}")
    public List<Employee> getEmployeeByLocation(@PathVariable String location) {
        return employeeRepository.findByAddress(location);
    }

    // get employee by pincode
    @GetMapping("/employee/pincode/{pincode}")
    public List<Employee> getEmployeeByPincode(@PathVariable String pincode) {
        return employeeRepository.findByPincode(pincode);
    }
}
