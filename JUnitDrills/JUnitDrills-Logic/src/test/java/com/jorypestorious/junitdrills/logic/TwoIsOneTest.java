
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class TwoIsOneTest {

//twoIsOne(1, 2, 3) → true
//twoIsOne(3, 1, 2) → true
//twoIsOne(3, 2, 2) → false

    @Test
    public void testTwoIsOne() {
        System.out.println("twoIsOne");
        int a = 1;
        int b = 2;
        int c = 3;
        TwoIsOne instance = new TwoIsOne();
        boolean expResult = true;
        boolean result = instance.twoIsOne(a, b, c);
        assertEquals(expResult, result);
        
        a = 3;
        b = 1;
        c = 2;
        expResult = true;
        result = instance.twoIsOne(a, b, c);
        assertEquals(expResult, result);
        
        a = 3;
        b = 2;
        c = 2;
        expResult = false;
        result = instance.twoIsOne(a, b, c);
        assertEquals(expResult, result);
    }

}