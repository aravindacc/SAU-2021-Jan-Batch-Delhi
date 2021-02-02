package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entities.Currency;
import com.example.Entities.User;
import com.example.dao.CurrencyDao;
import com.example.dao.UserDao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyDao cR;

    @Autowired
    private UserDao uR;


    public String login(User user) {
        String password=user.getPassword();
        String passwordExpected=this.uR.getPasswordFromDb(user.getEmail());
        
        if(passwordExpected.equals(password)){
            return "Matched";
        }
        else{
            return "Not Matched";
        }

    }

    public Boolean register(User user){

        try{
            this.uR.save(user);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    public List<Currency> getFake(){
        return this.cR.fakeuser();
    }

    public Boolean insert(Currency currency) {
        System.out.println(currency);

        String id=currency.getCurrencyId();
        int res=this.cR.checkUser(id);
        
        try {
            if (res > 0) {
                currency.setIsfake(true);
                this.cR.save(currency);

            }
            else 
            {
                this.cR.save(currency);
            }
            
            return true;
        }
        catch(Exception e){
            return false;
        }

    }


    public List<Currency> getdaily() {
        return this.cR.dailyresult(LocalDate.now());
    }



    public List<User> get() {
        return this.uR.findAll();
    }

    public List<Currency> getByEmail(String email) {
        return this.cR.findByEmail(email);
    }


}
