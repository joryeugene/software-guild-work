
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class CaughtSpeedingTest {

//caughtSpeeding(60, false) → 0
//caughtSpeeding(65, false) → 1
//caughtSpeeding(65, true) → 0

    @Test
    public void testCaughtSpeeding() {
        System.out.println("caughtSpeeding");
        int speed = 60;
        boolean isBirthday = false;
        CaughtSpeeding instance = new CaughtSpeeding();
        int expResult = 0;
        int result = instance.caughtSpeeding(speed, isBirthday);
        assertEquals(expResult, result);
        
        speed = 65;
        isBirthday = false;
        expResult = 1;
        result = instance.caughtSpeeding(speed, isBirthday);
        assertEquals(expResult, result);
        
        speed = 65;
        isBirthday = true;
        expResult = 0;
        result = instance.caughtSpeeding(speed, isBirthday);
        assertEquals(expResult, result);
    }

}