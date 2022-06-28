package com.ironhack.midtermmariamoyano.models;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class CreditCard extends Account{

    private BigDecimal penaltyFee;

    private BigDecimal creditLimit;
    private BigDecimal interestRate;

    public CreditCard() {
    }

    public CreditCard(long id, BigDecimal balance, String primaryOwner, String secondaryOwner, BigDecimal penaltyFee, BigDecimal creditLimit, BigDecimal interestRate) {
        super(id, balance, primaryOwner, secondaryOwner, penaltyFee);

        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
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
