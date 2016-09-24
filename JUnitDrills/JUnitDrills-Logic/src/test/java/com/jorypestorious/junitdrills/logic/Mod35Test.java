
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class Mod35Test {

//
//mod35(3) → true
//mod35(10) → true
//mod35(15) → false

    @Test
    public void testMod35() {
        System.out.println("mod35");
        int n = 3;
        Mod35 instance = new Mod35();
        boolean expResult = true;
        boolean result = instance.mod35(n);
        assertEquals(expResult, result);
        
        n = 10;
        expResult = true;
        result = instance.mod35(n);
        assertEquals(expResult, result);
        
        n = 15;
        expResult = false;
        result = instance.mod35(n);
        assertEquals(expResult, result);
        
        n = 13;
        expResult = false;
        result = instance.mod35(n);
        assertEquals(expResult, result);
    }

}