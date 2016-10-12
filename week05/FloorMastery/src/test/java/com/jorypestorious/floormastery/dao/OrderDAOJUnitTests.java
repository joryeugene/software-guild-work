
package com.jorypestorious.floormastery.dao;

import com.jorypestorious.floormastery.dto.Order;
import com.jorypestorious.floormastery.dto.Product;
import com.jorypestorious.floormastery.dto.TaxRate;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderDAOJUnitTests {

    OrderDAO instance;

    @Before
    public void setUp() {
        instance = new OrderDAOTest();
    }

    @After
    public void tearDown() {
        instance = null;
    }
    
//currentOrderList.add(new Order("Customer1", getTaxRate("OH"), getProduct("Carpet"), 100));
//currentOrderList.add(new Order("Customer2", getTaxRate("PA"), getProduct("Laminate"), 200));
//currentOrderList.add(new Order("Customer3", getTaxRate("MI"), getProduct("Tile"), 300));
//currentOrderList.add(new Order("Customer4", getTaxRate("IN"), getProduct("Wood"), 400));

    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        String productName = "Carpet";
        Product result = instance.getProduct(productName);
        assertNotEquals(null, result);
    }

    @Test
    public void testGetProductTypes() {
        System.out.println("getProductTypes");
        int result = instance.getProductTypes().size();
        assertTrue(result > 0);
    }

    @Test
    public void testGetTaxRate() {
        System.out.println("getTaxRate");
        String stateCode = "";
        TaxRate expResult = null;
        TaxRate result = instance.getTaxRate(stateCode);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetStateCodes() {
        System.out.println("getStateCodes");
        List<String> expResult = null;
        List<String> result = instance.getStateCodes();
        assertEquals(expResult, result);
    }

//    @Test
//    public void testGetOrders() {
//        System.out.println("getOrders");
//        LocalDate date = null;
//        List<Order> expResult = null;
//        List<Order> result = instance.getOrders(date);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testGetOrder() {
//        System.out.println("getOrder");
//        LocalDate date = null;
//        int orderNumber = 0;
//        Order expResult = null;
//        Order result = instance.getOrder(date, orderNumber);
//        assertEquals(expResult, result);
//    }
//
//    @Test
//    public void testAddOrder() {
//        System.out.println("addOrder");
//        LocalDate date = null;
//        Order newOrder = null;
//        instance.addOrder(date, newOrder);
//    }
//
//    @Test
//    public void testEditOrder() {
//        System.out.println("editOrder");
//        Order oldOrder = null;
//        Order updatedOrder = null;
//        instance.editOrder(oldOrder, updatedOrder);
//    }
//
//    @Test
//    public void testRemoveOrder() {
//        System.out.println("removeOrder");
//        LocalDate date = null;
//        int orderNumber = 0;
//        boolean expResult = false;
//        boolean result = instance.removeOrder(date, orderNumber);
//        assertEquals(expResult, result);
//    }

}