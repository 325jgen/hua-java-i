package com.example.accounttest;

import com.example.account.Account;
import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        // Init scanner
        Scanner input = new Scanner(System.in);

        // New account objects
        Account account1 = new Account(null);
        Account account2 = new Account(null);

        // Display initial value of names
        System.out.println("account1 init: " + account1.getName() + "\naccount2 init: " + account2.getName());

        // Set new values of names
        System.out.println("Enter name for the first account:");
        account1.setName(input.nextLine());
//        System.out.println("Enter name for the second account:");
//        account2.setName(input.nextLine());

        // Display new values of names
        System.out.println("Name of the first account: " + account1.getName() + "\nName of the second account " + account2.getName());

        // Display initial value of total
        System.out.println("The total of the first account is: " + account1.getTotal());

        //Set new value of total
        int ans;
        System.out.println("Do you want to deposit/withdraw from your account or exit the ATM? (1/2/3)\n (1 is for depositing, 2 is for withdrawing and 3 is for exiting)");
        ans = input.nextInt();
        while (ans != 3) {
            if (ans == 1) {
                System.out.println("Enter the value of money you want to deposit into your account: ");
                account1.incTotal(input.nextInt());
            } else if (ans == 2) {
                System.out.println("Enter the value of money you want to withdraw from your account: ");
                account1.decTotal(input.nextInt());
            } else {
                System.out.println("Total of " + account1.getName() + "'s account is " + account1.getTotal() + "\n");
                System.out.println("Goodbye " + account1.getName());
            }
            System.out.println("Total of " + account1.getName() + "'s account is " + account1.getTotal() + "\n");
            System.out.println("Do you want to deposit/withdraw from your account or exit the ATM? (1/2/3)\n (1 is for depositing, 2 is for withdrawing and 3 is for exiting)");
            ans = input.nextInt();
        }



    }
}
