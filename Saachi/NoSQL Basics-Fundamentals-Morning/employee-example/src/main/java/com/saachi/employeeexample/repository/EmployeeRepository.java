package com.saachi.employeeexample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;


import com.saachi.employeeexample.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
	
	Employee findByphoneNumber(String phoneNumber);
	
	List<Employee> findBylocation(String location);
	
	List<Employee> findBypincode( String pincode);
	
	List deleteByName( String firstName);

	   
}
