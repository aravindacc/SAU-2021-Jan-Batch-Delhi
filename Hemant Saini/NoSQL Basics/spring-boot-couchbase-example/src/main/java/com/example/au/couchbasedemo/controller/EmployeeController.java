package com.example.au.couchbasedemo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;
import java.util.List;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee newEmployee) {
		return employeeRepository.save(newEmployee);
    }
	
	@GetMapping("/employees/{empId}")
    public Optional<Employee> getEmployee(@PathVariable String empId) {
        if (employeeRepository.existsById(empId)) {
            return employeeRepository.findById(empId);
        } else
            return Optional.empty();
    }
	
	@GetMapping("/employees/address/{address}/pincode/{pincode}")
    public List<Employee> getEmployeeByAddressAndPincode(@PathVariable String address, @PathVariable String pincode) {
        return employeeRepository.findByAddressAndPincode(address, pincode);
        
    }
}
