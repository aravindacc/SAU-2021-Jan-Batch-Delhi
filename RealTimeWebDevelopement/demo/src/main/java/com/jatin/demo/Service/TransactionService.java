package com.jatin.demo.Service;

import com.jatin.demo.Dao.TransactionDao;
import com.jatin.demo.Model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Repository
public class TransactionService {

    @Autowired
    TransactionDao transactionDao;

    public int addNewTransaction(Transaction transaction,int amount)
    {
        return this.transactionDao.addNewTransaction(transaction,amount);
    }

    public List<Transaction> getTransactionByAccount(int accountNumber)
    {
        return transactionDao.getTransactionByAccountNumber(accountNumber);
    }

    public List<Transaction> getTransactionByType(int type)
    {
        return transactionDao.getTransactions(type);
    }

}
