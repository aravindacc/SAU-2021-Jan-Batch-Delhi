package com.example.Entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="currency")
public class Currency {
    @Id
    private int id;

    private String c_id;
    private int amount;
    private String email;
    private String branchName;
    private String timeStamp;
    private Boolean isFake=false;

    public Boolean getIsfake() {
        return isFake;
    }

    public void setIsfake(Boolean isFake) {
        this.isFake = isFake;
    }

    public Currency(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrencyId() {
        return c_id;
    }

    public void setCurrencyId(String c_id) {
        this.c_id = c_id;
    }

    public int getamount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranchname() {
        return branchName;
    }

    public void setBranchname(String branchName) {
        this.branchName = branchName;
    }

    public String getTimestamp() {
        return timeStamp;
    }

    public void setTimestamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", c_id=" + c_id +
                ", amount=" + amount +
                ", email='" + email + '\'' +
                ", branchName='" + branchName + '\'' +
                ", timeStamp=" + timeStamp +
                ", isFake=" + isFake +
                '}';
    }
}
