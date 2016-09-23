
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class GreatPartyTest {

    //    greatParty(30, false) → false
//            greatParty(50, false) → true
//            greatParty(70, true) → true

    @Test
    public void testGreatParty() {
        System.out.println("greatParty");
        GreatParty instance = new GreatParty();
        
        int cigars = 30;
        boolean isWeekend = false;
        boolean expResult = false;
        boolean result = instance.greatParty(cigars, isWeekend);
        assertEquals(expResult, result);
        
        cigars = 50;
        isWeekend = false;
        expResult = true;
        result = instance.greatParty(cigars, isWeekend);
        assertEquals(expResult, result);
        
        cigars = 70;
        isWeekend = true;
        expResult = true;
        result = instance.greatParty(cigars, isWeekend);
        assertEquals(expResult, result);
    }
}