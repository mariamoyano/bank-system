package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.enums.Status;

import java.math.BigDecimal;
import java.util.Date;

public class Checking extends Account {

    private BigDecimal balance;
    private String secretKey;
    private String primaryOwner;
    private String secondOwner;
    private BigDecimal minimumBalance;
    private BigDecimal penaltyFee;
    private BigDecimal monthlyMaintenanceFee;
    private Date creationDate;
    private Status status;

    public Checking(BigDecimal balance, String primaryOwner, String secondOwner, BigDecimal penaltyFee, BigDecimal balance1, String secretKey, String primaryOwner1, String secondOwner1, BigDecimal minimumBalance, BigDecimal penaltyFee1, BigDecimal monthlyMaintenanceFee, Date creationDate, Status status) {
        super(balance, primaryOwner, secondOwner, penaltyFee);
        this.balance = balance1;
        this.secretKey = secretKey;
        this.primaryOwner = primaryOwner1;
        this.secondOwner = secondOwner1;
        this.minimumBalance = minimumBalance;
        this.penaltyFee = penaltyFee1;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = creationDate;
        this.status = status;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public String getPrimaryOwner() {
        return primaryOwner;
    }

    @Override
    public void setPrimaryOwner(String primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    @Override
    public String getSecondOwner() {
        return secondOwner;
    }

    @Override
    public void setSecondOwner(String secondOwner) {
        this.secondOwner = secondOwner;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    @Override
    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
