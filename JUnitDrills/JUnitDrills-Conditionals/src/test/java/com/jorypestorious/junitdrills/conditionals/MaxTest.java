
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class MaxTest {

//max(1, 2, 3) -> 3
//max(1, 3, 2) -> 3
//max(3, 2, 1) -> 3

    @Test
    public void testMax() {
        System.out.println("max");
        int a = 1;
        int b = 2;
        int c = 3;
        Max instance = new Max();
        int expResult = 3;
        int result = instance.max(a, b, c);
        assertEquals(expResult, result);
        
        a = 1;
        b = 3;
        c = 2;
        expResult = 3;
        result = instance.max(a, b, c);
        assertEquals(expResult, result);
        
        a = 3;
        b = 2;
        c = 1;
        expResult = 3;
        result = instance.max(a, b, c);
        assertEquals(expResult, result);
    }

}