package com.bank.system.controller;

import com.bank.system.model.DepositTransaction;
import com.bank.system.model.User;
import com.bank.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED) ;
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> makeTransaction(@RequestBody DepositTransaction transaction) {
        if (transaction == null) {
            return new ResponseEntity<>(null, HttpStatus.valueOf(404));
        }
        return new ResponseEntity<>(userService.makeTransaction(transaction), HttpStatus.ACCEPTED) ;
    }



}
