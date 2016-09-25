
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleXTest {

//doubleX("axxbb") -> true
//doubleX("axaxxax") -> false
//doubleX("xxxxx") -> true

    @Test
    public void testDoubleX() {
        System.out.println("doubleX");
        String str = "axxbb";
        DoubleX instance = new DoubleX();
        boolean expResult = true;
        boolean result = instance.doubleX(str);
        assertEquals(expResult, result);
        
        str = "xxxxx";
        expResult = true;
        result = instance.doubleX(str);
        assertEquals(expResult, result);
        
        str = "x";
        expResult = false;
        result = instance.doubleX(str);
        assertEquals(expResult, result);
        
        str = "a";
        expResult = false;
        result = instance.doubleX(str);
        assertEquals(expResult, result);
        
        str = "axaxxax";
        expResult = false;
        result = instance.doubleX(str);
        assertEquals(expResult, result);
    }

}