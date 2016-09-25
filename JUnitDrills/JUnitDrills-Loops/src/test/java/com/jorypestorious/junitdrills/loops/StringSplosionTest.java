
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringSplosionTest {

//stringSplosion("Code") -> "CCoCodCode"
//stringSplosion("abc") -> "aababc"
//stringSplosion("ab") -> "aab"

    @Test
    public void testStringSplosion() {
        System.out.println("stringSplosion");
        String str = "Code";
        StringSplosion instance = new StringSplosion();
        String expResult = "CCoCodCode";
        String result = instance.stringSplosion(str);
        assertEquals(expResult, result);
        
        str = "abc";
        expResult = "aababc";
        result = instance.stringSplosion(str);
        assertEquals(expResult, result);
        
        str = "ab";
        expResult = "aab";
        result = instance.stringSplosion(str);
        assertEquals(expResult, result);
    }

}