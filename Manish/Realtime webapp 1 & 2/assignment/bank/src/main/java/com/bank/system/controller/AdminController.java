package com.bank.system.controller;

import com.bank.system.model.DepositTransaction;
import com.bank.system.model.TransactionReport;
import com.bank.system.model.User;
import com.bank.system.service.AdminService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("user/all")
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }


    @GetMapping("transaction/all")
    public List<TransactionReport> getAllTransactions() {
        return adminService.getAllTransactions();
    }

    @GetMapping("deposit/{date}") // needs to be in format (DD-MM-YYYY)
    public int selectDailyDeposit(@PathVariable("date") String  date) throws ParseException {
        Date currentDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        return adminService.getDailyDeposit(currentDate);
    }

    @GetMapping("deposit/week")
    public int selectWeeklyDeposit() {
        return adminService.getWeeklyDeposit();
    }

    @GetMapping("trackedUser")
    public List<User> selectTrackedUsers() {
        return adminService.getTrackedUsers();
    }

    @GetMapping("deposit/user/{userId}")
    public List<TransactionReport> getDepositsForUser(@PathVariable("userId") int userId) {
        return adminService.getDepositsForUser(userId);
    }
}
