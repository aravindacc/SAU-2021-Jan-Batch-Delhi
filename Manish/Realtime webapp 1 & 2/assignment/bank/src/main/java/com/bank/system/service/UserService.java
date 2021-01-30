package com.bank.system.service;

import com.bank.system.dao.daoInterface.UserOperationsDao;
import com.bank.system.model.DepositTransaction;
import com.bank.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserOperationsDao userDao;

    public User addUser(User user) {
        return userDao.addUser(user);
    }

    public DepositTransaction makeTransaction(DepositTransaction transaction) {
        return userDao.makeTransaction(transaction);
    }

}
