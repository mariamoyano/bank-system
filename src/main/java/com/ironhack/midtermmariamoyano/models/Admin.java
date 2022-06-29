package com.ironhack.midtermmariamoyano.models;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User {

    private String name;

    public Admin() {
    }

    public Admin(String username, String password, String name) {
        super(username, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
