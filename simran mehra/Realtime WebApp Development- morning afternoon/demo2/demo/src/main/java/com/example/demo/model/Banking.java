package com.example.demo.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "currency")
public class Banking {
    @Id
    private int id;

    private String curr_id;
    private int amount;
    private String email;
    private String timestamp;
    private Boolean isCurrFake = false;

    public Banking() {

    }

    public Boolean getIsfake() {
        return isCurrFake;
    }

    public void setIsfake(Boolean isCurrFake) {
        this.isCurrFake = isCurrFake;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrency_id() {
        return curr_id;
    }

    public void setCurrency_id(String curr_id) {
        this.curr_id = curr_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", curr_id=" + curr_id +
                ", amount=" + amount +
                ", email='" + email + '\'' +
                ", timestamp=" + timestamp +
                ", isCurrFake=" + isCurrFake +
                '}';
    }
}

