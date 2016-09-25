
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class SleepingInTest {

//canSleepIn(false, false) -> true
//canSleepIn(true, false) -> false
//canSleepIn(false, true) -> true

    @Test
    public void testCanSleepIn() {
        System.out.println("canSleepIn");
        boolean isWeekday = false;
        boolean isVacation = false;
        SleepingIn instance = new SleepingIn();
        boolean expResult = true;
        boolean result = instance.canSleepIn(isWeekday, isVacation);
        assertEquals(expResult, result);
        
        isWeekday = true;
        isVacation = false;
        expResult = false;
        result = instance.canSleepIn(isWeekday, isVacation);
        assertEquals(expResult, result);
        
        isWeekday = false;
        isVacation = true;
        expResult = true;
        result = instance.canSleepIn(isWeekday, isVacation);
        assertEquals(expResult, result);
    }

}