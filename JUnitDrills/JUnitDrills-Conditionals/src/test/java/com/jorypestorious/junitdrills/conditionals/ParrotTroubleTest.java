
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class ParrotTroubleTest {

//parrotTrouble(true, 6) -> true
//parrotTrouble(true, 7) -> false
//parrotTrouble(false, 6) -> false

    @Test
    public void testParrotTrouble() {
        System.out.println("parrotTrouble");
        boolean isTalking = true;
        int hour = 6;
        ParrotTrouble instance = new ParrotTrouble();
        boolean expResult = true;
        boolean result = instance.parrotTrouble(isTalking, hour);
        assertEquals(expResult, result);
        
        isTalking = true;
        hour = 7;
        expResult = false;
        result = instance.parrotTrouble(isTalking, hour);
        assertEquals(expResult, result);
        
        isTalking = false;
        hour = 6;
        expResult = false;
        result = instance.parrotTrouble(isTalking, hour);
        assertEquals(expResult, result);
    }

}