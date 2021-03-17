/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Items;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Dreamville
 */
public interface VendingMachineSpringDao {
   
    
    public Items getItem(String itemID);
    List<Items> getAllItems();
    public Items ReduceInventory(String itemID);
}
