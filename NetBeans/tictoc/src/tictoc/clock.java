/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoc;

/**
 *
 * @author jwin
 */
public class clock {
    private String name;
    private int format;
    
    private int hours, minutes, seconds;
    
    private int alarmHours, alarmMinutes, alarmSeconds;
    
    public clock(int hours, int minutes, int seconds, String name) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.name = name;
    }
    
    public clock(int hours, String name, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        this.name = name;
    }

    // Setters and getters for the class's attributes

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getAlarmtSeconds() {
        return alarmSeconds;
    }

    public void setAlarmSeconds(int alertSeconds) {
        this.alarmSeconds = alertSeconds;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFormat() {
        return format;
    }

    public void setFormat(int format) {
        this.format = format;
    }

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
 
    
    public void advanceTime(int duration) {
        /* 
         * I convert the newMinutes to extraHours, for example:
         * If newMinutes is 120 -> extraHours = 2, so I just
         * add the extraHours to the hours.
         * Obviously, if there are no extra hours, it will
         * just add 0, which will do no harm.
         *
         * This does not apply anymore, as - for some reason - the correct
         * way to make this programm is to advance with seconds, not 
         * minutes.. This makes my original code "wrong". It still
         * works correctly though. I'm going to comment it out.
         */
        
//     My implementation of the program, now archived
//        int extraHours = 0;
//        
//        if (newMinutes >= 60) {
//            extraHours = (minutes+newMinutes)/60;
//            if (newHours != 0) {
//                newHours += extraHours;
//            } 
//            else {
//                newHours = extraHours;
//            }
//            newMinutes -= 60*extraHours;
//        }
//        
//        if (minutes+newMinutes >= 60) {
//            extraHours++;
//            minutes = (minutes+newMinutes) - 60;
//        } 
//        else {
//            minutes += newMinutes;
//        }
//        
//        hours += newHours;
//        if (hours >= format) {
//            hours -= format;
//        }

          hours += duration/3600;
          minutes += (duration%3600)/60;
          seconds += (duration%3600)%60;
          
          if (seconds >= 60) {
              minutes++;
              seconds -= 60;
          }
          
          if (minutes >= 60) {
              hours++;
              minutes -= 60;
          }
          
          hours %= format;
           
    }
    
    public void tellTime() {
        System.out.printf("The time now is %02d:%02d:%02d and the alarm is set for %02d:%02d:%02d\n", hours, minutes, seconds, alarmHours, alarmMinutes, alarmSeconds);
    }
    
    
}
