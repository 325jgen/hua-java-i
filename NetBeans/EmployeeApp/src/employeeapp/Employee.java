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
public  abstract class Employee {
    private String name;
    private String taxID;

    public Employee(String name, String taxID) {
        this.name = name;
        this.taxID = taxID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }
    @Override
    public String toString(){
        return "Name: "+name+" TaxID: "+taxID;
    }
    public abstract double getSalary();
}
