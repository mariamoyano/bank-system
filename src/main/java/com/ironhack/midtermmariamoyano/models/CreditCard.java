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

    private Money creditLimit = new Money(new BigDecimal("100"));

    @DecimalMin(value = "0.1", inclusive = true)
    private BigDecimal interestRate=new BigDecimal("0.2");

    public CreditCard() {
    }

    public CreditCard(long id, Money balance, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee, Money creditLimit, BigDecimal interestRate) {
        super(id, balance, primaryOwner, secondaryOwner, penaltyFee);

        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }


    public Money getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Money creditLimit) {

        BigDecimal minCreditLimit = new BigDecimal(100);
        BigDecimal maxCreditLimit = new BigDecimal(100000);
//        if(creditLimit.getAmount().compareTo(minCreditLimit) == -1){
//            BigDecimal newBalance = getBalance().decreaseAmount(new BigDecimal(40));
//            setBalance(new Money(newBalance));

        if ((creditLimit.getAmount().compareTo(minCreditLimit) == 1 && creditLimit.getAmount().compareTo(maxCreditLimit) == -1)
                || creditLimit.getAmount().compareTo(minCreditLimit) == 0 || creditLimit.getAmount().compareTo(maxCreditLimit) == -1) {
            this.creditLimit = creditLimit;
        } else {
            this.creditLimit = new Money(new BigDecimal("100"));
        }
    }


    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }




}
