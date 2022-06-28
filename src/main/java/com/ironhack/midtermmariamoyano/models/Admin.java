package com.ironhack.midtermmariamoyano.models;

import javax.persistence.Entity;

@Entity
public class Admin {

    private String name;

    public Admin() {
    }

    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
