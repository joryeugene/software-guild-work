
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class Makes10Test {

//makes10(9, 10) -> true
//makes10(9, 9) -> false
//makes10(1, 9) -> true

    @Test
    public void testMakes10() {
        System.out.println("makes10");
        int a = 9;
        int b = 10;
        Makes10 instance = new Makes10();
        boolean expResult = true;
        boolean result = instance.makes10(a, b);
        assertEquals(expResult, result);
        
        a = 9;
        b = 9;
        expResult = false;
        result = instance.makes10(a, b);
        assertEquals(expResult, result);
        
        a = 1;
        b = 9;
        expResult = true;
        result = instance.makes10(a, b);
        assertEquals(expResult, result);
    }

}