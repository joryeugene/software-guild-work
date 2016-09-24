
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class InOrderEqualTest {

//inOrderEqual(2, 5, 11, false) → true
//inOrderEqual(5, 7, 6, false) → false
//inOrderEqual(5, 5, 7, true) → true

    @Test
    public void testInOrderEqual() {
        System.out.println("inOrderEqual");
        int a = 2;
        int b = 5;
        int c = 11;
        boolean equalOk = false;
        InOrderEqual instance = new InOrderEqual();
        boolean expResult = true;
        boolean result = instance.inOrderEqual(a, b, c, equalOk);
        assertEquals(expResult, result);
        
        a = 5;
        b = 7;
        c = 6;
        equalOk = false;
        expResult = false;
        result = instance.inOrderEqual(a, b, c, equalOk);
        assertEquals(expResult, result);
        a = 5;
        b = 5;
        c = 7;
        equalOk = true;
        expResult = true;
        result = instance.inOrderEqual(a, b, c, equalOk);
        assertEquals(expResult, result);
    }

}