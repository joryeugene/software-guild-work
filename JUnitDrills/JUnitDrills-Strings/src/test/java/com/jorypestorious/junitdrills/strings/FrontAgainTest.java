
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class FrontAgainTest {

//frontAgain("edited") -> true
//frontAgain("edit") -> false
//frontAgain("ed") -> true

    @Test
    public void testFrontAgain() {
        System.out.println("frontAgain");
        String str = "edited";
        FrontAgain instance = new FrontAgain();
        boolean expResult = true;
        boolean result = instance.frontAgain(str);
        assertEquals(expResult, result);
        
        str = "edit";
        expResult = false;
        result = instance.frontAgain(str);
        assertEquals(expResult, result);
        
        str = "ed";
        expResult = true;
        result = instance.frontAgain(str);
        assertEquals(expResult, result);
    }

}