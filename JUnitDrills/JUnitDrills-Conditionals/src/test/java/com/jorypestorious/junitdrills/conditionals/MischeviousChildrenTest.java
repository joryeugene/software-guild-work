
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class MischeviousChildrenTest {

//areWeInTrouble(true, true) -> true
//areWeInTrouble(false, false) -> true
//areWeInTrouble(true, false) -> false

    @Test
    public void testAreWeInTrouble() {
        System.out.println("areWeInTrouble");
        boolean aSmile = true;
        boolean bSmile = true;
        MischeviousChildren instance = new MischeviousChildren();
        boolean expResult = true;
        boolean result = instance.areWeInTrouble(aSmile, bSmile);
        assertEquals(expResult, result);
        
        aSmile = false;
        bSmile = false;
        expResult = true;
        result = instance.areWeInTrouble(aSmile, bSmile);
        assertEquals(expResult, result);
        
        aSmile = true;
        bSmile = false;
        expResult = false;
        result = instance.areWeInTrouble(aSmile, bSmile);
        assertEquals(expResult, result);
    }

}