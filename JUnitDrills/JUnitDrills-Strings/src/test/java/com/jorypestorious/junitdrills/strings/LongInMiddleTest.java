
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class LongInMiddleTest {

//longInMiddle("Hello", "hi") -> "hiHellohi"
//longInMiddle("hi", "Hello") -> "hiHellohi"
//longInMiddle("aaa", "b") -> "baaab"

    @Test
    public void testLongInMiddle() {
        System.out.println("longInMiddle");
        String a = "Hello";
        String b = "hi";
        LongInMiddle instance = new LongInMiddle();
        String expResult = "hiHellohi";
        String result = instance.longInMiddle(a, b);
        assertEquals(expResult, result);
        
        a = "hi";
        b = "Hello";
        expResult = "hiHellohi";
        result = instance.longInMiddle(a, b);
        assertEquals(expResult, result);
        
        a = "aaa";
        b = "b";
        expResult = "baaab";
        result = instance.longInMiddle(a, b);
        assertEquals(expResult, result);
    }

}