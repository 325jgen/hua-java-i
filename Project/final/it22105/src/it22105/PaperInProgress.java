package it22105;

public class PaperInProgress extends Article {

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
