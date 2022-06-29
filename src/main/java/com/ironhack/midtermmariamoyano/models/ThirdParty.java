package com.ironhack.midtermmariamoyano.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class ThirdParty extends User {


    private String hashedKey;
    private String name;
    public ThirdParty() {
    }

    public ThirdParty(String username, String password, String hashedKey, String name) {
        super(username, password);
        this.hashedKey = hashedKey;
        this.name = name;
    }

    public String getHashedKey() {
        return hashedKey;
    }

    public void setHashedKey(String hashedKey) {
        this.hashedKey = hashedKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
