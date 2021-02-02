package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entities.User;

public interface UserDao extends JpaRepository<User,Integer> {

    @Query(value="Select password from user where email=:email",nativeQuery = true)
    String getPasswordFromDb(@Param("email") String email);

}
