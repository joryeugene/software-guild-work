
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringTimesTest {
//stringTimes("Hi", 2) -> "HiHi"
//stringTimes("Hi", 3) -> "HiHiHi"
//stringTimes("Hi", 1) -> "Hi"

    @Test
    public void testStringTimes() {
        System.out.println("stringTimes");
        String str = "Hi";
        int n = 2;
        StringTimes instance = new StringTimes();
        String expResult = "HiHi";
        String result = instance.stringTimes(str, n);
        assertEquals(expResult, result);
        
        n = 3;
        expResult = "HiHiHi";
        result = instance.stringTimes(str, n);
        assertEquals(expResult, result);
        
        n = 1;
        expResult = "Hi";
        result = instance.stringTimes(str, n);
        assertEquals(expResult, result);
    }

}