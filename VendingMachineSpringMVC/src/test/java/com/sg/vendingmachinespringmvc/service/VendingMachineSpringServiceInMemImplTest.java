/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.service;

import com.sg.vendingmachinespringmvc.dao.VendingMachineSpringDao;
import com.sg.vendingmachinespringmvc.dao.VendingMachineSpringDaoInMemImpl;
import com.sg.vendingmachinespringmvc.model.Items;
import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dreamville
 */
public class VendingMachineSpringServiceInMemImplTest {
    
    VendingMachineSpringService service;
    
    public VendingMachineSpringServiceInMemImplTest() {
        VendingMachineSpringDao dao = new VendingMachineSpringDaoInMemImpl();
        service = new VendingMachineSpringServiceInMemImpl(dao);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of purchaseItem method, of class VendingMachineSpringServiceInMemImpl.
     */
    @Test
    public void testPurchaseItem() {
        
        Items item = new Items("2");
        item.setItemPrice(BigDecimal.ONE);
        
       try{
            service.validInsufficientFunds(item, BigDecimal.TEN);
        }catch(InsufficientFundsException e) {
            fail("The code has failed");
        }
    }

    /**
     * Test of getItem method, of class VendingMachineSpringServiceInMemImpl.
     */
    @Test
    public void testGetItem() {
    }

    /**
     * Test of getAllItems method, of class VendingMachineSpringServiceInMemImpl.
     */
    @Test
    public void testGetAllItems() {
    }

    @Test
    public void testValidateItemInventory() throws Exception {
        Items inventory = service.getItem("1");
        
        try{
            service.validateItemInventory(inventory);
        }catch(NoItemInventoryException e) {
            fail("The code has failed");
        }
    }

    /**
     * Test of validInsufficientFunds method, of class VendingMachineSpringServiceInMemImpl.
     */
    @Test
    public void testValidInsufficientFunds() throws Exception {
        
        Items item = new Items ("2");
        item.setItemPrice(BigDecimal.ONE);
        
        try{
            service.validInsufficientFunds(item, BigDecimal.TEN);
        }catch(InsufficientFundsException e) {
            fail("The code has failed");
        }
    }

 
    
}
