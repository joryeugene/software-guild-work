
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class FrontAndBackTest {

//frontAndBack("Hello", 2) -> "Helo"
//frontAndBack("Chocolate", 3) -> "Choate"
//frontAndBack("Chocolate", 1) -> "Ce"

    @Test
    public void testFrontAndBack() {
        System.out.println("frontAndBack");
        String str = "Hello";
        int n = 2;
        FrontAndBack instance = new FrontAndBack();
        String expResult = "Helo";
        String result = instance.frontAndBack(str, n);
        assertEquals(expResult, result);
        
        str = "Chocolate";
        n = 3;
        expResult = "Choate";
        result = instance.frontAndBack(str, n);
        assertEquals(expResult, result);
        
        str = "Chocolate";
        n = 1;
        expResult = "Ce";
        result = instance.frontAndBack(str, n);
        assertEquals(expResult, result);
    }

}