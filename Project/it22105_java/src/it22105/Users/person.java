package it22105.Users;

import it22105.it22105;

import java.util.Scanner;

public class person {
    private String name;
    private String surname;
    private String title; // Not necessary
    private String email;
    private String institution; // Not necessary

    Scanner input = new Scanner(System.in);

    public person() {
        System.out.println("Γράψτε το όνομα σας:");
        this.name = input.next();

        System.out.println("Γράψτε το επίθετο σας:");
        this.surname = input.next();

        // TODO: Make sure the email the user inputs is correct
        System.out.println("Γράψτε το email σας:");
        this.email = input.next();

        System.out.println("Γράψε τον τίτλο σας (γράψτε exit αν δεν έχετε τίτλο):");
        this.title = input.next();
        if (title.equals("exit")) {
            this.title = null;
        }

        System.out.println("Σε ποιον οργανισμό ανήκετε; (γράψτε exit αν δεν εργάζεστε με κάποιον οργανισμό):");
        this.title = input.next();
        if (title.equals("exit")) {
            this.title = null;
        }
    }
}
