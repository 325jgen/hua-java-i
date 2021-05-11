/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoc;

/**
 *
 * @author nsgou
 */
public class MeteoClock extends Clock{
    private float temperature;
    private float pressure;

    public MeteoClock(float temperature, float pressure, int hours, int minutes, int seconds, int alarmHours, int alarmMinutes, int alarmSeconds, int format, String name) {
        super(hours, minutes, seconds, alarmHours, alarmMinutes, alarmSeconds, format, name);
        this.temperature = temperature;
        this.pressure = pressure;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
    @Override
    public String getTime(){
      return super.getTime()+" and the Temperature is"+temperature+" and the Pressure is "+pressure;
   }
    
}
