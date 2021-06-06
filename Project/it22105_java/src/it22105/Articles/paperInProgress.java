package it22105.Articles;

import it22105.Users.Author;
import it22105.Users.Reviewer;

public class PaperInProgress extends Article {
    private String property; // Regular or Case Study
    private String propertyOrg; // TODO Maybe I can change this with interfaces, will check

    public PaperInProgress(int ID, String title, String[] keywords, Author[] authors, Reviewer reviewer, int[] score, String property, String propertyOrg) {
        super(ID, title, keywords, authors, reviewer, score);
        this.property = property;
        this.propertyOrg = propertyOrg;
    }

    public PaperInProgress() {
        super();
        System.out.println("Δώσε 1 αν το άρθρο είναι κανονικό και 2 αν το άρθρο είναι μελέτη περίπτωσης (case study)");
        this.property = input.next();

        // Checking input
        while (!(property.equals("1")) && !(property.equals("2"))) {
            System.out.println("Δώσατε αριθμό διαφορετικό του 1 ή του 2\nΠαρακαλώ προσπαθήστε ξανά");
            this.property = input.next();
        }

        if (property.equals("2")) {
            this.property = "Case Study";
            System.out.println("Ποιό είναι το περιβάλλον της μελέτης στο οποίο βασίζεται το άρθρο;");
            this.propertyOrg = input.next();
        } else {
            this.property = "Regular";
        }
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getPropertyOrg() {
        return propertyOrg;
    }

    public void setPropertyOrg(String propertyOrg) {
        this.propertyOrg = propertyOrg;
    }

    @Override
    public String toString() {
        if (property.equals("Case Study")) {
            return super.toString() +
                    "\nΤύπος άρθρου: Paper-in-Progress, " + property +
                    "\nΠεριβάλλον μελέτης περίπτωσης: " + propertyOrg;
        }
        return super.toString() +
                "\nΤύπος άρθρου: Paper-In-Progress, " + property;
    }
}
