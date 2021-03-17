/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachinespringmvc.dao;

import com.sg.vendingmachinespringmvc.model.Items;
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
public class VendingMachineSpringDaoInMemImplTest {
    
    private static VendingMachineSpringDao dao;
    
    public VendingMachineSpringDaoInMemImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        VendingMachineSpringDao dao = new VendingMachineSpringDaoInMemImpl();
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
     * Test of getItem method, of class VendingMachineSpringDaoInMemImpl.
     */
    @Test
    public void testGetItem() {
        
        Items getItem = dao.getItem("1");
        assertNotNull(getItem);
    }

    /**
     * Test of getAllItems method, of class VendingMachineSpringDaoInMemImpl.
     */
    @Test
    public void testGetAllItems() {
        
        assertEquals(9, dao.getAllItems().size());
    }

    /**
     * Test of ReduceInventory method, of class VendingMachineSpringDaoInMemImpl.
     */
    @Test
    public void testReduceInventory() {
        
        assertEquals(3, dao.getItem("2").getItemQuantity());
    }
    
}
