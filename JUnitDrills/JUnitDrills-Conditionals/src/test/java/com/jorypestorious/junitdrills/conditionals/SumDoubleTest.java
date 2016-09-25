
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class SumDoubleTest {

//sumDouble(1, 2) -> 3
//sumDouble(3, 2) -> 5
//sumDouble(2, 2) -> 8

    @Test
    public void testSumDouble() {
        System.out.println("sumDouble");
        int a = 1;
        int b = 2;
        SumDouble instance = new SumDouble();
        int expResult = 3;
        int result = instance.sumDouble(a, b);
        assertEquals(expResult, result);
        
        a = 3;
        b = 2;
        expResult = 5;
        result = instance.sumDouble(a, b);
        assertEquals(expResult, result);
        
        a = 2;
        b = 2;
        expResult = 8;
        result = instance.sumDouble(a, b);
        assertEquals(expResult, result);
    }

}