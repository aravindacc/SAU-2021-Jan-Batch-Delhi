package com.example.demo.repository;

import com.example.demo.model.Banking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CurrencyRepo extends JpaRepository<Banking, Integer> {

    @Query(value = "select * from currency where isCurrFake=true", nativeQuery = true)
    List<Banking> fakeuser();

    @Query(value = "select count(*) from currency where curr_id=:id", nativeQuery = true)
    int usercheck(@Param("id") String id);

    @Query(value = "Select * from currency where timestamp=:timestamp", nativeQuery = true)
    List<Banking> dailyresult(@Param("timestamp") LocalDate timestamp);

    @Query(value = "Select * from currency where email=:email", nativeQuery = true)
    List<Banking> findByEmail(@Param("email") String email);


}
