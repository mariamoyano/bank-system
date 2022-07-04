package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.enums.Status;

import javax.persistence.*;
import java.util.Date;
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class StudentChecking extends Accounts {


    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private Status accountStatus;

    public StudentChecking() {

    }

    public StudentChecking( Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, Date creationDate, Status accountStatus) {
        super(balance, secretKey, primaryOwner, secondaryOwner, penaltyFee);
        this.creationDate = creationDate;
        this.accountStatus = accountStatus;
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
