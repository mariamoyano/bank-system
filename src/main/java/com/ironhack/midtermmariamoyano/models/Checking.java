package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Checking extends Account {

    private String secretKey;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
            })
    private Money minimumBalance = new Money(new BigDecimal("250"));;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "monthly_maintenance_fee_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "monthly_maintenance_fee_currency"))
    })
    @DecimalMin(value = "12", inclusive = true)
    private Money monthlyMaintenanceFee=new Money(new BigDecimal("12"));;
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private Status status;


    public Checking() {
    }

    public Checking( long id, Money balance, String primaryOwner, String secondaryOwner, Money penaltyFee, String secretKey, Money minimumBalance, Money monthlyMaintenanceFee, Date creationDate, Status status) {
        super(id, balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        setMinimumBalance(minimumBalance);
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = creationDate;
        this.status = status;
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
        BigDecimal minimumAmount= new BigDecimal(250);
        if(minimumBalance.getAmount().compareTo(minimumAmount) == -1){
            BigDecimal newBalance = getBalance().decreaseAmount(new BigDecimal(40));
            setBalance(new Money(newBalance));
            this.minimumBalance= new Money(minimumAmount);
        }else {
            this.minimumBalance=minimumBalance;
        }
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
}
