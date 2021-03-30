package com.example.account;


public class Account {
    private String name;
    private int total;

    // constructor init
    public Account(String name) {
        this.name = name;
        this.total = 0;
    }

    // method to set name
    public void setName(String name) {
        this.name = name;
    }

    // method to retrieve name
    public String getName() {
        return name;
    }

    // method to increase total
    public void incTotal(int x) {
        total += x;
    }

    // method to decrease total
    public void decTotal(int x) {
        total -= x;
    }

    // method to retrieve total
    public int getTotal() {
        return total;
    }


}
