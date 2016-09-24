
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoveSixTest {

//loveSix(6, 4) → true
//loveSix(4, 5) → false
//loveSix(1, 5) → true

    @Test
    public void testLoveSix() {
        System.out.println("loveSix");
        int a = 6;
        int b = 4;
        LoveSix instance = new LoveSix();
        boolean expResult = true;
        boolean result = instance.loveSix(a, b);
        assertEquals(expResult, result);
        
        a = 4;
        b = 5;
        expResult = false;
        result = instance.loveSix(a, b);
        assertEquals(expResult, result);
        
        a = 1;
        b = 5;
        expResult = true;
        result = instance.loveSix(a, b);
        assertEquals(expResult, result);
        
        a = 5;
        b = 11;
        expResult = true;
        result = instance.loveSix(a, b);
        assertEquals(expResult, result);
    }

}