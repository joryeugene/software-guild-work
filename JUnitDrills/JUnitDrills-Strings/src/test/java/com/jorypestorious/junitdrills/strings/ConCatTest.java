
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class ConCatTest {

//conCat("abc", "cat") -> "abcat"
//conCat("dog", "cat") -> "dogcat"
//conCat("abc", "") -> "abc"

    @Test
    public void testConCat() {
        System.out.println("conCat");
        String a = "abc";
        String b = "cat";
        ConCat instance = new ConCat();
        String expResult = "abcat";
        String result = instance.conCat(a, b);
        assertEquals(expResult, result);
        
        a = "dog";
        b = "cat";
        expResult = "dogcat";
        result = instance.conCat(a, b);
        assertEquals(expResult, result);
        
        a = "abc";
        b = "";
        expResult = "abc";
        result = instance.conCat(a, b);
        assertEquals(expResult, result);
    }

}