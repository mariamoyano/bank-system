package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.classes.Money;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency"))
    })
    private Money balance;
    @NotNull
    private String secretKey;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "primary_owner_id")
    private AccountHolder primaryOwner;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "secondary_owner_id")
    private AccountHolder secondaryOwner;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "penalty_fee_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "penalty_fee_currency"))
    })
    private final Money penaltyFee = new Money(new BigDecimal("40"));

    public Accounts() {
    }

    public Accounts(Money balance, String secretKey, AccountHolder primaryOwner, AccountHolder secondaryOwner, Money penaltyFee) {

        this.balance = balance;
        this.secretKey =secretKey;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;

    }
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

    public Money getPenaltyFee() {
        return penaltyFee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", balance=" + balance +
                ", primaryOwner=" + primaryOwner +
                ", secondaryOwner=" + secondaryOwner +
                ", penaltyFee=" + penaltyFee +
                '}';
    }
}
