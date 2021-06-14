package it22105;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class it22105 {
    public static Scanner input = new Scanner(System.in);

    // ArrayList που θα χρειαστούμε στο πρόγραμμα
    public static ArrayList<Article> articles = new ArrayList<>();
    public static ArrayList<Person> reviewers = new ArrayList<>();

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
        System.out.println("5. Εμφάνιση αναφορών\n");
        System.out.println("Για να βγείς από το σύστημα, βάλε οποιονδήποτε αριθμό εκτός του 1-5");
    }

    public static void defaultValues() {
        // fullPaper(int ID, String title, String[] keywords, String[] authors, int[] score, int size, String property, String propertyOrg
        // paperInProgress(int ID, String title, String[] keywords, String[] authors, int[] score, String property, String propertyOrg)

        // Creating two Fullpapers,      one Case Study and one Regular
        //      and two PaperInProgress, one Case Study and one Regular
        // Also creating two default reviewers

        // reviewer.get(0)
        reviewers.add(new Reviewer("Joshua", "Black", "Mr.", "joblk22@gmail.com", "Uni"));

        // reviewer.get(1)
        reviewers.add(new Reviewer("Maria", "Newport", "Mrs.", "marnewp@gmail.com", "Uni"));


        articles.add(new FullPaper(1,
                "Machine Monkey",
                new String[]{"IOT", "Machine Learning"},
                new Author[]{new Author("Benjamin",
                        "Peters",
                        "Mr.",
                        "bjpet2@gmail.com",
                        "Google"), null},
                (Reviewer) (reviewers.get(0)),
                new int[]{9, 5, 6, 3},
                12,
                "Case Study",
                null));
        articles.add(new PaperInProgress(2,
                "Morning Physics",
                new String[]{"Physics", "Lifestyle"},
                new Author[]{new Author("Jordan",
                        "Dernis",
                        "Dr.",
                        "jddr@yahoo.com",
                        "Yahoo"), null},
                null,
                new int[]{0, 0, 0, 0},
                "Case Study",
                null));

        articles.add(new FullPaper(3,
                "Vim and its decline",
                new String[]{"Text Editor", "Linux", "Terminal"},
                new Author[]{new Author("Alexander",
                        "Black",
                        "Mr.",
                        "alexbl@gmail.com",
                        "Facebook"), null},
                (Reviewer) (reviewers.get(1)),
                new int[]{6, 9, 10, 2},
                8,
                "Regular",
                null));
        articles.add(new PaperInProgress(4,
                "Modern Mice",
                new String[]{"Input", "Mice", "Modern"},
                new Author[]{new Author("Maria",
                        "Nernis",
                        "Prof.",
                        "marian92@prot.com",
                        "Proton"),
                        new Author("Stella",
                                "Kern",
                                "PhD candidate",
                                "stellst@gmail.com",
                                "HUA")},
                null,
                new int[]{0, 0, 0, 0},
                "Regular",
                null));


    }

    public static boolean findArticle(int searchID) {
        // Ψάχνοντας σε όλα τα άρθρα για το άρθρο με τον συγκεκριμένο κωδικό searchID
        // Αν βρεθεί θα επιστρέψει true, αλλιώς θα επιστρέψει false
        for (Article Search : articles) {
            if (Search.getID() == searchID) {
                return true;
            }
        }

        // Η μέθοδος θα φτάσει εδώ μόνο εάν δεν βρεθεί το άρθρο
        System.out.println("Δεν βρέθηκε άρθρο με το ID που εισάγατε...");
        return false;
    }
    
    public static boolean checkDuplicateArticle(Article checkArticle) {
        Article iterationArticle;
        // Για κάθε άρθρο πλην το τελευταίο, δηλαδή το checkArticle
        for (int i = 0; i < articles.size()-1 ; i++) {
            iterationArticle = articles.get(i);
            if (checkArticle.getTitle().equals(iterationArticle.getTitle()) &&
                    Arrays.equals(checkArticle.getAuthors(), iterationArticle.getAuthors())) {
                // Εάν βρεθεί διπλό άρθρο, τότε γυρνάει true
                return true;
            }
        }
        return false;
    }

    public static void connectAuthorToArticle(Article ArticleSearch, Author ConnectAuthor) {
        // Αν υπάρχει ήδη συγγραφέας στην πρώτη θέση του array authors του άρθρου, τότε συνδέει το σύστημα 
        // τον συγγραφέα που δώθηκε στην δεύτερη θέση του συγγραφέα
        if (ArticleSearch.getAuthors()[0] != null) {
            ArticleSearch.setAuthors(ConnectAuthor, 1);
        } else {
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

                        // articles.get(articles.size()-1) μας δίνει το τελευταίο άρθρο στο ArrayList
                        connectAuthorToArticle(articles.get(articles.size() - 1), searchArticle.getAuthors()[j]);
                        return true;
                    }
                }
                j++;
            }
        }
        // Αν δεν μπει στην εσωτερική if, τότε γυρνάει false
        return false;
    }

    public static boolean findReviewer(String searchEmail) {
        for (Person searchReviewer : reviewers) {
            if (searchReviewer != null) {
                if (searchReviewer.getEmail().equals(searchEmail)) {
                    System.out.println("Ο αξιολογητής με το email " + searchEmail + " υπάρχει ήδη στο σύστημα...");
                    System.out.println("Το σύστημα θα συνδέσει το άρθρο που υποβάλλατε με τον ήδη υπάρχων αξιολογητή");

                    // articles.get(articles.size()-1)) είναι το τελευταίο άρθρο στο ArrayList articles
                    articles.get(articles.size() - 1).setReviewer((Reviewer) searchReviewer);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean isValidEmail(String email) {
        // Ο κώδικας για την συγκεκριμένη μέθοδο βρέθηκε στο link παρακάτω
        // https://www.tutorialspoint.com/validate-email-address-in-java
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public static void main(String[] args) {
        int choice;
        int searchID;
        Article foundArticle;
        String searchEmail;

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
                        articles.add(new FullPaper());
                    } 
                    else {
                        articles.add(new PaperInProgress());
                    }


                    // After saving the new article, we save info regarding the authors
                    int iterations = articles.get(articles.size() - 1).howManyAuthors();
                    for (int i = 0; i < iterations; i++) {
                        boolean emailExists;
                        System.out.println("\nΠαρακαλώ o " + (i + 1) + "ος συγγραφέας να πληκτρολογήσει το email του:");
                        searchEmail = input.next();
                        // Έλεγχος εαν το email γράφτηκε με τον σωστό τρόπο
                        while (!isValidEmail(searchEmail)) {
                            System.out.println("\nΔεν γράψατε σωστά το email\nΤo email πρέπει να είναι του τύπου: xxx@yyy.zzz\nΠροσπαθήστε ξανά");
                            searchEmail = input.next();
                        }
                        
                        // Έλεγχος για το δεύτερο email, αν 2ος συγγραφέας έχει το ίδιο email με τον πρώτο, 
                        // γυρνάμε πίσω την επανάληψη
                        if (i == 1) {
                            if (articles.get(articles.size() - 1).getAuthors()[0].getEmail().equals(searchEmail)) {
                                System.out.println("Για τον δεύτερο συγγραφέα εισάγατε το ίδιο email με τον πρώτο");
                                System.out.println("Προσπαθήστε ξανά\n");
                                i--;
                                continue;
                            }
                        }

                        // Εάν ο συγγραφέας υπάρχει ήδη, συνδέει το σύστημα τον συγγραφέα με το άρθρο 
                        emailExists = findAuthor(searchEmail);

                        // Εάν στις επαναλήψεις πάνω δεν βρέθηκε παρόμοιο email, τότε ο χρήστης θα εισάγει τα στοιχεία του
                        if (!emailExists) {
                            // Αποθηκεύουμε τα στοιχεία του συγγραφέα[i] στο άρθρο
                            articles.get(articles.size() - 1).setAuthors(new Author(searchEmail), i);
                        }

                    }

                    // Ελέγχουμε αν υπάρχει άρθρο με τον ίδιο τίτλο και τους ίδιους συγγραφείς
                    if (checkDuplicateArticle(articles.get(articles.size()-1))) {
                        System.out.println("\nΥπάρχει ήδη άρθρο στο σύστημα μας με τους ίδιους συγγραφείς και τον ίδιο τίτλο");
                        // Διαγραφή του άρθρου από το σύστημα
                        articles.remove(articles.get(articles.size()-1));
                        
                        // Αφού δεν θα αποθηκευτεί το άρθρο τελικά, γυρνάμε τον μετρητή των ID
                        // μια θέση πίσω
                        Article.setIDCounter(Article.getIDCounter()-1);
                        break;
                    }

                    // Εκτύπωση στοιχείων άρθρου
                    System.out.println(articles.get(articles.size()-1).toString());
                    
                    break;
                    
                case 2:
                    System.out.println("Εισάγετε τον κωδικό του άρθρου που ψάχνετε:");
                    searchID = input.nextInt();
                    if (!findArticle(searchID)) {
                        break;
                    }
                    foundArticle = articles.get(--searchID);

                    // Εκτύπωση τίτλου, ονόματος και επίθετου κάθε συγγραφέα
                    // + εκτύπωση τύπου άρθρου
                    if (foundArticle.getAuthors()[1] != null) {
                        System.out.println("Οι συγγραφείς του άρθρου είναι:");
                        System.out.println(foundArticle.getAuthors()[0].getTitleNameSurname() + ", " + foundArticle.getAuthors()[1].getTitleNameSurname());
                    }
                    else {
                        System.out.println("Ο συγγραφέας του άρθρου είναι:");
                        System.out.println(foundArticle.getAuthors()[0].getTitleNameSurname());
                    }
                    
                    if (foundArticle instanceof PaperInProgress) {
                        System.out.println("Το άρθρο είναι Άρθρο-σε-πρόοδο");
                    }
                    else {
                        System.out.println("Το άρθρο είναι Ολόκληρο");
                    }
                    

                    // Έλεγχος εάν υπάρχει ήδη αξιολογητής στο άρθρο
                    if (foundArticle.getReviewer() != null) {
                        System.out.println("Υπάρχει ήδη αξιολογητής για το συγκεκριμένο άρθρο");
                        break;
                    }
                    
                    
                    System.out.println("\nΓια την εισαγωγή αξιολογητή στο σύστημα παρακαλώ να γράψετε το email σας:");
                    searchEmail = input.next();
                    // Έλεγχος εαν το email γράφτηκε με τον σωστό τρόπο
                    while (!isValidEmail(searchEmail)) {
                        System.out.println("\nΔεν γράψατε σωστά το email\nΤo email πρέπει να είναι του τύπου: xxx@yyy.zzz\nΠροσπαθήστε ξανά");
                        searchEmail = input.next();
                    }
                    
                    // Εάν το email του αξιολογητή είναι ίδιο με κάποιο από τα email των συγγραφέων
                    // τότε δεν πρέπει να γίνει αξιολόγηση
                    if (foundArticle.isReviewerAnAuthor(searchEmail)) {
                        break;
                    }
                    
                    // Έλεγχος του email αν υπάρχει ήδη στο σύστημα
                    boolean emailExists;
                    emailExists = findReviewer(searchEmail);
                    if (!emailExists) {
                        
                        // Adding new reviewer to the users global ArrayList
                        reviewers.add(new Reviewer(searchEmail));

                        // Adding reviewer to the article
                        foundArticle.setReviewer((Reviewer) reviewers.get(reviewers.size() - 1));
                    }
                    break;
                    
                case 3:
                    // Ψάχνει το πρόγραμμα για το άρθρο
                    System.out.println("Για να αξιολογήσετε το άρθρο που θέλετε παρακαλώ να εισάγετε τον κωδικό του άρθρου: ");
                    searchID = input.nextInt();
                    if (!findArticle(searchID)) {
                        break;
                    }
                    foundArticle = articles.get(--searchID);
                    
                    // Αν δεν υπάρχει αξιολογητής στο άρθρο, ενημερώνουμε τον χρήστη
                    if (foundArticle.getReviewer() == null) {
                        System.out.println("Δεν έχει οριστεί αξιολογητής στο άρθρο...\nΓια να γίνει αξιολόγηση του άρθρου θα χρειαστεί πρώτα να χρησιμοποιήσετε την λειτουργία 2.");
                        break;
                    }
                    
                    // Εκτύπωση τίτλου, κωδικού και λέξεις κλειδιά του άρθρου
                    if (foundArticle instanceof PaperInProgress) {
                        System.out.println("Κωδικός άρθρου: " + foundArticle.getID() + ", " + "Τίτλος άρθρου: " + foundArticle.getTitle() + ", Τύπος άρθρου: Άρθρο-σε-πρόοδο και " + foundArticle.getProperty());
                    }
                    else {
                        System.out.println("Κωδικός άρθρου: " + foundArticle.getID() + ", " + "Τίτλος άρθρου: " + foundArticle.getTitle() + ", Τύπος άρθρου: Ολοκληρομένο Άρθρο και " + foundArticle.getProperty());
                    }

                    // Έλεγχος email αξιολογητή
                    System.out.println("Παρακαλώ γράψτε το email σας: ");
                    searchEmail = input.next();
                        // Έλεγχος εαν το email γράφτηκε με τον σωστό τρόπο
                    while (!isValidEmail(searchEmail)) {
                        System.out.println("\nΔεν γράψατε σωστά το email\nΤo email πρέπει να είναι του τύπου: xxx@yyy.zzz\nΠροσπαθήστε ξανά");
                        searchEmail = input.next();
                    }
                    
                    if (foundArticle.getReviewer().getEmail().equals(searchEmail)) {
                        
                        // Έλεγχος εάν έχει γίνει ήδη αξιολόγηση στο άρθρο
                        // Αν έχει γίνει, τότε ρωτάμε τον αξιολογητή εάν θέλει να
                        // αλλάξει την αξιολόγηση του συγκεκριμένου άρθρου
                        if (!foundArticle.isScoreZero()) {
                            System.out.println("Έχει γίνει ήδη αξιολόγηση στο άρθρο...");
                            System.out.println("Εάν θέλετε να ξαναγίνει αξιολόγηση πατήστε 1");
                            int redoReview = input.nextInt();
                            if (redoReview != 1) {
                                break;
                            }
                        }
                        
                        
                        // Letting reviewer score the article
                        System.out.println("\nΠαρακαλώ δώστε την βαθμολογία σας για το άρθρο");
                        System.out.println("Με την σειρά να εισάγετε την βαθμολογία για την Ερευνητική συνεισφορά, Ερευνητικά αποτελέσματα, Ερευνητική μεθοδολογία και την καινοτομία");
                        foundArticle.setScore();
                    } else {
                        System.out.println("Δεν εισάγατε το σωστό email...");
                        break;
                    }
                    
                    // Μετά την αξιολόγηση, εκτυπώνει το σύστημα τον τίτλο του άρθρου και
                    // την αξιολόγηση του
                    System.out.println("\nΤίτλος άρθρου: " + foundArticle.getTitle() + " και η αξιολόγηση του άρθρου: " + Arrays.toString(foundArticle.getScore()));
                    break;
                    
                case 4:
                    System.out.println("Για να δείτε την αξιολόγηση ενός άρθρου απλά πληκτρολογίστε τον κωδικό του άρθρου: ");
                    searchID = input.nextInt();
                    if (!findArticle(searchID)) {
                        break;
                    }
                    foundArticle = articles.get(--searchID);

                    // Αν υπάρχει το άρθρο, εκτυπώνουμε τον τίτλο και τον τύπο του άρθρου, τα ονόματα και τα
                    // επίθετα των συγγραφέων
                    if (foundArticle instanceof FullPaper) {
                        System.out.println("Τίτλος άρθρου: " + foundArticle.getTitle() + "\nΤύπος άρθρου: Πλήρες άρθρο και " + foundArticle.getProperty());
                    } 
                    else {
                        System.out.println("Τίτλος άρθρου: " + foundArticle.getTitle() + "\nΤύπος άρθρου: Άρθρο-σε-πρόοδο και " + foundArticle.getProperty());
                    }

                    // Εκτύπωση συγγραφέων (όνομα και επίθετο)
                    if (foundArticle.getAuthors()[1] != null) {
                        System.out.print("Συγγραφείς: ");
                        System.out.print(foundArticle.getAuthors()[0].getName() + " " + foundArticle.getAuthors()[0].getSurname());
                        System.out.print(", " + foundArticle.getAuthors()[1].getName() + " " + foundArticle.getAuthors()[1].getSurname());
                    }
                    else {
                        System.out.print("Συγγραφέας: ");
                        System.out.print(foundArticle.getAuthors()[0].getName() + " " + foundArticle.getAuthors()[0].getSurname());
                    }
                    System.out.println("");

                    // Εάν δεν έχει ανατεθεί αξιολογητής στο άρθρο, τότε ενημερώνει το σύστημα τον χρήστη
                    if (foundArticle.getReviewer() == null) {
                        System.out.println("\nΕκκρεμεί ορισμός αξιολογητή");
                        break;
                    }

                    // Εάν ο αξιολογητής δεν έχει αξιολογήσει το άρθρο, τότε ενημερώνουμε τον χρήστη
                    if (foundArticle.isScoreZero()) {
                        System.out.println("\nΆρθρο προς αξιολόγηση");
                        break;
                    }

                    // Μόνο εάν υπάρχει αξιολογητής και υπάρχει και βαθμολογία θα εκτυπωθούν τα παρακάτω
                    System.out.println("Με την σειρά έχουμε βαθμολογία για Ερευνητική συνεισφορά, Ερευνητικά αποτελέσματα, Ερευνητική μεθοδολογία και την καινοτομία:\n" + Arrays.toString(foundArticle.getScore()));
                    break;
                    
                case 5:
                    // Αποθηκεύουμε στις 2 μεταβλητές τους τύπους άρθρων
                    int articlesF = 0, articlesPIP = 0;
                    for (Article countingArticles : articles) {
                        if (countingArticles instanceof FullPaper) {
                            articlesF++;
                        } else {
                            articlesPIP++;
                        }
                    }

                    System.out.println("Συνολικό πλήθος των άρθρων στο σύστημα είναι " + articles.size());
                    System.out.println("Υπάρχουν " + articlesF + " πλήρες άρθρα και " + articlesPIP + " άρθρα-σε-πρόοδο στο σύστημα μας.");
                    break;
                    
                default:
                    System.out.println("Ευχαριστούμε που μας προτίμησες! Καλή συνέχεια!");
                    return;
                    
            }
            menuPrint();
        }

    }
}