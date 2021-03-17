/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Items;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Dreamville
 */
public interface VendingMachineSpringService {
    
    public BigDecimal purchaseItem(Items item, BigDecimal vaultMoney);
    
    public Items getItem(String itemID);
    
    List<Items> getAllItems();
    
    public void validateItemInventory(Items item) throws NoItemInventoryException;
    
    public void validInsufficientFunds(Items item, BigDecimal userMoney) throws InsufficientFundsException;
    
    public void validateId(Items item) throws NoItemInventoryException;
   
    BigDecimal addQuarters(BigDecimal userMoney);
    
    BigDecimal addDimes(BigDecimal userMoney);
    
    BigDecimal addNickels(BigDecimal userMoney);
    
    BigDecimal addDollars(BigDecimal userMoney);
    
    public Items reduceInventory(String itemID);
  
    

}
