package com.ironhack.midtermmariamoyano.models;
import com.ironhack.midtermmariamoyano.classes.Money;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.text.DecimalFormat;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Account{

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "credit_limit_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "credit_limit_currency"))
    })
    @DecimalMin(value = "100", inclusive = true)
    @DecimalMax(value = "100000", inclusive = true)
    private Money creditLimit = new Money(new BigDecimal("100"));;

    @DecimalMin(value = "0.1", inclusive = true)
    private BigDecimal interestRate=new BigDecimal("0.2");

    public CreditCard() {
    }

    public CreditCard(long id, Money balance, String primaryOwner, String secondaryOwner, Money penaltyFee, Money creditLimit, BigDecimal interestRate) {
        super(id, balance, primaryOwner, secondaryOwner, penaltyFee);

        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }


    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }




}
