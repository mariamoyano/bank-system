package com.ironhack.midtermmariamoyano.models;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Admin extends User {



    public Admin() {
    }

    public Admin(String username, String password, String name) {
        super(username, password,name);

    }


}
