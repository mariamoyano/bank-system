package com.ironhack.midtermmariamoyano.models;

import java.math.BigDecimal;

public abstract class Account {
    private BigDecimal balance;
    private String primaryOwner;
    private String secondOwner;
    private BigDecimal penaltyFee;

    public Account(BigDecimal balance, String primaryOwner, String secondOwner, BigDecimal penaltyFee) {
        this.balance = balance;
        this.primaryOwner = primaryOwner;
        this.secondOwner = secondOwner;
        this.penaltyFee = penaltyFee;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(String primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public String getSecondOwner() {
        return secondOwner;
    }

    public void setSecondOwner(String secondOwner) {
        this.secondOwner = secondOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}
