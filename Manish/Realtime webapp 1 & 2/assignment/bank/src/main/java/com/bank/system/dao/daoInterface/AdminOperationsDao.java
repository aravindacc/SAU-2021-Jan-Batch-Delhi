package com.bank.system.dao.daoInterface;

import com.bank.system.model.DepositTransaction;
import com.bank.system.model.TransactionReport;
import com.bank.system.model.User;

import java.util.Date;
import java.util.List;

public interface AdminOperationsDao {

    List<User> selectAllUser();

    List<TransactionReport> selectAllTransactions();

    int selectDailyDeposit(Date date);

    int selectWeeklyDeposit();

    List<User> selectTrackedUsers();

    List<TransactionReport> getDepositsForUser(int userId);

}
