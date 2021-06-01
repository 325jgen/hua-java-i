/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeapp;

/**
 *
 * @author nsgou
 */
public class Hourly extends Employee{
    private int hours;
    private double rate;

    public Hourly(int hours, double rate, String name, String taxID) {
        super(name, taxID);
        this.hours = hours;
        this.rate = rate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    public double getSalary(){
        return hours*rate;
    }
    public double getTax(){
        return getSalary()*TaxPayer.catHourly;
    }
}
