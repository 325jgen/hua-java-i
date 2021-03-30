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
    
    private int hours, minutes;
    
    private int alarmHours, alarmMinutes;
    
    public clock(int hours, int minutes, String name) {
        this.hours = hours;
        this.minutes = minutes;
        this.name = name;
    }
    
    public clock(int hours, String name, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        this.name = name;
    }

    // Setters and getters for the class's attributes
    
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
 
    
    public void advanceTime(int newHours, int newMinutes) {
        /* 
         * I convert the newMinutes to extraHours, for example:
         * If newMinutes is 120 -> extraHours = 2, so I just
         * add the extraHours to the hours.
         * Obviously, if there are no extra hours, it will
         * just add 0, which will do no harm.
         *
         */
        int extraHours = 0;
        
        if (newMinutes >= 60) {
            extraHours = (minutes+newMinutes)/60;
            if (newHours != 0) {
                newHours += extraHours;
            } 
            else {
                newHours = extraHours;
            }
            newMinutes -= 60*extraHours;
        }
        
        if (minutes+newMinutes >= 60) {
            extraHours++;
            minutes = (minutes+newMinutes) - 60;
        } 
        else {
            minutes += newMinutes;
        }
        
        hours += newHours;
        if (hours >= format) {
            hours -= format;
        }
    }
    
    public void tellTime() {
        System.out.println("The time now is: " + hours + ":" + minutes + " and the alarm is set for " + alarmHours + ":" + alarmMinutes);
    }
    
    
}
