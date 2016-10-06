
package com.jorypestorious.productinventory.dao;

import com.jorypestorious.productinventory.dto.Product;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InventoryManagementTest {

    public InventoryManagementTest() {
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

    @Test
    public void testGetInventory() {
        System.out.println("getInventory");
        InventoryManagement instance = null;
        Map expResult = null;
        Map result = instance.getInventory();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        int id = 0;
        InventoryManagement instance = null;
        Product expResult = null;
        Product result = instance.getProduct(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Product product = null;
        InventoryManagement instance = null;
        instance.addProduct(product);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        int id = 0;
        Product product = null;
        InventoryManagement instance = null;
        instance.updateProduct(id, product);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSave() {
        System.out.println("save");
        InventoryManagement instance = null;
        instance.save();
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProductsByCategory() {
        System.out.println("getProductsByCategory");
        String category = "";
        InventoryManagement instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.getProductsByCategory(category);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        InventoryManagement instance = null;
        List<String> expResult = null;
        List<String> result = instance.getCategories();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProductsByBrand() {
        System.out.println("getProductsByBrand");
        String brand = "";
        InventoryManagement instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.getProductsByBrand(brand);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetBrands() {
        System.out.println("getBrands");
        InventoryManagement instance = null;
        List<String> expResult = null;
        List<String> result = instance.getBrands();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetProductsToRestock() {
        System.out.println("getProductsToRestock");
        int quantity = 0;
        InventoryManagement instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.getProductsToRestock(quantity);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}