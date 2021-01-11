package com.example.au.couchbasedemo.repository;

import com.example.au.couchbasedemo.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    List<Employee> findByAddress(String location);

    List<Employee> findByPincode(String pincode);
}
