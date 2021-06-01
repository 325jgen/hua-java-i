/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoc;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.InputMismatchException;


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
        Clock clk1=new Clock(hrs,mins,secs,"H1a");
     // Set attribute Hours in object clk1 with the value 20  
        Clock.howManyClocks();
        MeteoClock meteoClk1=new MeteoClock(15.8f,23.7f,hrs,mins,secs,12,25,36,24,"MeteoHua");
        System.out.println(meteoClk1.getTime());
        Scanner input=new Scanner(System.in);
        /* 
        Use of try catch in order to trap exception when entering invalid value 
        in in the nextInt call (Type Mismatch). Example -  Give Hours: 12rto.
        The program assigns some predefined ("default") values when the catch part is executed.
        */ 
        try{
        System.out.printf("Give Hours:");
        clk1.setAlarmHours(input.nextInt());
        System.out.printf("Give Minutes:");
        clk1.setAlarmMinutes(input.nextInt());
        System.out.printf("Give Seconds:");
        clk1.setAlarmSeconds(input.nextInt());
        }
        catch(InputMismatchException e){
            clk1.setAlarmHours(8);
            clk1.setAlarmMinutes(0);
            clk1.setAlarmSeconds(0);
            System.out.println("Invalid input - Reset to default");
        }
        /*
        Translate a set of values to the format of LocalTime and determine when the alarm
        sets off. The alarm time has to be set later than current system time else the 
        while loop will not exit
        */
       LocalTime alarmTime=LocalTime.of(clk1.getAlarmHours(), clk1.getAlarmMinutes(),clk1.getAlarmSeconds());
        while (true){ //Polls system time continuously
            System.out.println(LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond());
            if (LocalTime.now().isAfter(alarmTime)){
                System.out.println("Alarm");
                break;                
            }   
        }
        clk1.setFormat(24);
        clk1.tellTime();
        
        clk1.tellTime();
        
       
        if(clk1.getName().contains("a")){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
        char[] clockName=clk1.getName().toCharArray();
        if(Character.isLetter(clockName[0]) && Character.isLetter(clockName[1])){
            System.out.println("Name has a valid 2 letter prefix");
        }
        else{
            System.out.println("Name has not a valid 2 letter prefix");
            
        }
         
        System.out.println(clk1.getTime());
        /*
        
        
        //This part of code determines if a string that holds a number is actually a number 
        //Check is done by slicing the string to characters put in an array and repetitively 
        //checking the characters within that array.
        
        
        boolean isInteger;
        while(true){
            isInteger=true;
            
            System.out.println("Set Number of StopWatches:");
        
            String choice=input.next();
        
            char[] s=choice.toCharArray();
            
            for (int j=0; j<s.length; j++){
                
                if (!Character.isDigit(s[j])){
                    System.out.println("Invalid character:"+s[j]);
                    isInteger=false;
                    break;
                }
            }
            if(isInteger==true){
                int m=Integer.parseInt(choice);
            
                for (int i=0;i<m;i++){
                    StopWatch temp=new StopWatch(hrs,mins,secs);
                    clk1.appendStopWatchList(temp);
        }
                break;
            }
        }
        */
        
        /* 
        Alternative method for cheching that the users input is a number
        The try catch approach simplifies checks and resolves the situation as
        if a non numeric digit is entered during the nextint call an exception is raised 
        and the error can not be handled using an if clause.
        */
        while(true){
            
            System.out.println("Set Number of StopWatches:");
            try{
                int m=input.nextInt();
                
                for (int i=0;i<m;i++){
                    StopWatch temp=new StopWatch(hrs,mins,secs);
                    clk1.appendStopWatchList(temp);
            }
                break;
            }
            catch(InputMismatchException e){
                System.out.println("Invalid Input");
                input.nextLine();
            }
        }
                
        for (int i=0;i<clk1.getStopWatchList().size();i++){
            System.out.println(clk1.getStopWatchList().get(i).getHours()+":"+clk1.getStopWatchList().get(i).getMinutes()+":"+clk1.getStopWatchList().get(i).getSeconds());
        }
        // Using a for each approach (non functional programming)
        for (StopWatch listItem:clk1.getStopWatchList()){
            System.out.println(listItem.getHours()+":"+listItem.getMinutes()+":"+listItem.getSeconds());
        }
}
    }