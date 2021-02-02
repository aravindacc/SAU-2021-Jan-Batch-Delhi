package com.bank.system.dao.daoInterface;

import com.bank.system.model.DepositTransaction;
import com.bank.system.model.User;

public interface UserOperationsDao {

    User addUser(User user);
    DepositTransaction makeTransaction(DepositTransaction transaction);

}
