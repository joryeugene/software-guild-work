
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class InRangeTest {

//
//inRange(5, false) → true
//inRange(11, false) → false
//inRange(11, true) → true

    @Test
    public void testInRange() {
        System.out.println("inRange");
        int n = 5;
        boolean outsideMode = false;
        InRange instance = new InRange();
        boolean expResult = true;
        boolean result = instance.inRange(n, outsideMode);
        assertEquals(expResult, result);
        
        n = 11;
        outsideMode = false;
        expResult = false;
        result = instance.inRange(n, outsideMode);
        assertEquals(expResult, result);
        
        n = 11;
        outsideMode = true;
        expResult = true;
        result = instance.inRange(n, outsideMode);
        assertEquals(expResult, result);
    }

}