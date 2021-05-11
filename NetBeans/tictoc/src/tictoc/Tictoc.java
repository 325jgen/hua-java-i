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
 * @author nsgou
 */
public class Tictoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     /* Construct a new object of class Clock using one of the available   
        available constructors
     */
        int hrs=LocalDateTime.now().getHour();
        int mins=LocalDateTime.now().getMinute();
        int secs=LocalDateTime.now().getSecond();
        Clock.howManyClocks();
        Clock clk1=new Clock(hrs,mins,secs,"Hua");
     // Set attribute Hours in object clk1 with the value 20  
        Clock.howManyClocks();
        MeteoClock meteoClk1=new MeteoClock(15.8f,23.7f,hrs,mins,secs,12,25,36,24,"MeteoHua");
        System.out.println(meteoClk1.getTime());
        Scanner input=new Scanner(System.in);
        System.out.printf("Give Hours:");
        clk1.setAlarmHours(input.nextInt());
        System.out.printf("Give Minutes:");
        clk1.setAlarmMinutes(input.nextInt());
        System.out.printf("Give Seconds:");
        clk1.setAlarmSeconds(input.nextInt());
        clk1.setFormat(24);
        clk1.tellTime();
        clk1.advanceTime(200);
        clk1.tellTime();
        
        if(clk1.getName().contains("a")){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
        System.out.println(clk1.getTime());
        
        for (int i=0;i<10;i++){
            StopWatch temp=new StopWatch(hrs,mins,secs);
            clk1.appendStopWatchList(temp);
        }
        
        for (int i=0;i<clk1.getStopWatchList().size();i++){
            System.out.println(clk1.getStopWatchList().get(i).getHours()+":"+clk1.getStopWatchList().get(i).getMinutes()+":"+clk1.getStopWatchList().get(i).getSeconds());
        }
    
}
    }
    

