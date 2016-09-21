package com.jorypestorious.simplecalculator;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class CalculatorTest {
    
    private Calculator c;
    private double expected,
                   result;

    @Before
    public void setUp() {
        c = new Calculator();
    }

    @After
    public void tearDown() {
        c = null;
    }
    
    @Test 
    public void testMultipy() {  
        expected = -20.0;
        result = c.multiply(5.0, -4.0);
        
        assertEquals(expected, result, 0.00001);
        
        expected = 45.0;
        result = c.multiply(15.0, 3.0);
        
        assertEquals(expected, result, 0.00001);
    }
    
    @Test 
    public void testDivide() {
        expected = 5.0;
        result = c.divide(15.0, 3.0);
        
        assertEquals(expected, result, 0.00001);
        
        expected = 25.0;
        result = c.divide(100.0, 4.0);
        
        assertEquals(expected, result, 0.00001);
    }
    
    @Test 
    public void testAdd() {
        expected = 18.0;
        result = c.add(15.0, 3.0);
        
        assertEquals(expected, result, 0.00001);
        
        expected = 5.0;
        result = c.add(2.5, 2.5);
        
        assertEquals(expected, result, 0.00001);
    }
    
    @Test 
    public void testSubtract() {
        expected = 12.0;
        result = c.subtract(15.0, 3.0);
        
        assertEquals(expected, result, 0.00001);
        
        expected = 3.0;
        result = c.subtract(5.5, 2.5);
        
        assertEquals(expected, result, 0.00001);
    }

}
