
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class MissingCharTest {

//missingChar("kitten", 1) -> "ktten"
//missingChar("kitten", 0) -> "itten"
//missingChar("kitten", 4) -> "kittn"

    @Test
    public void testMissingChar() {
        System.out.println("missingChar");
        String str = "kitten";
        int n = 1;
        MissingChar instance = new MissingChar();
        String expResult = "ktten";
        String result = instance.missingChar(str, n);
        assertEquals(expResult, result);
        
        n = 0;
        expResult = "itten";
        result = instance.missingChar(str, n);
        assertEquals(expResult, result);
        
        n = 4;
        expResult = "kittn";
        result = instance.missingChar(str, n);
        assertEquals(expResult, result);
    }

}