
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class MultipleEndingsTest {

//multipleEndings("Hello") -> "lololo"
//multipleEndings("ab") -> "ababab"
//multipleEndings("Hi") -> "HiHiHi"

    @Test
    public void testMultipleEndings() {
        System.out.println("multipleEndings");
        String str = "Hello";
        MultipleEndings instance = new MultipleEndings();
        String expResult = "lololo";
        String result = instance.multipleEndings(str);
        assertEquals(expResult, result);
        
        str = "ab";
        expResult = "ababab";
        result = instance.multipleEndings(str);
        assertEquals(expResult, result);
        
        str = "Hi";
        expResult = "HiHiHi";
        result = instance.multipleEndings(str);
        assertEquals(expResult, result);
    }

}