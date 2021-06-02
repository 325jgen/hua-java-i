package it22105;

import it22105.Articles.*;
import it22105.Users.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class it22105 {
    public static Scanner input = new Scanner(System.in);

    public static ArrayList<article> articles = new ArrayList<>();
    public static ArrayList<person> users = new ArrayList<>();


    public static void main(String[] args) {
        int choice;
        menuPrintWelcome();

        // Οι 2 λίστες που θα χρειαστούμε για να

        defaultArticles();

        while (true) {
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    // Εισάγει ο χρήστης τα στοιχεία για το άρθρο
                    System.out.println("Πες μου τι τύπου άρθρο θες να εισάγεις στο σύστημα");
                    System.out.println("Οι επιλογές είναι 1 για πλήρες άρθρο (Full Paper) και 2 για άρθρο σε-πρόοδο (paper-in-progress):");
                    int type = input.nextInt();
                    // Checking input
                    while (type != 1 && type != 2) {
                        System.out.println("Δώσατε αριθμό διαφορετικό του 1 ή 2\nΠαρακαλώ προσπαθήστε ξανά");
                        type = input.nextInt();
                    }

                    if (type == 1) {
                        fullPaper ArticleFullPaper = new fullPaper();
                        System.out.println(ArticleFullPaper.toString());
                        // Μετά την εισαγωγή των στοιχείων, αποθηκεύουμε το αντικείμενο στην λίστα
                        articles.add(ArticleFullPaper);
                    }
                    else {
                        paperInProgress ArticlePaperInProgress = new paperInProgress();
                        System.out.println(ArticlePaperInProgress.toString());
                        // Μετά την εισαγωγή των στοιχείων, αποθηκεύουμε το αντικείμενο στην λίστα
                        articles.add(ArticlePaperInProgress);
                    }

//                    for (int i = 0; i < articles.get(articles.size()-1).howManyAuthors(); i++) {
//                        System.out.println("");
//                        System.out.println("Κ./Κα. " + articles.get(articles.size()-1).getAuthors(i) + " είστε Οργανωτής, Συγγραφέας ή Αξιολογητής;");
//                        System.out.println("Οι επιλογές με την σειρά είναι 1, 2 και 3");
//                        type = input.nextInt();
//                        // Checking input
//                        while (type != 1 && type != 2 && type != 3) {
//                            System.out.println("Δώσατε αριθμό διαφορετικό του 1, 2 ή 3\nΠαρακαλώ προσπαθήστε ξανά");
//                            type = input.nextInt();
//                        }
//
//                        switch (type) {
//                            case 1:
//                                organiser userOrganiser = new organiser(articles.get(articles.size()-1).getAuthors(i));
//                                users.add(userOrganiser);
//                                break;
//                            case 2:
//                                author userAuthor = new author(articles.get(articles.size()-1).getAuthors(i));
//                                users.add(userAuthor);
//                                break;
//                            case 3:
//                                reviewer userReviewer = new reviewer(articles.get(articles.size()-1).getAuthors(i));
//                                users.add(userReviewer);
//                                break;
//                        }
//                    }
                    break;
                case 2:
                    System.out.println("Εισάγετε τον κωδικό του άρθρου που ψάχνετε:");
                    int searchID = input.nextInt();
                    boolean found = false;
                    article foundArticle = null;

                    // Searching for article with the ID the user gave
                    for (article Search : articles) {
                        if (Search.getID() == searchID) {
                            found = true;
                            foundArticle = Search;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Δεν βρέθηκε άρθρο με το ID που εισάγατε...");
                        break;
                    }

                    // Printing out article if found
                    System.out.println("Ο τίτλος του άρθρου με ID " + searchID + " είναι " + "'" + foundArticle.getTitle() + "'" + " και οι συγγραφείς είναι " + Arrays.toString(foundArticle.getAuthorsArray()));


                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Ευχαριστούμε που μας προτίμησες! Καλή συνέχεια!");
                    return;
            }
            menuPrint();
        }

    }

    public static void menuPrintWelcome() {
        System.out.println("Καλοσήρθες στο σύστημα Conference@Academia!");
        System.out.println("Μπορείς να επιλέξεις μια από τις 5 λειτουργίες");
        menuPrint();
    }

    public static void menuPrint() {
        System.out.println();
        System.out.println("1. Εισαγωγή νέου άρθρου");
        System.out.println("2. Αναζήτηση άρθρου και Εισαγωγή αξιολογητή");
        System.out.println("3. Εισαγωγή αξιολόγησης άρθρου");
        System.out.println("4. Εμφάνιση αξιολόγησης άρθρου");
        System.out.println("5. Εμφάνιση αναφορών");
        System.out.println("");
        System.out.println("Για να βγείς από το σύστημα, βάλε οποιονδήποτε αριθμό εκτός του 1-5");
    }

    public static void defaultArticles() {
        // fullPaper(int ID, String title, String[] keywords, String[] authors, int[] score, int size, String property, String propertyOrg
        // paperInProgress(int ID, String title, String[] keywords, String[] authors, int[] score, String property, String propertyOrg)

        // Creating two fullpapers,      one Case Study and one Regular
        //      and two paperInProgress, one Case Study and one Regular

        articles.add(new fullPaper(1, "Machine Monkey", new String[] {"IOT", "Machine Learning"}, new String[] {"Benjamin", "Joseph"}, new int[] {9, 5, 6, 3} ,12, "Case Study", null));
        articles.add(new paperInProgress(2, "Morning Physics", new String[] {"Physics", "Lifestyle"}, new String[] {"Jordan", null}, new int[] {0, 0, 0, 0}, "Case Study", null));

        articles.add(new fullPaper(3, "Vim and its decline", new String[] {"Text Editor", "Linux", "Terminal"}, new String[] {"Alexander", null}, new int[] {6, 9, 10, 2}, 8, "Regular", null));
        articles.add(new paperInProgress(4, "Modern Mice", new String[] {"Input", "Mice", "Modern"}, new String[] {"Maria", "Stella"}, new int[] {0, 0, 0, 0}, "Regular", null));
    }

//    public static void newUser(int numOfAuthors) {
//        if (numOfAuthors == 1) {
//            String email = input.next();
//            if (checkEmail(email) == 1) {
//
//            }
//            else {
//
//            }
//        }
//        else {
//
//        }
//    }

//    public static int checkEmail(String email) {
//        // Θα προσπαθήσω να τρέξω όλο τον πίνακα για να
//    }
}
