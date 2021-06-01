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
public class It22105 {

    public static void main(String[] args) {
        // Initiating scanner class for input from terminal
        Scanner input = new Scanner(System.in);
        articles article = new articles();
        menu menu = new menu(article);
        menu.Choice(0);
        
        while (menu.getOperation()!= -1) {
            menu.setOperation(input.nextInt());
            menu.Choice(menu.getOperation());
        }
        
        
    }
    
}
