package com.ironhack.midtermmariamoyano.models;


import java.math.BigDecimal;


public class CreditCard extends Account{
    private BigDecimal balance;
    private String primaryOwner;
    private String secondOwner;
    private BigDecimal penaltyFee;

    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    public CreditCard(BigDecimal balance, String primaryOwner, String secondOwner, BigDecimal penaltyFee, BigDecimal balance1, String primaryOwner1, String secondOwner1, BigDecimal penaltyFee1, BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, primaryOwner, secondOwner, penaltyFee);
        this.balance = balance1;
        this.primaryOwner = primaryOwner1;
        this.secondOwner = secondOwner1;
        this.penaltyFee = penaltyFee1;
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
