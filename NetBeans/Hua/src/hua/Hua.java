/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hua;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author jg
 */
public class Hua {

    /**
     * @param args the command line arguments
     */
    
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        ArrayList<Human> users = new ArrayList<>();
        
        Staff s1 = new Staff("s1", "Petros Petrou", "2/8/1988", "2102819998", "Naxou 5", "Logistirio", 800);
        Staff s2 = new Staff("s2", "Ariadni Gogou", "29/1/1975", "2104537228", "Kuprou 28", "Misthodosia", 1000);
        Staff s3 = new Staff("s3", "Mary Theodorou", "11/12/1994", "2105432148", "Limnou 12" , "Vivliothiki", 1200);
        
        users.add(s1);
        users.add(s2);
        users.add(s3);
    
        Student st1 = new Student("st1", "John Doe", "IT22101", "01/02/1999", "222029221", "Olympou 15", "Department of Informatics", 4);
        Student st2 = new Student("st2", "Maria Pappa", "P12008", "23/5/1997", "2102987228", "Stadiou 22", "Department of Informatics", 8);
        Student st3 = new Student ("st3", "George D", "P98221", "09/12/2000", "699999999", "Strat 2", "Department of Geography", 4);
    
        users.add(st1);
        users.add(st2);
        users.add(st3);
        
        Faculty fst1 = new Faculty("st1", "Marios Antoniou", "22/3/1996", "2107812345", "Kerkyras 92", "Epikouros", "Department of Geography");
        Faculty fst2 = new Faculty("st2", "Petroula Vagia", "11/5/1992", "2107788999", "Leukadas 72", "Anaplirotis", "Department of Informatics");
        Faculty fst3 = new Faculty("st3", "Marilena Vaiou", "8/11/1970", "2102233115", "Paxon 8" , "Kathigitis", "Department of Informatics");
        
        users.add(fst1);
        users.add(fst2);
        users.add(fst3);
        
        for (Human print : users) {
            if (print instanceof Staff) {
                ((Staff) print).giveRaise(50);
            }
            else if (print instanceof Student) {
                ((Student) print).advanceSemester();
            }
            
            System.out.println(print.toString());
        }
        
        
    }
    
}
