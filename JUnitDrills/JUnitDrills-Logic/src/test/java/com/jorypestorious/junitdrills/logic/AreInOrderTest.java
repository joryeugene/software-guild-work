
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class AreInOrderTest {

//
//areInOrder(1, 2, 4, false) → true
//areInOrder(1, 2, 1, false) → false
//areInOrder(1, 1, 2, true) → true

    @Test
    public void testAreInOrder() {
        System.out.println("areInOrder");
        int a = 1;
        int b = 2;
        int c = 4;
        boolean bOk = false;
        AreInOrder instance = new AreInOrder();
        boolean expResult = true;
        boolean result = instance.areInOrder(a, b, c, bOk);
        assertEquals(expResult, result);
        
        a = 1;
        b = 2;
        c = 1;
        bOk = false;
        expResult = false;
        result = instance.areInOrder(a, b, c, bOk);
        assertEquals(expResult, result);
        
        a = 1;
        b = 1;
        c = 2;
        bOk = true;
        expResult = true;
        result = instance.areInOrder(a, b, c, bOk);
        assertEquals(expResult, result);
    }

}