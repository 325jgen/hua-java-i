/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoc;

import java.util.ArrayList;

/**
 *
 * @author nsgou
 */
public class Clock {
    // create a number of variables. 
    private int hours;
    private int minutes;
    private int seconds;
    
    private int alarmHours;
    private int alarmMinutes;
    private int alarmSeconds; 
    
    private int format;
    private String name;
    static int clocks=0;
    
    private ArrayList<StopWatch> stopWatchList=new ArrayList<>();
    
/* Create two constructors that can be used for initializing objects of class clock
   Note that as the type of parameters change in sequence the two constructors 
   are different. In order to introduce a constructor in an automated way in
   Netbeans we utilize the keyboard combination Alt+Ins 
*/
    public Clock(int hours, int minutes, int seconds, String name) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds=seconds;
        this.name = name;
        clocks++;   
    }
    public Clock(int hours, String name, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        this.name = name;
        clocks++;
        
    }
    public Clock(){
    hours=0;
    minutes=0;
    seconds=0;
    
    alarmHours=0;
    alarmMinutes=0;
    alarmSeconds=0; 
    
    format=0;
    name="";
    clocks++;
    }

    public Clock(int hours, int minutes, int seconds, int alarmHours, int alarmMinutes, int alarmSeconds, int format, String name) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.alarmHours = alarmHours;
        this.alarmMinutes = alarmMinutes;
        this.alarmSeconds = alarmSeconds;
        this.format = format;
        this.name = name;
        clocks++;
    }
    
      
       
/* Automated creation of setters and getters is performed using the Alt+Ins
keyboard combination (multiple standard setters and getters can be created
at once
*/
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getAlarmHours() {
        return alarmHours;
    }

    public void setAlarmHours(int alarmHours) {
        this.alarmHours = alarmHours;
    }

    public int getAlarmMinutes() {
        return alarmMinutes;
    }

    public void setAlarmMinutes(int alarmMinutes) {
        this.alarmMinutes = alarmMinutes;
    }

    public int getAlarmSeconds() {
        return alarmSeconds;
    }

    public void setAlarmSeconds(int alarmSeconds) {
        this.alarmSeconds = alarmSeconds;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   public void advanceTime(int duration){
       hours+=duration/3600;
       minutes+=(duration%3600)/60;
       seconds+=(duration%3600)%60;
       if(seconds>=60){
           minutes++;
           seconds-=60;
       }
       if(minutes>=60){
           hours++;
           minutes-=60;
       }
       hours%=format;
   }
   public void tellTime(){
       System.out.printf("The time is %02d:%02d:%02d and the alarm is set for %02d:%02d:%02d \n", hours,minutes,seconds,alarmHours,alarmMinutes,alarmSeconds);
   }public String getTime(){
      return "The time is "+getHours()+":"+getMinutes()+":"+getSeconds();
   }
   
   public static void howManyClocks(){
       System.out.println("Number of Clocks is "+clocks+" clocks");
   }
   
   public void appendStopWatchList(StopWatch countdown){
       stopWatchList.add(countdown);
   }
   public ArrayList<StopWatch> getStopWatchList(){
       return stopWatchList;
   }
}
