
package com.jorypestorious.productinventory.dao;

import com.jorypestorious.productinventory.dto.Ball;
import com.jorypestorious.productinventory.dto.Product;
import com.jorypestorious.productinventory.dto.Racquet;
import com.jorypestorious.productinventory.dto.Shoe;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAOTest {
    
    DAO instance = new InventoryManagement("test.txt");

    @Before
    public void setUp() {
        if (instance.getInventory().size() > 0) instance.getInventory().keySet().stream().forEach( (id) -> instance.deleteProduct(id) );
        
        instance.addProduct(new Product(1, "Test Brand", "Test Name", 1.50, 5));
        instance.addProduct(new Racquet(2, "Racquet Brand", "Racquet Name", "Test Weight", "Test Color", 111.11, 10));
        instance.addProduct(new Shoe(3, "Shoe Brand", "Shoe Name", "Shoe Size", "Shoe Color", 50.0, 2));
        instance.addProduct(new Ball(4, "Ball Brand", "Ball Name", "Test Dot", 11.50, 0));
    }
    @After
    public void tearDown() {
        instance.getInventory().keySet().stream().forEach( (id) -> instance.deleteProduct(id) );
    }

    @Test
    public void testGetInventory() {
        System.out.println("getInventory");
        instance.getInventory().values().stream().forEach( (product) -> System.out.println(product) );
        
        int expResult = 4;
        int result = instance.getInventory().size();
        assertEquals(expResult, result);    
    }

    @Test
    public void testGetNumberOfProducts() {
        System.out.println("getNumberOfProducts");
        int expResult = 4;
        int result = instance.getNumberOfProducts();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetProduct() {
        System.out.println("getProduct");
        int id = 1;
        Product result = instance.getProduct(id);
        assertNotEquals(null, result);
    }

    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Product product = new Product(5, "Test Brand", "Test Name", 1.50, 5);
        instance.addProduct(product);
        int expResult = 5;
        int result = instance.getInventory().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        int id = 1;
        Product product = instance.getProduct(id);
        product.setBrand("Test");
        instance.updateProduct(id, instance.getProduct(id));
        assertEquals("Test", instance.getProduct(id).getBrand());
    }


    @Test
    public void testGetProductsByCategory() {
        System.out.println("getProductsByCategory");
        List<Product> result = instance.getProductsByCategory("Racquet");
        int expResult = 1;
        assertEquals(expResult, result.size());
    }

    @Test
    public void testGetCategories() {
        System.out.println("getCategories");
        int expResult = 4;
        int result = instance.getCategories().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetProductsByBrand() {
        System.out.println("getProductsByBrand");
        int expResult = 1;
        int result = instance.getProductsByBrand("Test Brand").size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetBrands() {
        System.out.println("getBrands");
        int expResult = 4;
        int result = instance.getBrands().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetProductsToRestock() {
        System.out.println("getProductsToRestock");
        int quantity = 6;
        int expResult = 3;
        int result = instance.getProductsToRestock(quantity).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetProductStockValuation() {
        System.out.println("getProductStockValuation");
        int id = 1;
        String expResult = "$7.50";
        String result = instance.getProductStockValuation(id);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetTotalInventoryValuation() {
        System.out.println("getTotalInventoryValuation");
        String expResult = "$1,218.60";
        String result = instance.getTotalInventoryValuation();
        assertEquals(expResult, result);
    }

    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        int id = 1;
        instance.deleteProduct(id);
        int expResult = 3;
        int result = instance.getInventory().size();
        assertEquals(expResult, result);
    }

}