package com.jorypestorious.simplecalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {
    
    @Test 
    public void testMultipy() {
        Calculator c = new Calculator();
        
        double expected,
               result;
        
        expected = -20.0;
        result = c.multiply(5.0, -4.0);
        
        assertEquals(expected, result, 0.00001);
        
        expected = 45.0;
        result = c.multiply(15.0, 3.0);
        
        assertEquals(expected, result, 0.00001);
    }
    
    @Test 
    public void testDivide() {
        Calculator c = new Calculator();
        
        double expected,
               result;
        
        expected = 5.0;
        result = c.divide(15.0, 3.0);
        
        assertEquals(expected, result, 0.00001);
        
        expected = 25.0;
        result = c.divide(100.0, 4.0);
        
        assertEquals(expected, result, 0.00001);
    }
    
    @Test 
    public void testAdd() {
        Calculator c = new Calculator();
        
        double expected,
               result;
        
        expected = 18.0;
        result = c.add(15.0, 3.0);
        
        assertEquals(expected, result, 0.00001);
        
        expected = 5.0;
        result = c.add(2.5, 2.5);
        
        assertEquals(expected, result, 0.00001);
    }
    
    @Test 
    public void testSubtract() {
        Calculator c = new Calculator();
        
        double expected,
               result;
        
        expected = 12.0;
        result = c.subtract(15.0, 3.0);
        
        assertEquals(expected, result, 0.00001);
        
        expected = 3.0;
        result = c.subtract(5.5, 2.5);
        
        assertEquals(expected, result, 0.00001);
    }

}
