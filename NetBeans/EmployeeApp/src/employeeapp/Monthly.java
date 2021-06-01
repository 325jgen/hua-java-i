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
public class Monthly extends Employee implements TaxPayer{
    private double monthlySalary;

    public Monthly(double monthlySalary, String name, String taxID) {
        super(name, taxID);
        this.monthlySalary = monthlySalary;
    }
    public double getSalary(){
        return monthlySalary;
}
    public double getTax(){
      if (getSalary()<=534)
          return 0;
      else
          return (getSalary()-534)*TaxPayer.catMonthly;
    }
}
