package com.jatin.demo.Service;


import com.jatin.demo.Dao.UserDao;
import com.jatin.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;


    public String addUser(User user)
    {
        return this.userDao.addUser(user);
    }

    public  User getByAccountNumber(int accountNumber)
    {
        return this.userDao.getByAccountNumber(accountNumber);
    }

}
