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
public class Faculty extends Human {
    public String title;
    private double salary;
    private String academicDepartment;

    public Faculty(String ID, String FullName, String DateOfBirth, String telephoneNumber, String Address, String title, String academicDepartment) {
        super(ID, FullName, DateOfBirth, telephoneNumber, Address);
        this.title = title;
        this.salary = salary;
        this.academicDepartment = academicDepartment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAcademicDepartment() {
        return academicDepartment;
    }

    public void setAcademicDepartment(String academicDepartment) {
        this.academicDepartment = academicDepartment;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
                "\nTitle: " + title +
                "\nSalary: " + salary +
                "\nacademicDepartment: " + academicDepartment;
    }
}
