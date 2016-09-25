
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class TakeTwoFromPositionTest {

//takeTwoFromPosition("java", 0) -> "ja"
//takeTwoFromPosition("java", 2) -> "va"
//takeTwoFromPosition("java", 3) -> "ja"

    @Test
    public void testTakeTwoFromPosition() {
        System.out.println("takeTwoFromPosition");
        String str = "java";
        int n = 0;
        TakeTwoFromPosition instance = new TakeTwoFromPosition();
        String expResult = "ja";
        String result = instance.takeTwoFromPosition(str, n);
        assertEquals(expResult, result);
        
        str = "java";
        n = 3;
        expResult = "ja";
        result = instance.takeTwoFromPosition(str, n);
        assertEquals(expResult, result);
        
        str = "java";
        n = 2;
        expResult = "va";
        result = instance.takeTwoFromPosition(str, n);
        assertEquals(expResult, result);
    }

}