
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class IxStartTest {

//ixStart("mix snacks") -> true
//ixStart("pix snacks") -> true
//ixStart("piz snacks") -> false

    @Test
    public void testIxStart() {
        System.out.println("ixStart");
        String str = "mix snacks";
        IxStart instance = new IxStart();
        boolean expResult = true;
        boolean result = instance.ixStart(str);
        assertEquals(expResult, result);
        
        str = "pix snacks";
        expResult = true;
        result = instance.ixStart(str);
        assertEquals(expResult, result);
        
        str = "piz snacks";
        expResult = false;
        result = instance.ixStart(str);
        assertEquals(expResult, result);
    }

}