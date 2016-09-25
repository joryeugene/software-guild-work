
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class StartHiTest {

//startHi("hi there") -> true
//startHi("hi") -> true
//startHi("high up") -> false

    @Test
    public void testStartHi() {
        System.out.println("startHi");
        String str = "hi there";
        StartHi instance = new StartHi();
        boolean expResult = true;
        boolean result = instance.startHi(str);
        assertEquals(expResult, result);
        
        str = "hi";
        expResult = true;
        result = instance.startHi(str);
        assertEquals(expResult, result);
        
        str = "high up";
        expResult = false;
        result = instance.startHi(str);
        assertEquals(expResult, result);
    }

}