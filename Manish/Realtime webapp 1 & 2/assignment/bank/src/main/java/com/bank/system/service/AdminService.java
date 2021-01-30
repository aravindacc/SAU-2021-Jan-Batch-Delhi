package com.bank.system.service;

import com.bank.system.dao.daoInterface.AdminOperationsDao;
import com.bank.system.model.DepositTransaction;
import com.bank.system.model.TransactionReport;
import com.bank.system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminOperationsDao adminDao;

    public List<TransactionReport> getAllTransactions() {
        return adminDao.selectAllTransactions();
    }

    public int getDailyDeposit(Date date) {
        return adminDao.selectDailyDeposit(date);
    }
    public int getWeeklyDeposit() {
        return adminDao.selectWeeklyDeposit();
    }

    public List<User> getTrackedUsers() {
        return adminDao.selectTrackedUsers();
    }
    public List<TransactionReport> getDepositsForUser(int userId) {
        return adminDao.getDepositsForUser(userId);
    }

    public List<User> getAllUsers() {
        return adminDao.selectAllUser();
    }
}
