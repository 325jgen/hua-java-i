package it22105.Articles;

import it22105.Users.Author;

public class FullPaper extends Article {
    private int size; // Full paper is also characterized by its size (8 or 12 pages)
    private String property; // Regular or Case Study
    private String propertyOrg; // TODO Maybe I can change this with interfaces, will check. Not only that, but the constructors and the toString method of both fullPaper and the paperInProgress classes are literally the same, but I don't think they should be in the article super class. Will see, probably will implement it to the superclass though, fullpaper and paperInProgress classes are pretty much useless right now...

    public FullPaper(int ID, String title, String[] keywords, Author[] authors, int[] score, int size, String property, String propertyOrg) {
        super (ID, title, keywords, authors, score);
        this.size = size;
        this.property = property;
        this.propertyOrg = propertyOrg;
    }

    public FullPaper() {
        super();
        System.out.println("Πόσες είναι οι σελίδες του άρθρου; (8-12)");
        this.size = input.nextInt();
        // Checking if input is between 8 and 12
        while (size < 8 || size > 12) {
            System.out.println("Οι σελίδες του άρθρου είναι από 8 εώς και 12, παρακαλώ προσπαθήστε ξανά");
            this.size = input.nextInt();
        }

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

    public FullPaper(int id, String machine_monkey, String[] keywords, Author[] authors, int[] score, int size, String case_study, Object propertyOrg) {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
                    "\nΤύπος άρθρου: Full Paper, " + property +
                    "\nΠεριβάλλον μελέτης περίπτωσης: " + propertyOrg;
        }
        return super.toString() +
                "\nΤύπος άρθρου: Full Paper, " + property;
    }
}
