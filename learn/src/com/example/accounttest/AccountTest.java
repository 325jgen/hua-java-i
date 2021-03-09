package com.example.accounttest;

import com.example.account.Account;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        // Init scanner
        Scanner input = new Scanner(System.in);

        // new account objects
        Account account1 = new Account(null);
        Account account2 = new Account(null);

        // Display initial value
        System.out.println("account1 init: " + account1.getName() + "\naccount2 init: " + account2.getName());

        // set new values
        System.out.println("Enter name for the first account:");
        account1.setName(input.nextLine());
        System.out.println("Enter name for the second account:");
        account2.setName(input.nextLine());

        System.out.println("Name of the first account: " + account1.getName() + "\nName of the second account " + account2.getName());
    }
}
