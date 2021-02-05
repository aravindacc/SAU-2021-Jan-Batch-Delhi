package com.example.demo.controller;

import com.example.demo.model.Banking;
import com.example.demo.model.Employee;
import com.example.demo.service.BankingService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@RestController
public class BankingController {
    @Autowired
    private BankingService bankingService;

    @PostMapping("/login")
    @CrossOrigin("*")
    public ResponseEntity<String> login(@RequestBody Employee emp) {
        return new ResponseEntity<>(this.bankingService.login(emp), HttpStatus.OK);
    }

    @PostMapping("/register")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> register(@RequestBody Employee emp) {
        return new ResponseEntity<>(this.bankingService.register(emp), HttpStatus.OK);
    }


    @GetMapping("/emp/fake")
    @CrossOrigin("*")
    public List<Banking> getfake() {
        return this.bankingService.getFake();
    }


    @GetMapping("/emp")
    @CrossOrigin("*")
    public List<Employee> get() {
        return this.bankingService.get();
    }

    @GetMapping("/emp/{email}")
    @CrossOrigin("*")
    public List<Banking> getDetails(@PathVariable String email) {
        System.out.println(email);
        return this.bankingService.getByEmail(email);
    }

    @GetMapping("/emp/daily")
    @CrossOrigin("*")
    public List<Banking> getdaily() {
        return this.bankingService.getdaily();
    }


    @PostMapping("/emp")
    @CrossOrigin("*")
    public ResponseEntity<Boolean> insert(@RequestBody Banking banking) {
        return new ResponseEntity<>(this.bankingService.insert(banking), HttpStatus.OK);
    }
}
