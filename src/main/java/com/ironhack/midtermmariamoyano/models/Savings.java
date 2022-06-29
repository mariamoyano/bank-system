package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.classes.Money;
import com.ironhack.midtermmariamoyano.enums.Status;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Savings extends Account{

    private String secretKey;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "minimum_balance_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "minimum_balance_currency"))
    })
    @DecimalMin(value = "100", inclusive = true)
    private Money minimumBalance = new Money(new BigDecimal(1000));;

    private Date creationDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @DecimalMax(value = "0.5", inclusive = true)
    @Column(name = "interest_rate")
    private BigDecimal interestRate = new BigDecimal(0.025);

    public Savings() {

    }

    public Savings(long id,Money balance, String primaryOwner, String secondaryOwner, Money penaltyFee, String secretKey, Money minimumBalance, Date creationDate, Status status, BigDecimal interestRate) {
        super(id,balance, primaryOwner, secondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = creationDate;
        this.status = status;
        this.interestRate=interestRate;
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

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {

        this.interestRate = interestRate;

    }

    public void interestBalance(Money balance) {
        Period years = Period.between(creationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());
        int numberOfYears = years.getYears();
        if(numberOfYears>0){
            setBalance(new Money(balance.increaseAmount(balance.getAmount().multiply(BigDecimal.valueOf(numberOfYears)).multiply(interestRate))));
        }else{
            setBalance(balance);
        }

    }
}
