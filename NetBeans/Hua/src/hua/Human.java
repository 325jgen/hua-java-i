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
public abstract class Human {
    public String ID;
    public String FullName;
    private String DateOfBirth;
    private String telephoneNumber;
    private String Address;

    public Human(String ID, String FullName, String DateOfBirth, String telephoneNumber, String Address) {
        this.ID = ID;
        this.FullName = FullName;
        this.DateOfBirth = DateOfBirth;
        this.telephoneNumber = telephoneNumber;
        this.Address = Address;
    }
    
  
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    @Override
    public String toString() {
        return  "\nID: " + ID +
                "\nfullName: " + FullName +
                "\nDateOfBirth: " + DateOfBirth +
                "\nTelephoneNumber: " + telephoneNumber +
                "\nAddress: " + Address;
    }
    
}
