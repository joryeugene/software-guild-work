
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class SoAloneTest {

//soAlone(13, 99) -> true
//soAlone(21, 19) -> true
//soAlone(13, 13) -> false

    @Test
    public void testSoAlone() {
        System.out.println("soAlone");
        int a = 13;
        int b = 99;
        SoAlone instance = new SoAlone();
        boolean expResult = true;
        boolean result = instance.soAlone(a, b);
        assertEquals(expResult, result);
        
        a = 21;
        b = 19;
        expResult = true;
        result = instance.soAlone(a, b);
        assertEquals(expResult, result);
        
        a = 13;
        b = 13;
        expResult = false;
        result = instance.soAlone(a, b);
        assertEquals(expResult, result);
    }

}