
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class FirstHalfTest {

//firstHalf("WooHoo") -> "Woo"
//firstHalf("HelloThere") -> "Hello"
//firstHalf("abcdef") -> "abc"

    @Test
    public void testFirstHalf() {
        System.out.println("firstHalf");
        String str = "WooHoo";
        FirstHalf instance = new FirstHalf();
        String expResult = "Woo";
        String result = instance.firstHalf(str);
        assertEquals(expResult, result);
        
        str = "HelloThere";
        expResult = "Hello";
        result = instance.firstHalf(str);
        assertEquals(expResult, result);
        
        str = "abcdef";
        expResult = "abc";
        result = instance.firstHalf(str);
        assertEquals(expResult, result);
    }

}