
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class AlarmClockTest {

//alarmClock(1, false) → "7:00"
//alarmClock(5, false) → "7:00"
//alarmClock(0, false) → "10:00"

    @Test
    public void testAlarmClock() {
        System.out.println("alarmClock");
        int day = 1;
        boolean vacation = false;
        AlarmClock instance = new AlarmClock();
        String expResult = "7:00";
        String result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result);
        
        day = 5;
        vacation = false;
        expResult = "7:00";
        result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result);
        
        day = 0;
        vacation = false;
        expResult = "10:00";
        result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result);
        
        day = 6;
        vacation = true;
        expResult = "off";
        result = instance.alarmClock(day, vacation);
        assertEquals(expResult, result);
    }

}