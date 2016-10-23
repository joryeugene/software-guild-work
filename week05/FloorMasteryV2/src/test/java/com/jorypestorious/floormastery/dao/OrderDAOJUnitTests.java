
package com.jorypestorious.floormastery.dao;

import com.jorypestorious.floormastery.dto.Order;
import com.jorypestorious.floormastery.dto.Product;
import com.jorypestorious.floormastery.dto.TaxRate;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderDAOJUnitTests {

    OrderDAO instance;

    @Before
    public void setUp() {
        instance = new OrderDAOTest("Data/ProductTypes.txt", "Data/TaxRates.txt", "Data/OrderListFileNames.txt");
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
        String stateCode = "OH";
        TaxRate result = instance.getTaxRate(stateCode);
        assertNotEquals(null, result);
    }

    @Test
    public void testGetStateCodes() {
        System.out.println("getStateCodes");
        int result = instance.getStateCodes().size();
        assertTrue(result > 0);
    }

    @Test
    public void testGetOrders() {
        System.out.println("getOrders");
        LocalDate date = LocalDate.now();
        int expResult = 4;
        int result = instance.getOrders(date).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetOrder() {
        System.out.println("getOrder");
        LocalDate date = LocalDate.now();
        int orderNumber = 1;
        Order result = instance.getOrder(date, orderNumber);
        assertNotEquals(null, result);
    }
    
    @Test
    public void testGetHighestOrderNumber() {
        System.out.println("getHighestOrderNumber");
        int expResult = 4;
        int result = instance.getHighestOrderNumber();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddOrder() {
        System.out.println("addOrder");
        LocalDate date = LocalDate.now();
        Order newOrder = new Order(5, "Customer5", instance.getTaxRate("PA"), instance.getProduct("Carpet"), 400);
        instance.addOrder(date, newOrder);
        assertEquals(5, instance.getOrders(date).size());
    }

    @Test
    public void testEditOrder() {
        System.out.println("editOrder");
        LocalDate date = LocalDate.now();
        int orderNumber = 4;
        Order oldOrder = instance.getOrder(date, orderNumber);
        Order updatedOrder = new Order(4, "Customer5", instance.getTaxRate("PA"), instance.getProduct("Carpet"), 400);
        instance.editOrder(oldOrder, updatedOrder);
        String expResult = "Customer5";
        String result = instance.getOrder(date, orderNumber).getCustomer();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveOrder() {
        instance.getOrders(LocalDate.MAX).stream().forEach(o -> System.out.print(o));
        System.out.println("removeOrder");
        LocalDate date = LocalDate.now();
        int orderNumber = 1;
        boolean result = instance.removeOrder(date, orderNumber);
        assertTrue(result);
        assertEquals(3, instance.getOrders(date).size());
    }
    
    @Test
    public void testGetOrdersMatchingStateCode() {
        System.out.println("getOrdersMatchingStateCode");
        int expResult = 1;
        int result = instance.getOrdersMatchingStateCode("OH").size();
        assertEquals(expResult, result);
    }

}