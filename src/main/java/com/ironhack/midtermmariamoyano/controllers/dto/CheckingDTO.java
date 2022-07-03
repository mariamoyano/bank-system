package com.ironhack.midtermmariamoyano.controllers.dto;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.enums.Status;
import com.ironhack.midtermmariamoyano.models.AccountHolder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


public class CheckingDTO {
    @NotNull
    private Money balance;
    @NotNull
    private AccountHolder primaryOwner;
    private AccountHolder secondaryOwner;

    private String secretKey;
    private Money penaltyFee;
    private Money minimumBalance;
    private Money monthlyMaintenanceFee;
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolder secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Money getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(Money minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Money getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(Money monthlyMaintenanceFee) {
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

    public Money getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(Money penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}
