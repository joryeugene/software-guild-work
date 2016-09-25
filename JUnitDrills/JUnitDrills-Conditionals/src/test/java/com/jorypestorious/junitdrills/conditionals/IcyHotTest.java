
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class IcyHotTest {

//icyHot(120, -1) -> true
//icyHot(-1, 120) -> true
//icyHot(2, 120) -> false

    @Test
    public void testIcyHot() {
        System.out.println("icyHot");
        int temp1 = 120;
        int temp2 = -1;
        IcyHot instance = new IcyHot();
        boolean expResult = true;
        boolean result = instance.icyHot(temp1, temp2);
        assertEquals(expResult, result);
        
        temp1 = -1;
        temp2 = 120;
        expResult = true;
        result = instance.icyHot(temp1, temp2);
        assertEquals(expResult, result);
        
        temp1 = 2;
        temp2 = 120;
        expResult = false;
        result = instance.icyHot(temp1, temp2);
        assertEquals(expResult, result);
    }

}