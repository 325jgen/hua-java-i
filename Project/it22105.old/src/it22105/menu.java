/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it22105;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author jwin
 */
public class menu {
    private int operation;
    articles article = new articles();
    Scanner input = new Scanner(System.in);
    
    public menu(articles article) {
        this.article = article;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
    
    private void Init() {
        System.out.println("Welcome to the e-conference system!");
        System.out.println("Please enter your desired operation (1-5)");
        System.out.println("1. Εισαγωγή νέου άρθρου\n2. Αναζήτηση άρθρου και Εισαγωγή αξιολογητή\n3. Εισαγωγή αξιολόγησης άρθρου\n4. Εμφάνιση αξιολόγησης άρθρου\n5. Εμφάνιση αναφορών");
    }
    
    public void Choice(int operation) {
        switch (operation) {
            case 0 -> {
                Init();
            }
            case 1 -> {
                article.newArticle();
                article.newAuthor();
            }
            case 2 -> {
                System.out.printf("Enter the article's ID you're searching for: ");
                article.searchArticle(input.next());
            }
            case 3 -> {
            }
            case 4 -> {
            }
            case 5 -> {
            }
        }
    }
}
