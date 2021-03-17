/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.model;

import java.math.BigDecimal;

/**
 *
 * @author Dreamville
 */
public class Change {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    public int getQuarters() {
        return quarters;
    }

    public void setQuarters(int quarters) {
        this.quarters = quarters;
    }

    public int getDimes() {
        return dimes;
    }

    public void setDimes(int dimes) {
        this.dimes = dimes;
    }

    public int getNickels() {
        return nickels;
    }

    public void setNickels(int nickels) {
        this.nickels = nickels;
    }

  
    
     
    public Change(BigDecimal userChange) {
       
        BigDecimal change = new BigDecimal("0.00");
        
        BigDecimal pennyConvert = new BigDecimal("100");

        BigDecimal quarter = new BigDecimal("25");

        BigDecimal dime = new BigDecimal("10");

        BigDecimal nickel = new BigDecimal("5");
        
        BigDecimal changeDueBack = userChange.multiply(pennyConvert);
        
        
         if (changeDueBack.compareTo(change) >= 0) {

            while (changeDueBack.compareTo(quarter) >= 0) { 
                changeDueBack = changeDueBack.subtract(quarter);
                quarters++; 
            }

            while (changeDueBack.compareTo(dime) >= 0) {
               changeDueBack = changeDueBack.subtract(dime);
                dimes++;
            }

            while (changeDueBack.compareTo(nickel) >= 0) {
                changeDueBack = changeDueBack.subtract(nickel);
                nickels++;
            }
         
        }
    }
    
    
    
    @Override
    public String toString() {
        return quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, ";
    }
}
