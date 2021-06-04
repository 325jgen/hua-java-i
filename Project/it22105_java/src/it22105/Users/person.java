package it22105.Users;

import java.util.Scanner;

public abstract class Person {
    private String name;
    private String surname;
    private String title; // Not necessary
    private String email;
    private String institution; // Not necessary

    Scanner input = new Scanner(System.in);

    public Person(String name) {
        this.name = name;

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

    public Person(String name, String surname, String title, String email, String institution) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.email = email;
        this.institution = institution;
    }

    @Override
    public String toString() {
        return "\nΤίτλος: " + title +
                "\nΌνομα: " + name +
                "\nΕπίθετο: " + surname +
                "\nEmail: " + email +
                "\nΟργανισμός: " + institution;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
