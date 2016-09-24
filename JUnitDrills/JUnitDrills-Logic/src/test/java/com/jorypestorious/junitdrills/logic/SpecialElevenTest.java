
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class SpecialElevenTest {

//specialEleven(22) → true
//specialEleven(23) → true
//specialEleven(24) → false

    @Test
    public void testSpecialEleven() {
        System.out.println("specialEleven");
        int n = 22;
        SpecialEleven instance = new SpecialEleven();
        boolean expResult = true;
        boolean result = instance.specialEleven(n);
        assertEquals(expResult, result);
        
        n = 23;
        expResult = true;
        result = instance.specialEleven(n);
        assertEquals(expResult, result);
        
        n = 24;
        expResult = false;
        result = instance.specialEleven(n);
        assertEquals(expResult, result);
    }

}