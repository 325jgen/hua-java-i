package com.example.keyboard;
import java.util.Scanner;

// Scanner gives me the ability to use the keyboard and save values to variables in the Java Class. To actually obtain the input, we need to use "System.in".
//

public class Keyboard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // This creates a Scanner with the "input" name to use later on. We create an object to open a daemon to enable communication between the Java class and the keyboard input.
        int x;
        x = input.nextInt(); // The nextInt method reads the first number the user inputs
        System.out.println("num x is " + x);

    }
}
