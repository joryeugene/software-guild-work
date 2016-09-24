
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class Mod20Test {

//mod20(20) → false
//mod20(21) → true
//mod20(22) → true

    @Test
    public void testMod20() {
        System.out.println("mod20");
        int n = 20;
        Mod20 instance = new Mod20();
        boolean expResult = false;
        boolean result = instance.mod20(n);
        assertEquals(expResult, result);
        
        n = 21;
        expResult = true;
        result = instance.mod20(n);
        assertEquals(expResult, result);
        
        n = 22;
        expResult = true;
        result = instance.mod20(n);
        assertEquals(expResult, result);
    }

}