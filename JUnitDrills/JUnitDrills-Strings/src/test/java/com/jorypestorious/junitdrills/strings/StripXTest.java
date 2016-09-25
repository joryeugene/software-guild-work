
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class StripXTest {

//stripX("xHix") -> "Hi"
//stripX("xHi") -> "Hi"
//stripX("Hxix") -> "Hxi"

    @Test
    public void testStripX() {
        System.out.println("stripX");
        String str = "xHix";
        StripX instance = new StripX();
        String expResult = "Hi";
        String result = instance.stripX(str);
        assertEquals(expResult, result);
        
        str = "xHi";
        expResult = "Hi";
        result = instance.stripX(str);
        assertEquals(expResult, result);
        
        str = "Hxix";
        expResult = "Hxi";
        result = instance.stripX(str);
        assertEquals(expResult, result);
        
        str = "xx";
        expResult = "";
        result = instance.stripX(str);
        assertEquals(expResult, result);
        
        str = "a";
        expResult = "a";
        result = instance.stripX(str);
        assertEquals(expResult, result);
        
        str = "ab";
        expResult = "ab";
        result = instance.stripX(str);
        assertEquals(expResult, result);
        
        str = "";
        expResult = "";
        result = instance.stripX(str);
        assertEquals(expResult, result);
        
        str = "x";
        expResult = "";
        result = instance.stripX(str);
        assertEquals(expResult, result);
        
        str = "ax";
        expResult = "a";
        result = instance.stripX(str);
        assertEquals(expResult, result);
        
        str = "xa";
        expResult = "a";
        result = instance.stripX(str);
        assertEquals(expResult, result);
    }

}