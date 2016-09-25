
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class HasTeenTest {

//hasTeen(13, 20, 10) -> true
//hasTeen(20, 19, 10) -> true
//hasTeen(20, 10, 12) -> false

    @Test
    public void testHasTeen() {
        System.out.println("hasTeen");
        int a = 13;
        int b = 20;
        int c = 10;
        HasTeen instance = new HasTeen();
        boolean expResult = true;
        boolean result = instance.hasTeen(a, b, c);
        assertEquals(expResult, result);
        
        a = 20;
        b = 19;
        c = 10;
        expResult = true;
        result = instance.hasTeen(a, b, c);
        assertEquals(expResult, result);
        
        a = 20;
        b = 10;
        c = 12;
        expResult = false;
        result = instance.hasTeen(a, b, c);
        assertEquals(expResult, result);
    }

}