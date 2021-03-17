/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.controller;

import com.sg.vendingmachinespringmvc.dao.VendingMachineSpringDao;
import com.sg.vendingmachinespringmvc.model.Change;
import com.sg.vendingmachinespringmvc.model.Items;
import com.sg.vendingmachinespringmvc.service.InsufficientFundsException;
import com.sg.vendingmachinespringmvc.service.NoItemInventoryException;
import com.sg.vendingmachinespringmvc.service.VendingMachineSpringService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Dreamville
 */
@Controller
public class VendingMachineController {
    
    VendingMachineSpringService service;
   
    
    @Inject
    public VendingMachineController(VendingMachineSpringService service) {
        this.service = service;
    }
    
   private BigDecimal vaultMoney = new BigDecimal("0.00");
    
   
   String showChange;
   String userMessages = "";
   String itemID;
   
    
    
   
   @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayItems(Model model) {
        List<Items> item = service.getAllItems();
        model.addAttribute("vendingItems", item);
        model.addAttribute("showMoney", vaultMoney);
        model.addAttribute("displayMessage", userMessages);
        model.addAttribute("displayItemId", itemID);
        model.addAttribute("displayChange", showChange);
       
        
        return "vendingMachine";
    }
    
    @RequestMapping(value = "/selectItem", method = RequestMethod.GET)
    public String itemSelection(HttpServletRequest request) {
        itemID = request.getParameter("chosenItem");
        return "redirect:/";
    }
    
    @RequestMapping(value = "/addDollar", method = RequestMethod.GET)
    public String addDollar() {
       vaultMoney = service.addDollars(vaultMoney);
       
        return "redirect:/";
    }
    
    @RequestMapping(value = "/addQuarter", method = RequestMethod.GET)
    public String addQuarter() {
       vaultMoney = service.addQuarters(vaultMoney);
       
        return "redirect:/";
        
    }
    
    @RequestMapping(value = "/addDime", method = RequestMethod.GET)
    public String addDime() {
       vaultMoney = service.addDimes(vaultMoney);
       
        return "redirect:/";
    }
    
    @RequestMapping(value = "/addNickel", method = RequestMethod.GET)
    public String addNickel() {
       vaultMoney = service.addNickels(vaultMoney);
       
        return "redirect:/";
    }
    
    @RequestMapping(value = "/purchaseItem", method = RequestMethod.GET)
    public String purchaseItem() {
        
        
       
        
        try {
        Items item = service.getItem(itemID);
        service.validateId(item);
        service.validateItemInventory(item);
        service.validInsufficientFunds(item, vaultMoney);
        BigDecimal boughtItem = service.purchaseItem(item, vaultMoney);
        Change change = new Change(boughtItem);
        showChange = change.toString();
        vaultMoney = new BigDecimal("0.00");
        service.reduceInventory(itemID);
        userMessages = "Thank you for shopping with us today";
        
        } catch (NoItemInventoryException | InsufficientFundsException e) {
            userMessages = e.getMessage();
        }
        
        return "redirect:/";
    }
    
    @RequestMapping(value = "/returnChange", method = RequestMethod.GET)
     public String returnChange() {
        Change changeBack = new Change(vaultMoney);
        showChange = changeBack.toString();
        vaultMoney = new BigDecimal("0.00");
        userMessages = "";
        return "redirect:/";
    }
}
