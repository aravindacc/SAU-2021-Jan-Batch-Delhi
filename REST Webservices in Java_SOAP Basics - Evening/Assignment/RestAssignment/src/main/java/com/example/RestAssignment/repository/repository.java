package com.example.RestAssignment.repository;

import com.example.RestAssignment.UserDetails.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<UserDetails,Long> {
}
