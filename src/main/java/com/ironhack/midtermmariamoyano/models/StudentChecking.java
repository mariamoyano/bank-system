package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.enums.Status;

import java.math.BigDecimal;
import java.util.Date;

public class StudentChecking extends Account{
    private BigDecimal balance;
    private String secretKey;
    private String primaryOwner;
    private String secondOwner;
    private BigDecimal penaltyFee;
    private Date creationDate;
    private Status status;

    public StudentChecking(BigDecimal balance, String primaryOwner, String secondOwner, BigDecimal penaltyFee, BigDecimal balance1, String secretKey, String primaryOwner1, String secondOwner1, BigDecimal penaltyFee1, Date creationDate, Status status) {
        super(balance, primaryOwner, secondOwner, penaltyFee);
        this.balance = balance1;
        this.secretKey = secretKey;
        this.primaryOwner = primaryOwner1;
        this.secondOwner = secondOwner1;
        this.penaltyFee = penaltyFee1;
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

    @Override
    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    @Override
    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
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
