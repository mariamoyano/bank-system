package com.ironhack.midtermmariamoyano.models;

import com.ironhack.midtermmariamoyano.classes.Address;

import java.sql.Date;

public class AccountHolders extends Admin{


    private Date date;
    private Address address;
    private Address mailingAddress; //Optional

    public AccountHolders() {
    }

    public AccountHolders(String name, Date date, Address address, Address mailingAddress) {
        super(name);
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
