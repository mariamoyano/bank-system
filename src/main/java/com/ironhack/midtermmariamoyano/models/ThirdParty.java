package com.ironhack.midtermmariamoyano.models;

public class ThirdParty extends Admin {

    private String hashedKey;

    public ThirdParty() {
    }

    public ThirdParty(String name, String hashedKey) {
        super(name);

        this.hashedKey = hashedKey;
    }
}
