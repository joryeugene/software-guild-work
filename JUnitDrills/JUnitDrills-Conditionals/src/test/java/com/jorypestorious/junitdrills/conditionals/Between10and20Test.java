
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class Between10and20Test {

//between10and20(12, 99) -> true
//between10and20(21, 12) -> true
//between10and20(8, 99) -> false

    @Test
    public void testBetween10and20() {
        System.out.println("between10and20");
        int a = 12;
        int b = 99;
        Between10and20 instance = new Between10and20();
        boolean expResult = true;
        boolean result = instance.between10and20(a, b);
        assertEquals(expResult, result);
        
        a = 21;
        b = 12;
        expResult = true;
        result = instance.between10and20(a, b);
        assertEquals(expResult, result);
        
        a = 8;
        b = 99;
        expResult = false;
        result = instance.between10and20(a, b);
        assertEquals(expResult, result);
    }

}