
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class SkipSumTest {

//skipSum(3, 4) → 7
//skipSum(9, 4) → 20
//skipSum(10, 11) → 21

    @Test
    public void testSkipSum() {
        System.out.println("skipSum");
        int a = 3;
        int b = 4;
        SkipSum instance = new SkipSum();
        int expResult = 7;
        int result = instance.skipSum(a, b);
        assertEquals(expResult, result);
        
        a = 9;
        b = 4;
        expResult = 20;
        result = instance.skipSum(a, b);
        assertEquals(expResult, result);
        
        a = 10;
        b = 11;
        expResult = 21;
        result = instance.skipSum(a, b);
        assertEquals(expResult, result);
    }

}