
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class Diff21Test {

//diff21(23) -> 4
//diff21(10) -> 11
//diff21(21) -> 0

    @Test
    public void testDiff21() {
        System.out.println("diff21");
        int n = 23;
        Diff21 instance = new Diff21();
        int expResult = 4;
        int result = instance.diff21(n);
        assertEquals(expResult, result);
        
        n = 10;
        expResult = 11;
        result = instance.diff21(n);
        assertEquals(expResult, result);
        
        n = 21;
        expResult = 0;
        result = instance.diff21(n);
        assertEquals(expResult, result);
    }

}