/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineSpringDao;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Items;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Dreamville
 */
public class VendingMachineSpringServiceInMemImpl implements VendingMachineSpringService {
    
    VendingMachineSpringDao dao;
    
    @Inject
    public VendingMachineSpringServiceInMemImpl(VendingMachineSpringDao dao) {
        this.dao = dao;
        
    }
            

    @Override
    public BigDecimal purchaseItem(Items item, BigDecimal vaultMoney){
        BigDecimal cost = item.getItemPrice();
        BigDecimal balanceDue = vaultMoney.subtract(cost);
        return balanceDue;
            
       }
    
    

    @Override
    public Items getItem(String itemID) {
        return dao.getItem(itemID);
    }

    @Override
    public List<Items> getAllItems() {
        List<Items> items = dao.getAllItems();
        return items;
    }

  
    
    @Override
    public BigDecimal addDollars(BigDecimal userMoney) {
        BigDecimal dollar = new BigDecimal("1.00");

        userMoney = userMoney.add(dollar);

        return userMoney;
    }
 
     @Override
    public BigDecimal addQuarters(BigDecimal userMoney) {
        BigDecimal quarter = new BigDecimal(".25");

       userMoney = userMoney.add(quarter);

        return userMoney;
    }

    @Override
    public BigDecimal addDimes(BigDecimal userMoney) {
        BigDecimal dime = new BigDecimal(".10");

        userMoney = userMoney.add(dime);

        return userMoney;
    }

   @Override
    public BigDecimal addNickels(BigDecimal userMoney) {
        BigDecimal nickel = new BigDecimal(".05");

        userMoney = userMoney.add(nickel);

        return userMoney;
    
    }

    @Override
    public void validateItemInventory(Items item) throws NoItemInventoryException {
        if(item.getItemQuantity() <= 0) {
                throw new NoItemInventoryException("Out of stock");
            } 
    }

    @Override
    public void validInsufficientFunds(Items item, BigDecimal userMoney) throws InsufficientFundsException {
        BigDecimal costItem = item.getItemPrice();
            
            if(costItem.compareTo(userMoney) > 0) {
                BigDecimal difference = costItem.subtract(userMoney);
                throw new InsufficientFundsException("Please insert $ " + difference.toString() + ".");
            }
    }

    @Override
    public void validateId(Items item) throws NoItemInventoryException {
        
        if (item == null) {
                throw new NoItemInventoryException("This item does not exist. Please select an item");
            } 
    }

    @Override
    public Items reduceInventory(String itemID) {
        return dao.ReduceInventory(itemID);
    }

    
    
    
    
}
