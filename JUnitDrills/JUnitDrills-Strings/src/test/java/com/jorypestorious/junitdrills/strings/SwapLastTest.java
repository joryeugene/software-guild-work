
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class SwapLastTest {

//swapLast("coding") -> "codign"
//swapLast("cat") -> "cta"
//swapLast("ab") -> "ba"

    @Test
    public void testSwapLast() {
        System.out.println("swapLast");
        String str = "coding";
        SwapLast instance = new SwapLast();
        String expResult = "codign";
        String result = instance.swapLast(str);
        assertEquals(expResult, result);
        
        str = "cat";
        expResult = "cta";
        result = instance.swapLast(str);
        assertEquals(expResult, result);
        
        str = "ab";
        expResult = "ba";
        result = instance.swapLast(str);
        assertEquals(expResult, result);
    }

}