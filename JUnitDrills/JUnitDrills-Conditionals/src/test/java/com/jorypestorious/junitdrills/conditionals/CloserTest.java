
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class CloserTest {

//closer(8, 13) -> 8
//closer(13, 8) -> 8
//closer(13, 7) -> 0

    @Test
    public void testCloser() {
        System.out.println("closer");
        int a = 8;
        int b = 13;
        Closer instance = new Closer();
        int expResult = 8;
        int result = instance.closer(a, b);
        assertEquals(expResult, result);
        
        a = 13;
        b = 8;
        expResult = 8;
        result = instance.closer(a, b);
        assertEquals(expResult, result);
        
        a = 13;
        b = 7;
        expResult = 0;
        result = instance.closer(a, b);
        assertEquals(expResult, result);
    }

}