package it22105;

import java.util.Scanner;

public abstract class Person {
    private String name;
    private String surname;
    private String title; // Not necessary
    private String email;
    private String institution; // Not necessary

    Scanner input = new Scanner(System.in);

    public Person(String email) {
        System.out.println("Γράψτε το όνομα σας:");
        this.name = input.next();

        System.out.println("Γράψτε το επίθετο σας:");
        this.surname = input.next();
        // Ίδια λογική με το newline όπως και στον constructor της Article()
        // Αν και αφού ειναι σε while, θα λειτουργήσει κανονικά, απλά είναι
        // απλά ελάχιστα αντιαισθητικό να βλέπει ο χρήστης το 
        // error message
        input.nextLine();

        this.email = email;

        System.out.println("Γράψε τον τίτλο σας (γράψτε exit αν δεν έχετε τίτλο):");
        System.out.println("Οι επιλογές σας είναι: Prof., Dr., Mr., Mrs., PhD Candidate, ");
        this.title = input.nextLine();
        while (!(title.equals("Prof.") ||
                title.equals("Dr.") ||
                title.equals("Mr.") ||
                title.equals("Mrs.") ||
                title.equals("PhD Candidate") ||
                title.equals("exit"))) {
            System.out.println("Δεν γράψατε κανένα από τους επιτρεπόμενους τίτλους, παρακαλώ προσπαθήστε ξανά");
            this.title = input.nextLine();
        }
        
        if (title.equals("exit")) {
            this.title = null;
        }

        System.out.println("Σε ποιον οργανισμό ανήκετε; (γράψτε exit αν δεν εργάζεστε με κάποιον οργανισμό):");
        this.institution = input.next();
        if (institution.equals("exit")) {
            this.institution = null;
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
        // Αν το άτομο έχει τίτλο και ανοίκει σε οργανισμό
        if (title != null && institution != null) {
            return "\nΤίτλος: " + title +
                "\nΌνομα: " + name +
                "\nΕπίθετο: " + surname +
                "\nEmail: " + email +
                "\nΟργανισμός: " + institution + "\n";
        }
        // Αν το άτομο έχει τίτλο αλλα δεν ανοίκει σε οργανισμό
        else if (title != null && institution == null) {
            return "\nΤίτλος: " + title +
                "\nΌνομα: " + name +
                "\nΕπίθετο: " + surname +
                "\nEmail: " + email + "\n";
        }
        // Αν το άτομο δεν έχει τίτλο αλλά ανοίκει σε οργανισμό
        else if (title == null && institution != null) {
            return "\nΌνομα: " + name +
                "\nΕπίθετο: " + surname +
                "\nEmail: " + email +
                "\nΟργανισμός: " + institution + "\n";
        }
        // Αν το άτομο δεν έχει τίτλο και δεν ανοίκει σε οργανισμό
        else {
            return "\nΌνομα: " + name +
                "\nΕπίθετο: " + surname +
                "\nEmail: " + email + "\n";
        }
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
    
    public String getTitleNameSurname() {
        if (title == null) {
            return name + " " + surname;
        }
        else {
            return title + " " + name + " " + surname;
        }
    }
}
