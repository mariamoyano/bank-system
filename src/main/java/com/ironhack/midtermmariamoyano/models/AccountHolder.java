package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.classes.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class AccountHolder extends User{


    @Column(name="date_of_birth")
    private Date date;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "primary_city")),
            @AttributeOverride(name = "street", column = @Column(name = "primary_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "primary_postal_code"))

    })
    @NotNull
    private Address address;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "city", column = @Column(name = "mailing_city")),
            @AttributeOverride(name = "street", column = @Column(name = "mailing_street")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "mailing_postal_code"))
    })
    private Address mailingAddress; //Optional
    public AccountHolder() {
    }

    public AccountHolder(String username, String password, String name, Date date, Address address) {
        super(username, password, name);
        this.date = date;
        this.address = address;

    }

    public AccountHolder(String username, String password, String name, Date date, Address address, Address mailingAddress) {
        super(username, password, name);
        this.date = date;
        this.address = address;
        this.mailingAddress = mailingAddress;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(Address mailingAddress) {
        this.mailingAddress = mailingAddress;
    }
}
