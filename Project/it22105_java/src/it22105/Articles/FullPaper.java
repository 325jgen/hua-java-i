package it22105.Articles;

import it22105.Users.Author;
import it22105.Users.Reviewer;


public class FullPaper extends Article {
    private int size; // Full paper is also characterized by its size (8 or 12 pages)
    // TODO Maybe I can change this with interfaces, will check. Not only that, but the constructors and the toString method of both fullPaper and the paperInProgress classes are literally the same, but I don't think they should be in the article super class. Will see, probably will implement it to the superclass though, fullpaper and paperInProgress classes are pretty much useless right now...

    public FullPaper(int ID, String title, String[] keywords, Author[] authors, Reviewer reviewer, int[] score, int size, String property, String propertyOrg) {
        super (ID, title, keywords, authors, reviewer, score, property, propertyOrg);
        this.size = size;
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
    }

    public FullPaper(int id, String machine_monkey, String[] keywords, Author[] authors, int[] score, int size, String case_study, Object propertyOrg) {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        if (getProperty().equals("Case Study")) {
            return super.toString() +
                    "\nΤύπος άρθρου: Full Paper, " + getProperty() +
                    "\nΠεριβάλλον μελέτης περίπτωσης: " + getPropertyOrg();
        }
        return super.toString() +
                "\nΤύπος άρθρου: Full Paper, " + getProperty();
    }
}
