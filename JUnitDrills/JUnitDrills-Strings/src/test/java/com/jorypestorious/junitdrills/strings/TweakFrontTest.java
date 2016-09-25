
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class TweakFrontTest {

//tweakFront("Hello") -> "llo"
//tweakFront("away") -> "aay"
//tweakFront("abed") -> "abed"

    @Test
    public void testTweakFront() {
        System.out.println("tweakFront");
        String str = "Hello";
        TweakFront instance = new TweakFront();
        String expResult = "llo";
        String result = instance.tweakFront(str);
        assertEquals(expResult, result);
        
        str = "away";
        expResult = "aay";
        result = instance.tweakFront(str);
        assertEquals(expResult, result);
        
        str = "abed";
        expResult = "abed";
        result = instance.tweakFront(str);
        assertEquals(expResult, result);
        
        str = "";
        expResult = "";
        result = instance.tweakFront(str);
        assertEquals(expResult, result);
        
        str = "a";
        expResult = "a";
        result = instance.tweakFront(str);
        assertEquals(expResult, result);
        
        str = "b";
        expResult = "";
        result = instance.tweakFront(str);
        assertEquals(expResult, result);
        
        str = "xb";
        expResult = "b";
        result = instance.tweakFront(str);
        assertEquals(expResult, result);
    }

}