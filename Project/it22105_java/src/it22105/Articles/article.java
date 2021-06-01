package it22105.Articles;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class article {
    Scanner input = new Scanner(System.in);
    Random rnd = new Random();
    private int ID;
    private String title;
    private String[] keywords = new String[3]; // Up to 3 keywords per article
    private String[] authors = new String[2]; // Up to 2 authors
    private int[] score = new int[4]; // Ερευνητική συνεισφορά, ερευνητικά αποτελέσματα, ερευνητική μεθοδολογία, καινοτομία

    public static int IDCounter = 0;

    public article() {
        System.out.println("Γράψε τον τίτλο του άρθρου:");
        this.title = input.next();

        this.ID = ++IDCounter;
        System.out.println("Ο κωδικός του άρθρου είναι " + ID);

        System.out.println("Δώσε μέχρι 3 keywords");
        System.out.println("Για να σταματήσεις να γράφεις keywords, γράψε exit");
        for (int i = 0; i < 3; i++) {
            this.keywords[i] = input.next();

            if (keywords[i].equals("exit")) {
                this.keywords[i] = null;
                break;
            }
        }

        System.out.println("Δώσε τους συγγραφείς του άρθρου (μέχρι 2)");
        System.out.println("Αν δεν υπάρχει δεύτερος συγγραφέας, γράψε exit");
        this.authors[0] = input.next();
        this.authors[1] = input.next();
        if (authors[1].equals("exit")) {
            this.authors[1] = null;
        }

        System.out.println("Δώσε βαθμό με την σειρά για Ερευνητική συνεισφορά, ερευνητικά αποτελέσματα, ερευνητική μεθοδολογία και καινοτομία:");
        for (int i = 0; i < 4; i++) {
            this.score[i] = input.nextInt();
        }
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
        return authors.length;
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

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }
}
