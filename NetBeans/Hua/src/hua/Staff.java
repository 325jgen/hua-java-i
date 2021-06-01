/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hua;

/**
 *
 * @author jg
 */
public class Staff extends Human {
    private String Department;
    private double Salary;

    public Staff(String ID, String FullName, String DateOfBirth, String telephoneNumber, String Address, String Department, double Salary) {
        super(ID, FullName, DateOfBirth, telephoneNumber, Address);
        this.Department = Department;
        this.Salary = Salary;
    }

    
    
    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String Department) {
        this.Department = Department;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }
    
    @Override
    public String toString() {
        return super.toString() +
                "\nDepartment: " + Department +
                "\nSalary: " + Salary;
    }
    
    public void giveRaise(double amount) {
        setSalary(Salary+amount);
    } 
}
