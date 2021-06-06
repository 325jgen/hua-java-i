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


        defaultValues();

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
                    }
                    else {
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
                        boolean emailExists;
                        String searchEmail;
                        System.out.println("\nΠαρακαλώ o " + (i+1) + "ος συγγραφέας να πληκτρολογήσει το email του:");
                        searchEmail = input.next();

                        emailExists = findAuthor(searchEmail);
//                        // Ψάχνουμε σε όλα τα άρθα στο σύστημα αν υπάρχει το email που έδωσε ο χρήστης
//                        int j;
//                        for (Article searchArticle : articles) {
//                            // Επανάληψη 2 φορές για να ελεγξούμε αν υπάρχουν 2 συγγραφείς
//                            j = 0;
//                            while (j < 2) {
//                                if (searchArticle.getAuthors()[j] != null) {
//                                    if (searchArticle.getAuthors()[j].getEmail().equals(searchEmail)) {
//                                        emailExists = true;
//                                        System.out.println("Ο χρήστης με το email " + searchEmail + " υπάρχει ήδη στο σύστημα...");
//                                        System.out.println("Το σύστημα θα συνδέσει το άρθρο που υποβάλλατε με τον ήδη υπάροχων συγγραφέα");
//                                        connectAuthorToArticle(articles.get(articles.size()-1), searchArticle.getAuthors()[j]);
//                                    }
//                                }
//                                j++;
//                            }
//                            // Αν σηκωθεί το flag του email exists, σπαει το for loop
//                            if (emailExists) {
//                                break;
//                            }
//                        }

                        // Εάν στις επαναλήψεις πάνω δεν βρέθηκε παρόμοιο email, τότε ο χρήστης θα εισάγει τα στοιχεία του
                        if (!emailExists) {
                            System.out.println("Ο " + (i+1) + "ος συγγραφέας να εισάγει τα στοιχεία του:");
                            articles.get(articles.size()-1).setAuthors(new Author(searchEmail), i);
                        }

                    }

                    // TODO: Implement a method which will check if an article with the same title and same authors exists
                    // Pretty much needs to cross check title with all the articles + check emails (an author's email is
                    // the first information the program checks the arraylist to see if it already exists)
                    // checkDuplicateArticle();

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


                    System.out.println("Για την εισαγωγή αξιολογητή στο σύστημα παρακαλώ να γράψετε το email σας:");
                    String searchEmail = input.next();



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

    public static void defaultValues() {
        // fullPaper(int ID, String title, String[] keywords, String[] authors, int[] score, int size, String property, String propertyOrg
        // paperInProgress(int ID, String title, String[] keywords, String[] authors, int[] score, String property, String propertyOrg)

        // Creating two Fullpapers,      one Case Study and one Regular
        //      and two PaperInProgress, one Case Study and one Regular
        // Also creating two default reviewers

        users.add(new Reviewer("Joshua", "Black", "Mr.", "joblk22@gmail.com", "Uni"));

        users.add(new Reviewer("Maria", "Newport", "Mrs.", "marnewp@gmail.com", "Uni"));


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
        else {
            ArticleSearch.setAuthors(ConnectAuthor, 0);
        }
    }

    public static boolean findAuthor(String searchEmail) {
        int j;
        for (Article searchArticle : articles) {
            // Επανάληψη 2 φορές για να ελεγξούμε αν υπάρχουν 2 συγγραφείς
            j = 0;
            while (j < 2) {
                if (searchArticle.getAuthors()[j] != null) {
                    if (searchArticle.getAuthors()[j].getEmail().equals(searchEmail)) {
                        System.out.println("Ο χρήστης με το email " + searchEmail + " υπάρχει ήδη στο σύστημα...");
                        System.out.println("Το σύστημα θα συνδέσει το άρθρο που υποβάλλατε με τον ήδη υπάρχων συγγραφέα");

                        // articles.get(articles.size()-1) μας δινει το τελευταιο αρθρο στο ArrayList
                        connectAuthorToArticle(articles.get(articles.size()-1), searchArticle.getAuthors()[j]);
                        return false;
                    }
                }
                j++;
            }
        }
        // Αν δεν μπει στην εσωτερική if, τοτε γυρνάει true
        return true;
    }

    public static boolean findReviewer(String searchEmail) {
        int j;
        for (Person searchReviewer : users) {
            // Επανάληψη 2 φορές για να ελεγξούμε αν υπάρχουν 2 συγγραφείς
            j = 0;
            while (j < 2) {
                if (searchReviewer != null) {
                    if (searchReviewer.getEmail().equals(searchEmail)) {
                        System.out.println("Ο αξιολογητής με το email " + searchEmail + " υπάρχει ήδη στο σύστημα...");
                        System.out.println("Το σύστημα θα συνδέσει το άρθρο που υποβάλλατε με τον ήδη υπάρχων αξιολογητή");

                        // articles.get(articles.size()-1) μας δινει το τελευταιο αρθρο στο ArrayList
                        // TODO: connect reviewer with article
                        return false;
                    }
                }
                j++;
            }
        }
        // Αν δεν μπει στην εσωτερική if, τοτε γυρνάει true
        return true;
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
