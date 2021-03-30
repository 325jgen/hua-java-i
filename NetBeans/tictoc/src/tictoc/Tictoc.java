/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictoc;

/**
 *
 * @author jwin
 */
public class Tictoc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        clock clk1 = new clock(20, 17, "Morning");
        
        clk1.tellTime();
        
        clk1.setAlarmHours(8);
        clk1.setAlarmMinutes(20);
        clk1.setFormat(24);
        
        clk1.tellTime();
        
        clk1.advanceTime(0, 369);
        
        clk1.tellTime();
        
    }
    
}
