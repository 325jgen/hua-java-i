/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

/**
 *
 * @author jwin
 */
public class Helloworld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	int testScore = 7; 
	char verbalScore;
	
	if (testScore >= 5) {
		verbalScore = 'P'; // Passed
	}
	else {
		verbalScore = 'F'; // Failed
	}
	
	System.out.println("Your verbal score is " + verbalScore);
    }
    
}
