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
public class Student extends Human {
    private String AM; 
    private String academicDepartment;
    private int Semester;

    public Student(String ID, String FullName, String DateOfBirth, String AM, String telephoneNumber, String Address, String academicDepartment, int Semester) {
        super(ID, FullName, DateOfBirth, telephoneNumber, Address);
        this.academicDepartment = academicDepartment;
        this.Semester = Semester;
    }

    public String getAcademicDepartment() {
        return academicDepartment;
    }

    public void setAcademicDepartment(String academicDepartment) {
        this.academicDepartment = academicDepartment;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }
    
    @Override
    public String toString() {
        return super.toString() +
                "\nacademicDepartment: " + academicDepartment +
                "\nSemester: " + Semester;
    }
    
    public void advanceSemester() {
        setSemester(Semester+1);
    }
}
