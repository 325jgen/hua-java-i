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
public class EmployeeApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Monthly employeeMonthly=new Monthly(2836.58,"George","123456789");
        Hourly employeeHourly=new Hourly(68,39.4,"Maria","789456123");
        
        System.out.println(employeeMonthly.toString()+" Salary: "+employeeMonthly.getSalary()+" Tax: "+employeeMonthly.getTax());
        System.out.println(employeeHourly.toString()+" Salary: "+employeeHourly.getSalary()+" Tax: "+employeeHourly.getTax());
    }
    
}
