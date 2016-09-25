
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class NearHundredTest {

//nearHundred(103) -> true
//nearHundred(90) -> true
//nearHundred(89) -> false

    @Test
    public void testNearHundred() {
        System.out.println("nearHundred");
        int n = 103;
        NearHundred instance = new NearHundred();
        boolean expResult = true;
        boolean result = instance.nearHundred(n);
        assertEquals(expResult, result);
        
        n = 90;
        expResult = true;
        result = instance.nearHundred(n);
        assertEquals(expResult, result);
        
        n = 89;
        expResult = false;
        result = instance.nearHundred(n);
        assertEquals(expResult, result);
    }

}