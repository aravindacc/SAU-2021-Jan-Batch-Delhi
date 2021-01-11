package com.example.au.couchbasedemo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.au.couchbasedemo.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String> {
	
	List findEmployeeUsingAddressandPincode(String location, String pincode);

}
