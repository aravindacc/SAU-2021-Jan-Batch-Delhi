package com.bank.system.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositTransaction {

    private int userId;
    private int currency;
    private int currencyNo;
    private int transactionId;

    public DepositTransaction() {
        this.userId = userId;
        this.currencyNo = currencyNo;
        this.currency = currency;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getCurrencyNo() {
        return currencyNo;
    }

    public void setCurrencyNo(int currencyNo) {
        this.currencyNo = currencyNo;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "DepositTransaction{" +
                "userId=" + userId +
                ", currency=" + currency +
                ", currencyNo=" + currencyNo +
                ", transactionId=" + transactionId +
                '}';
    }
}
