package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.classes.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class AccountHolders extends User{
    private String name;
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
    public AccountHolders() {
    }

    public AccountHolders(String username, String password, String name, Date date, Address address, Address mailingAddress) {
        super(username, password);
        this.name = name;
        this.date = date;
        this.address = address;
        this.mailingAddress = mailingAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
