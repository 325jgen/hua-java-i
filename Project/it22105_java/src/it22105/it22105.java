package it22105;

import it22105.Articles.*;
import it22105.Users.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class it22105 {
    public static Scanner input = new Scanner(System.in);

    public static ArrayList<Article> articles = new ArrayList<>();
    public static ArrayList<Person> users = new ArrayList<>();




    public static void main(String[] args) {
        int choice;
        int searchID;
        menuPrintWelcome();


        defaultArticles();

        // DEBUG
//        for (int i = 0; i < 4; i++) {
//            Author[] SearchAuthors = articles.get(i).getAuthorsArray();
//            for (int j = 0; j < 2; j++) {
//                if (SearchAuthors[j] != null) {
//                    System.out.println(SearchAuthors[j].toString());
//                }
//            }
//        }

//        System.out.println("DEBUG\tPrinting out author of article one:\n");
//        System.out.println(Arrays.toString(articles.get(1).getAuthors()));

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
                        FullPaper ArticleFullPaper = new FullPaper();

                        // Printing out all characteristics of class
                        System.out.println(ArticleFullPaper.toString());

                        // Μετά την εισαγωγή των στοιχείων, αποθηκεύουμε το αντικείμενο στην λίστα
                        articles.add(ArticleFullPaper);
                    } else {
                        PaperInProgress ArticlePaperInProgress = new PaperInProgress();

                        // Printing out all characteristics of class
                        System.out.println(ArticlePaperInProgress.toString());

                        // Μετά την εισαγωγή των στοιχείων, αποθηκεύουμε το αντικείμενο στην λίστα
                        articles.add(ArticlePaperInProgress);
                    }


                    // After saving the new article, we save info regarding the authors
                    int iterations = articles.get(articles.size()-1).howManyAuthors();
                    for (int i = 0; i < iterations; i++) {
                        Article currentArticle = articles.get(articles.size()-1);
                        String email;
                        System.out.println("\nΠαρακαλώ πληκτρολογείστε το email σας:");
                        email = input.next();


                        // Ψάχνουμε σε όλα τα άρθα στο σύστημα αν υπάρχει το email που έδωσε ο χρήστης
                        for (Article searchArticle : articles) {
                            // Επανάληψη 2 φορών για να ελεγξεί αν υπάρχουν 2 συγγραφείς
                            for (int j = 0; j < 2; j++) {
                                if (searchArticle.getAuthors()[j] != null) {
                                    if (searchArticle.getAuthors()[j].getEmail().equals(email)) {
                                        System.out.println("Ο χρήστης με το email " + email + " υπάρχει ήδη στο σύστημα...");
                                        System.out.println("Το σύστημα θα συνδέσει το άρθρο που υποβάλλατε με τον ήδη υπάροχων συγγραφέα");
                                        connectAuthorToArticle(articles.get(articles.size()-1), searchArticle.getAuthors()[j]);
                                    }
                                }
                            }
                        }

                    }

                    break;
                case 2:
                    System.out.println("Εισάγετε τον κωδικό του άρθρου που ψάχνετε:");
                    searchID = input.nextInt();
                    if (!findArticle(searchID)) {
                        break;
                    }
                    // Saving the article the user searched for into foundArticle
                    Article foundArticle = articles.get(--searchID);

                    // Printing out Title, name and surname of authors
                    // also printing out type of article
                    System.out.println("Στο άρθρο με κωδικό " + searchID + " αντιστοιχούν οι εξής συγγραφείς:");
                    System.out.println(foundArticle.toString());
                    break;
                case 3:
                    System.out.println("Για να αξιολογήσετε το άρθρο που θέλετε παρακαλώ να εισάγετε τον κωδικό του άρθρου: ");
                    searchID = input.nextInt();
                    if (!findArticle(searchID)) {
                        break;
                    }

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

        // Creating two Fullpapers,      one Case Study and one Regular
        //      and two PaperInProgress, one Case Study and one Regular

        articles.add(new FullPaper(1,
                "Machine Monkey",
                new String[] {"IOT", "Machine Learning"},
                new Author[] {new Author("Benjamin",
                        "Peters",
                        "Mr.",
                        "bjpet2@gmail.com",
                        "Google"), null},
                new int[] {9, 5, 6, 3} ,
                12,
                "Case Study",
                null));
        articles.add(new PaperInProgress(2,
                "Morning Physics",
                new String[] {"Physics", "Lifestyle"},
                new Author[] {new Author("Jordan",
                        "Dernis",
                        "Dr.",
                        "jddr@yahoo.com",
                        "Yahoo"), null},
                new int[] {0, 0, 0, 0},
                "Case Study",
                null));

        articles.add(new FullPaper(3,
                "Vim and its decline",
                new String[] {"Text Editor", "Linux", "Terminal"},
                new Author[] {new Author("Alexander",
                        "Black",
                        "Mr.",
                        "alexbl@gmail.com",
                        "Facebook"), null},
                new int[] {6, 9, 10, 2},
                8,
                "Regular",
                null));
        articles.add(new PaperInProgress(4,
                "Modern Mice",
                new String[] {"Input", "Mice", "Modern"},
                new Author[] {new Author("Maria",
                        "Nernis",
                        "Prof.",
                        "marian92@prot.com",
                        "Proton"),
                              new Author("Stella",
                                      "Kern",
                                      "PhD candidate",
                                      "stellst@gmail.com",
                                      "HUA")},
                new int[] {0, 0, 0, 0},
                "Regular",
                null));

    }

    public static boolean findArticle(int searchID) {

        // Searching for article with the ID the user gave
        for (Article Search : articles) {
            System.out.println("Search ID in findArticle is " + Search.getID());
            if (Search.getID() == searchID) {
                return true;
            }
        }

        // The method will arrive here only if the ID was not found, no need to check
        System.out.println("Δεν βρέθηκε άρθρο με το ID που εισάγατε...");
        return false;
    }

    public static void connectAuthorToArticle(Article ArticleSearch, Author ConnectAuthor) {
        // If an author already exists in the first index of the array, connect author to the second one
        if (ArticleSearch.getAuthors(0) != null) {
            ArticleSearch.setAuthors(ConnectAuthor, 1);
        }
        ArticleSearch.setAuthors(ConnectAuthor, 0);
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
