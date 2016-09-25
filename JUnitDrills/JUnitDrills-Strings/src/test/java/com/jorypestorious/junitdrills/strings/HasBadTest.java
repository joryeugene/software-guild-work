
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class HasBadTest {

//hasBad("badxx") -> true
//hasBad("xbadxx") -> true
//hasBad("xxbadxx") -> false

    @Test
    public void testHasBad() {
        System.out.println("hasBad");
        String str = "badxx";
        HasBad instance = new HasBad();
        boolean expResult = true;
        boolean result = instance.hasBad(str);
        assertEquals(expResult, result);
        
        str = "xbadxx";
        expResult = true;
        result = instance.hasBad(str);
        assertEquals(expResult, result);
        
        str = "xxbadxx";
        expResult = false;
        result = instance.hasBad(str);
        assertEquals(expResult, result);
    }

}