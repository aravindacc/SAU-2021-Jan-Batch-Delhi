package com.saachi.employeeexample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saachi.employeeexample.model.Employee;
import com.saachi.employeeexample.repository.EmployeeRepository;


@RestController
public class EmployeeController {
	 @Autowired
	 EmployeeRepository employeeRepository;
	    
		/*
		 * @RequestMapping("/") public String index() { return
		 * "Welcome to the CRUD application!!"; }
		 */
	    
	    @PostMapping("/Employees")
	    public Employee addEmployee(@RequestBody Employee newEmployee) {
	        return employeeRepository.save(newEmployee);
	    }
	   
	  
	    @GetMapping("/Employees/phoneNumber/{phoneNumber}")
	    public Employee findByphoneNumber(@PathVariable String phoneNumber) {
	        return employeeRepository.findByphoneNumber(phoneNumber);
	    }
	    
	    @GetMapping("/Employees/location/{location}")
	    public List<Employee> findBylocation(@PathVariable String location) {
	        return employeeRepository.findBylocation(location);
	    }
	    
	    @GetMapping("/Employees/pincode/{pincode}")
	    public List<Employee> findBypincode(@PathVariable String pincode) {
	        return employeeRepository.findBypincode(pincode);
	    }
	    
	    @DeleteMapping("/Employees/firstName/{firstName}")
	    public void deleteByName(@PathVariable String firstName) {
	        employeeRepository.deleteByName(firstName);
	    }
	   
	}
