package it22105;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public abstract class Article {
    Scanner input = new Scanner(System.in);
    Random rnd = new Random();
    private int ID;
    private String title;
    private String[] keywords = new String[3]; // Up to 3 keywords per article
    private Author[] authors = new Author[2]; // Up to 2 authors
    private Reviewer reviewer;
    private int[] score = new int[4]; // Ερευνητική συνεισφορά, ερευνητικά αποτελέσματα, ερευνητική μεθοδολογία, καινοτομία
    private String property;
    private String propertyOrg;


    public static int IDCounter = 4;

    public Article(int ID, String title, String[] keywords, Author[] authors, Reviewer reviewer, int[] score, String property, String propertyOrg) {
        this.ID = ID;
        this.title = title;
        this.keywords = keywords;
        this.authors = authors;
        this.reviewer = reviewer;
        this.score = score;
        this.property = property;
        this.propertyOrg = propertyOrg;
    }

    public Article() {
        this.ID = ++IDCounter;

        System.out.println("Γράψε τον τίτλο του άρθρου:");
        this.title = input.nextLine();

        System.out.println("Δώσε μέχρι 3 keywords");
        System.out.println("Για να σταματήσεις να γράφεις keywords, γράψε exit");
        for (int i = 0; i < 3; i++) {
            this.keywords[i] = input.next();
            if (keywords[i].equals("exit")) {
                this.keywords[i] = null;
                break;
            }
        }


        // Τύπος άρθρου
        System.out.println("Δώσε 1 αν το άρθρο είναι κανονικό και 2 αν το άρθρο είναι μελέτη περίπτωσης (case study)");
        this.property = input.next();
        
        // Αυτό το nextLine το βάζω εδώ γιατι η χρήση του inout.next() αφήνει τον χαρακατήρα newline στο input
        // και το επόμενο input.nextLine() στο `if (property.equals("2"))` το διαβάζει και τερματίζει την εκτέλεση χωρίς να 
        // πάρει όντως το input του χρήστη
        // Το workaround αυτό το βρήκα σε αυτή την σελίδα https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo
        input.nextLine();

        // Checking input
        while (!property.equals("1") && !property.equals("2")) {
            System.out.println("Δώσατε αριθμό διαφορετικό του 1 ή του 2\nΠαρακαλώ προσπαθήστε ξανά");
            this.property = input.next();
        }

        if (property.equals("2")) {
            this.property = "Case Study";
            System.out.println("Ποιό είναι το περιβάλλον της μελέτης στο οποίο βασίζεται το άρθρο;");
            this.propertyOrg = input.nextLine();
        } else {
            this.property = "Regular";
        }

        // TODO fix author input
    }

    @Override
    public String toString() {
        if (reviewer == null) {
            return "\nΚωδικός άρθρου: " + ID +
                    "\nΤίτλος άρθρου: " + title +
                    "\nKeywords: " + Arrays.toString(keywords) +
                    "\nΣυγγραφείς: " + Arrays.toString(authors);
        }
        else {
            return "\nΚωδικός άρθρου: " + ID +
                    "\nΤίτλος άρθρου: " + title +
                    "\nKeywords: " + Arrays.toString(keywords) +
                    "\nΣυγγραφείς: " + Arrays.toString(authors) +
                    "\nΑξιολογητής: " + reviewer.toString() +
                    "\nΒαθμολογία: " + Arrays.toString(score);
        }
    }

    public int howManyAuthors() {
        System.out.println("\nΠόσοι συγγραφείς δούλεψαν σε για αυτό το άρθρο; (μέχρι 2)");
        int numOfAuthors = input.nextInt();
        while (numOfAuthors < 1 || numOfAuthors > 2) {
            System.out.println("Οι πιθανοί συγγραφείς που μπορεί το σύστημα να αποθηκεύσει είναι από 1 μέχρι 2");
            System.out.println("Παρακαλώ προσπαθήστε ξανά");
            numOfAuthors = input.nextInt();
        }
        return numOfAuthors;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore() {
        for (int i = 0; i < 4; i++) {
            this.score[i] = input.nextInt();
        }
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public Author getAuthors(int index) {
        return authors[index];
    }

    public void setAuthors(Author author, int index) {
        this.authors[index] = author;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    public Reviewer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Reviewer reviewer) {
        this.reviewer = reviewer;
    }

    public void setScore(int[] score) {
        this.score = score;
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
}