package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.enums.Status;

import javax.persistence.*;
import java.util.Date;
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class StudentChecking extends Accounts {

    private String secretKey;
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private Status accountStatus;

    public StudentChecking() {

    }

    public StudentChecking( Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, String secretKey, Date creationDate, Status accountStatus) {
        super(balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.creationDate = creationDate;
        this.accountStatus = accountStatus;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Status getStatus() {
        return accountStatus;
    }

    public void setStatus(Status accountStatus) {
        this.accountStatus = accountStatus;
    }
}
