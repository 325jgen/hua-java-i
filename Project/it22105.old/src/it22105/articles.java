/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it22105;

import java.util.Scanner;

/**
 *
 * @author jwin
 */
public class articles {
    static int articles = -1;
    
    private String[] articleID = new String[10];
    private String[] articleTitle = new String[10];
    private String[][] articleKeywords = new String[10][3];
    // Up to two Authors
    private String[] articleAuthors = new String[10];
    // Types:
    // Full Paper
    // Paper in Progess: i) regular, ii) case-study -> όνομα δημόσιου/ιδιωτικού
    //                                                               οργανισμού
    private String[] articleType = new String[10];
    // If article type is full paper, the article sub type variable will be empty
    private String[] articleSubType = new String[10];
    int[][] articleReviewScore = new int[10][4];
    
    private String[] authorName = new String[10];
    private String[] authorSurname = new String[10];
    private String[] authorEmail = new String[10];
    // Next two are not necessary
    private String[] authorTitle = new String[10];
    private String[] authorOrg = new String[10];
    
    private String[] evaluatorEmail;
    private String[] evaluatorName;
    private String[] evaluatorSurname;
    private String[] evaluatorTitle;
    private String[] evaluatorOrg;
    
    Scanner input = new Scanner(System.in);

    // Constructors

    public articles() {
        
    }

    public articles(String[] articleID, String[] articleTitle, String[][] articleKeywords, String[] articleAuthors, String[] articleType, String[] articleSubType, int[][] articleReviewScore, String[] authorName, String[] authorSurname, String[] authorEmail, String[] authorTitle, String[] authorOrg) {
        this.articleID = articleID;
        this.articleTitle = articleTitle;
        this.articleKeywords = articleKeywords;
        this.articleAuthors = articleAuthors;
        this.articleType = articleType;
        this.articleSubType = articleSubType;
        this.articleReviewScore = articleReviewScore;
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.authorEmail = authorEmail;
        this.authorTitle = authorTitle;
        this.authorOrg = authorOrg;
    }
    
    
    // Setters and getters 
    
    public String[] getArticleID() {
        return articleID;
    }

    public void setArticleID(String[] articleID) {
        this.articleID = articleID;
    }

    public String[] getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String[] articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String[][] getArticleKeywords() {
        return articleKeywords;
    }

    public void setArticleKeywords(String[][] articleKeywords) {
        this.articleKeywords = articleKeywords;
    }

    public String[] getArticleAuthors() {
        return articleAuthors;
    }

    public void setArticleAuthors(String[] articleAuthors) {
        this.articleAuthors = articleAuthors;
    }

    public String[] getArticleType() {
        return articleType;
    }

    public void setArticleType(String[] articleType) {
        this.articleType = articleType;
    }

    public String[] getArticleSubType() {
        return articleSubType;
    }

    public void setArticleSubType(String[] articleSubType) {
        this.articleSubType = articleSubType;
    }

    public int[][] getArticleReviewScore() {
        return articleReviewScore;
    }

    public void setArticleReviewScore(int[][] articleReviewScore) {
        this.articleReviewScore = articleReviewScore;
    }

    public String[] getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String[] authorName) {
        this.authorName = authorName;
    }

    public String[] getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String[] authorSurname) {
        this.authorSurname = authorSurname;
    }

    public String[] getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String[] authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String[] getAuthorTitle() {
        return authorTitle;
    }

    public void setAuthorTitle(String[] authorTitle) {
        this.authorTitle = authorTitle;
    }

    public String[] getAuthorOrg() {
        return authorOrg;
    }

    public void setAuthorOrg(String[] authorOrg) {
        this.authorOrg = authorOrg;
    }

    public String[] getEvaluatorEmail() {
        return evaluatorEmail;
    }

    public void setEvaluatorEmail(String[] evaluatorEmail) {
        this.evaluatorEmail = evaluatorEmail;
    }

    public String[] getEvaluatorName() {
        return evaluatorName;
    }

    public void setEvaluatorName(String[] evaluatorName) {
        this.evaluatorName = evaluatorName;
    }

    public String[] getEvaluatorSurname() {
        return evaluatorSurname;
    }

    public void setEvaluatorSurname(String[] evaluatorSurname) {
        this.evaluatorSurname = evaluatorSurname;
    }

    public String[] getEvaluatorTitle() {
        return evaluatorTitle;
    }

    public void setEvaluatorTitle(String[] evaluatorTitle) {
        this.evaluatorTitle = evaluatorTitle;
    }

    public String[] getEvaluatorOrg() {
        return evaluatorOrg;
    }

    public void setEvaluatorOrg(String[] evaluatorOrg) {
        this.evaluatorOrg = evaluatorOrg;
    }
    
    // End of Setters and Getters
    
    
    private void printArticleInfo(int i) {
        System.out.println("ID: " + articleID[i]);
        System.out.println("Title: " + articleTitle[i]);
        
        // Here we check for the STOP flag in the array of keywords to correctly
        // print out the keywords, meaning if there are none -> print nothing and so on
        if (articleKeywords[i][0].equals("STOP")) {
            System.out.println("No keywords");
        } 
        else if (articleKeywords[i][1].equals("STOP")) {
            System.out.println("Keywords: " + articleKeywords[i][0]);
        }
        else if (articleKeywords[i][2].equals("STOP")) {
            System.out.println("Keywords: " + articleKeywords[i][0] + ", " + articleKeywords[i][1]);
        }
        else {
            System.out.println("Keywords: " + articleKeywords[i][0] + ", " + articleKeywords[i][1] + ", " + articleKeywords[i][2]);
        }
        
        System.out.println("Authors: " + articleAuthors[i]);
        System.out.println("Type: " + articleType[i]);
        if ("Paper in progress".equals(articleType[i])) {
            System.out.println("Sub Type: " + articleSubType[i]);
        }
    }
    
    private void printAuthorsInfo() {
        // TODO
    }
    
    public void newArticle() {
        // Everytime we enter the first menu choice, we have one more new article
        // in the system
        articles++;
        
        // Saving input into class
        // TODO: ID has to be random, now is manual
        System.out.printf("Enter ID: ");
        articleID[articles] = input.next();
        
        System.out.printf("Enter title: ");
        articleTitle[articles] = input.next();
        
        // A for loop is used for exactly 3 iterations, breaks if input is 
        // the STOP flag
        System.out.printf("Enter up to 3 keywords (to end, type stop): ");
        for (int i = 0; i < 3; i++) {
            String keyword = input.next();
            if (keyword.equals("stop") || keyword.equals("STOP")) {
                articleKeywords[articles][i] = "STOP";
                break;
            }
            articleKeywords[articles][i] = keyword;
        }
        
        System.out.printf("Enter authors: ");
        articleAuthors[articles] = input.next();
        
        System.out.printf("Enter type (Full or PIP (Paper in progress)): ");
        articleType[articles] = input.next();
        if (articleType[articles].equals("PIP")) {
            articleType[articles] = "Paper in progress";
            
            System.out.printf("Enter subtype (Regular or (CS) Case Study): ");
            articleSubType[articles] = input.next();
            
            if (articleSubType[articles].equals("CS")) {
                articleSubType[articles] = "Case Study";
            }
        }
        
        // Printing out everything we inserted
        printArticleInfo(articles);
    }
    
    public void newAuthor() {
        // Inputs
        
        // TODO
        // Have to check if the email already exists in the system, if it does
        // then i) the system has to link the author with the inserted article
        //     ii) the system does not have to enter information again
        //    iii) the system has to ask if the author wants to insert a co-author
        //         and if the co-author exists in the system, it has to fill
        //         out the credentials again
        System.out.printf("Enter email: ");
        // Here I have to check if the email is realistic, meaning the format of
        // the mail has to be: xxx@yyy.zzz
        authorEmail[articles] = input.next();
        
        System.out.printf("Enter Author's name: ");
        authorName[articles] = input.next();
        
        System.out.printf("Enter Author's surname: ");
        authorSurname[articles] = input.next();
        
        System.out.printf("Enter title of author (or STOP to not input anything): ");
        authorTitle[articles] = input.next();
        if (authorTitle[articles].equals("STOP")) {
            authorTitle[articles] = "None";
        }
        
        
        
        System.out.printf("Enter organisation of author (or STOP to not input anything): ");
        authorOrg[articles] = input.next();
        if (authorOrg[articles].equals("STOP")) {
            authorOrg[articles] = "None";
        }
        
        // When all of the steps above are done, print out article info and 
        // info of the authors
        printAuthorsInfo();
        printArticleInfo(articles);
    }
    
    private void newEvaluator(int i) {
        System.out.printf("Enter email: ");
        // Here I have to check if the email is realistic, meaning the format of
        // the mail has to be: xxx@yyy.zzz
        evaluatorEmail[i] = input.next();
        if (searchEmail(evaluatorEmail[i]) == 1) {
            System.out.println("Email was found in the system, ");
        }
        else {
            
        }
        
    }
    
    private int searchEmail(String email) {
        // If email found return 1 else return 0
    }
    
    
    public void searchArticle(String searchID) {
        // TODO
        int i = 0;
        while(!articleID[i].equals(searchID) || i >= articles) {
            i++;
        }
        
        if (i >= articles) {
            System.out.println("Article not found");
            return;
        }
        
        // After succesfully finding article, type out info
        
        // TODO: Implement a method to print out all authors of an article
        //       correctly, for now only the first one will print out
        // TODO: Implement a method to print out the type of an article
        //       correctly -> Main type and SubType, for now only main type
        System.out.printf("Article's title " + articleID[i] + "\nAuthor name: " + authorName[i] + "\nAuthro's surname: " + authorSurname[i] + "\nArticle's type: " + articleType[i]);
        
        // Enter the 
        
        newEvaluator(i);
        
    }
    
    
    
}
