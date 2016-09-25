
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class AtFirstTest {

//atFirst("hello") -> "he"
//atFirst("hi") -> "hi"
//atFirst("h") -> "h@"

    @Test
    public void testAtFirst() {
        System.out.println("atFirst");
        String str = "hello";
        AtFirst instance = new AtFirst();
        String expResult = "he";
        String result = instance.atFirst(str);
        assertEquals(expResult, result);
        
        str = "hi";
        expResult = "hi";
        result = instance.atFirst(str);
        assertEquals(expResult, result);
        
        str = "h";
        expResult = "h@";
        result = instance.atFirst(str);
        assertEquals(expResult, result);
    }

}