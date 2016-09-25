
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class PosNegTest {

//posNeg(1, -1, false) -> true
//posNeg(-1, 1, false) -> true
//posNeg(-4, -5, true) -> true

    @Test
    public void testPosNeg() {
        System.out.println("posNeg");
        int a = 1;
        int b = -1;
        boolean negative = false;
        PosNeg instance = new PosNeg();
        boolean expResult = true;
        boolean result = instance.posNeg(a, b, negative);
        assertEquals(expResult, result);
        
        a = -1;
        b = 1;
        negative = false;
        expResult = true;
        result = instance.posNeg(a, b, negative);
        assertEquals(expResult, result);
        
        a = -4;
        b = -5;
        negative = true;
        expResult = true;
        result = instance.posNeg(a, b, negative);
        assertEquals(expResult, result);
    }

}