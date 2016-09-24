
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class LastDigitTest {

//lastDigit(23, 19, 13) → true
//lastDigit(23, 19, 12) → false
//lastDigit(23, 19, 3) → true

    @Test
    public void testLastDigit() {
        System.out.println("lastDigit");
        int a = 23;
        int b = 19;
        int c = 13;
        LastDigit instance = new LastDigit();
        boolean expResult = true;
        boolean result = instance.lastDigit(a, b, c);
        assertEquals(expResult, result);
        
        a = 23;
        b = 19;
        c = 12;
        expResult = false;
        result = instance.lastDigit(a, b, c);
        assertEquals(expResult, result);
        
        a = 23;
        b = 19;
        c = 3;
        expResult = true;
        result = instance.lastDigit(a, b, c);
        assertEquals(expResult, result);
    }

}