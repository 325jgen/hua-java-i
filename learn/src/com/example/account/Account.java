package com.example.account;


public class Account {
    private String name;

    // constructor init
    public Account(String name) {
        this.name = name;
    }

    // method to set name
    public void setName(String name) {
        this.name = name;
    }

    // method to retrieve name
    public String getName() {
        return name;
    }
}
