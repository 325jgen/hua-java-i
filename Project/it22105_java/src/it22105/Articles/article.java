package it22105.Articles;

import it22105.Users.Author;
import it22105.Users.Reviewer;

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

    public static int IDCounter = 4;

    public Article(int ID, String title, String[] keywords, Author[] authors, int[] score) {
        this.ID = ID;
        this.title = title;
        this.keywords = keywords;
        this.authors = authors;
        this.score = score;
    }

    public Article() {
        this.ID = ++IDCounter;

        System.out.println("Γράψε τον τίτλο του άρθρου:");
        this.title = input.next();

        System.out.println("Δώσε μέχρι 3 keywords");
        System.out.println("Για να σταματήσεις να γράφεις keywords, γράψε exit");
        for (int i = 0; i < 3; i++) {
            this.keywords[i] = input.next();
            if (keywords[i].equals("exit")) {
                this.keywords[i] = null;
                break;
            }
        }

        // TODO fix author input
    }

    @Override
    public String toString() {
        return  "\nΚωδικός: " + ID +
                "\nΤίτλος: " + title +
                "\nKeywords: " + Arrays.toString(keywords) +
                "\nΣυγγραφείς: " + Arrays.toString(authors) +
                "\nΒαθμολογίες: " + Arrays.toString(score);
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

    public void setScore(int[] score) {
        this.score = score;
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
}
