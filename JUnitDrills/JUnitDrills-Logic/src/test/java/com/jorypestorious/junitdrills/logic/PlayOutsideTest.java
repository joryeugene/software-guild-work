
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayOutsideTest {

//playOutside(70, false) → true
//playOutside(95, false) → false
//playOutside(95, true) → true

    @Test
    public void testPlayOutside() {
        System.out.println("playOutside");
        int temp = 70;
        boolean isSummer = false;
        PlayOutside instance = new PlayOutside();
        boolean expResult = true;
        boolean result = instance.playOutside(temp, isSummer);
        assertEquals(expResult, result);
        
        temp = 95;
        isSummer = false;
        expResult = false;
        result = instance.playOutside(temp, isSummer);
        assertEquals(expResult, result);
        
        temp = 95;
        isSummer = true;
        expResult = true;
        result = instance.playOutside(temp, isSummer);
        assertEquals(expResult, result);
    }

}