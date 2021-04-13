/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoc;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author jwin
 */
public class Tictoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int hrs = LocalDateTime.now().getHour();
        int mins = LocalDateTime.now().getMinute();
        int sec = LocalDateTime.now().getSecond();
        
         clock clk1 = new clock(hrs, mins, sec, "ALARM");
        
        // Entering alarm hour, minutes and seconds
        System.out.printf("Enter alarm hour: ");
        clk1.setAlarmHours(input.nextInt());
        
        System.out.printf("Enter alarm minutes: ");
        clk1.setAlarmMinutes(input.nextInt());
        
        System.out.printf("Enter alarm seconds: ");
        clk1.setAlarmSeconds(input.nextInt());
        
        // Checking if name contains the character a 
        if (clk1.getName().contains("a")) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
        
        clk1.tellTime();
        System.out.println(clk1.getTime());    
    }
}
