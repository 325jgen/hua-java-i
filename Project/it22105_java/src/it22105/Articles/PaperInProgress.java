package it22105.Articles;

import it22105.Users.Author;
import it22105.Users.Reviewer;


public class PaperInProgress extends Article {
    // TODO: MAYBE TRANSFER THE PROPERTY/PROPERTYORG TO ARTICLE, SINCE IT'S IDENTICAL WITH BOTH FULLPAPER AND PAPERINPROGRESS
    // TODO Maybe I can change this with interfaces, will check

    public PaperInProgress(int ID, String title, String[] keywords, Author[] authors, Reviewer reviewer, int[] score, String property, String propertyOrg) {
        super(ID, title, keywords, authors, reviewer, score, property, propertyOrg);
    }

    public PaperInProgress() {
        super();
    }

    @Override
    public String toString() {
        if (getProperty().equals("Case Study")) {
            return super.toString() +
                    "\nΤύπος άρθρου: Paper-in-Progress, " + getProperty() +
                    "\nΠεριβάλλον μελέτης περίπτωσης: " + getPropertyOrg();
        }
        return super.toString() +
                "\nΤύπος άρθρου: Paper-In-Progress, " + getProperty();
    }
}
