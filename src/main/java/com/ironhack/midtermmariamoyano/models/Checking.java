package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.enums.Status;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Checking extends Accounts {



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
  //  @DecimalMin(value = "12", inclusive = true)
    private Money monthlyMaintenanceFee=new Money(new BigDecimal("12"));;
    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private Status accountStatus;


    public Checking() {
    }

    public Checking(  Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, Money minimumBalance, Money monthlyMaintenanceFee, Date creationDate, Status accountStatus) {
        super( balance, secretKey,primaryOwner, secondaryOwner, penaltyFee);
        setMinimumBalance(minimumBalance);
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = creationDate;
        this.accountStatus = accountStatus;
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
        return accountStatus;
    }

    public void setStatus(Status accountStatus) {
        this.accountStatus = accountStatus;
    }
}
