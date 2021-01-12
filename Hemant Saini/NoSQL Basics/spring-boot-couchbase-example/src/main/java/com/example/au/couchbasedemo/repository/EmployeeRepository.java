package com.example.au.couchbasedemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.au.couchbasedemo.model.Blogs;
import com.example.au.couchbasedemo.model.Employee;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String>{
	List findByAddressAndPincode(String address, String pincode);
}
