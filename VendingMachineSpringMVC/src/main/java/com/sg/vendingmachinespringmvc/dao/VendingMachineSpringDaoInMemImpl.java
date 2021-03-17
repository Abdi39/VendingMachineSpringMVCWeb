/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Items;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dreamville
 */
public class VendingMachineSpringDaoInMemImpl implements VendingMachineSpringDao{
    
    private Map<String, Items> items = new HashMap();
    
    public VendingMachineSpringDaoInMemImpl() {
        
        Items item = new Items("1");
        item.setItemName("Snickers");
        item.setItemPrice(new BigDecimal("1.85"));
        item.setItemQuantity(9);
        
        Items item2 = new Items("2");
        item2.setItemName("M&Ms");
        item2.setItemPrice(new BigDecimal("1.50"));
        item2.setItemQuantity(8);
        
        Items item3 = new Items("3");
        item3.setItemName("Pringles");
        item3.setItemPrice(new BigDecimal("2.10"));
        item3.setItemQuantity(6);
        
        Items item4 = new Items("4");
        item4.setItemName("Reeses");
        item4.setItemPrice(new BigDecimal("1.85"));
        item4.setItemQuantity(5);
        
        Items item5 = new Items("5");
        item5.setItemName("Pretzels");
        item5.setItemPrice(new BigDecimal("1.25"));
        item5.setItemQuantity(4);
        
        Items item6 = new Items("6");
        item6.setItemName("Twinkies");
        item6.setItemPrice(new BigDecimal("1.95"));
        item6.setItemQuantity(7);
        
         Items item7 = new Items("7");
        item7.setItemName("Doritos");
        item7.setItemPrice(new BigDecimal("1.75"));
        item7.setItemQuantity(10);
        
        Items item8 = new Items("8");
        item8.setItemName("Pretzels");
        item8.setItemPrice(new BigDecimal("1.85"));
        item8.setItemQuantity(2);
        
        Items item9 = new Items("9");
        item9.setItemName("Trident");
        item9.setItemPrice(new BigDecimal("1.95"));
        item9.setItemQuantity(6);
        
        items.put("1", item);
        items.put("2", item2);
        items.put("3", item3);
        items.put("4", item4);
        items.put("5", item5);
        items.put("6", item6);
        items.put("7", item7);
        items.put("8", item8);
        items.put("9", item9);
    }

   

    @Override
    public Items getItem(String itemID) {
        return items.get(itemID);
    }

    @Override
    public List<Items> getAllItems() {
        Collection<Items> listVendingItems= items.values();
         return new ArrayList(listVendingItems);
    }

   @Override
   public Items ReduceInventory(String itemID) {
       Items boughtItem = items.get(itemID);
       int beforePurchse = boughtItem.getItemQuantity();
       
       boughtItem.setItemQuantity(beforePurchse - 1);
       
       return boughtItem;
   
   
   }
   
    
}
