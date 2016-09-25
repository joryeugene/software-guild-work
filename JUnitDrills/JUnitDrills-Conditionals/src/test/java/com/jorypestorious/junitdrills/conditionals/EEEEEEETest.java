
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class EEEEEEETest {

//gotE("Hello") -> true
//gotE("Heelle") -> true
//gotE("Heelele") -> false

    @Test
    public void testGotE() {
        System.out.println("gotE");
        String str = "Hello";
        EEEEEEE instance = new EEEEEEE();
        boolean expResult = true;
        boolean result = instance.gotE(str);
        assertEquals(expResult, result);
        
        str = "Heelle";
        expResult = true;
        result = instance.gotE(str);
        assertEquals(expResult, result);
        
        str = "Heelele";
        expResult = false;
        result = instance.gotE(str);
        assertEquals(expResult, result);
    }

}