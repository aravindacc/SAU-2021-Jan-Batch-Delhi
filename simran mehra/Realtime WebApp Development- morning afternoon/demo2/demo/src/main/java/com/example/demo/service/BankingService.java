package com.example.demo.service;

import com.example.demo.model.Banking;
import com.example.demo.model.Employee;
import com.example.demo.repository.CurrencyRepo;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BankingService {

    @Autowired
    private CurrencyRepo currencyRepo;

    @Autowired
    private EmployeeRepository empRepo;


    public String login(Employee emp) {
        String password = emp.getPassword();
        String passwordOrg = this.empRepo.checkLogin(emp.getEmail());
        if (passwordOrg.equals(password)) {
            return "Matched";
        } else {
            return "Not Matched";
        }

    }

    public Boolean register(Employee emp) {

        try {
            System.out.println(emp);
            this.empRepo.save(emp);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Banking> getFake() {
        return this.currencyRepo.fakeuser();
    }

    public Boolean insert(Banking currency) {
        System.out.println(currency);

        String id = currency.getCurrency_id();
        int res = this.currencyRepo.usercheck(id);
        System.out.println(res);
        try {
            if (res > 0) {
                currency.setIsfake(true);
                this.currencyRepo.save(currency);

            } else {
                this.currencyRepo.save(currency);
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    public List<Banking> getdaily() {
        return this.currencyRepo.dailyresult(LocalDate.now());
    }


    public List<Employee> get() {
        return this.empRepo.findAll();
    }

    public List<Banking> getByEmail(String email) {
        return this.currencyRepo.findByEmail(email);
    }


}
