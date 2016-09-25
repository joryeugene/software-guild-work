
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinCatTest {

//minCat("Hello", "Hi") -> "loHi"
//minCat("Hello", "java") -> "ellojava"
//minCat("java", "Hello") -> "javaello"

    @Test
    public void testMinCat() {
        System.out.println("minCat");
        String a = "Hello";
        String b = "Hi";
        MinCat instance = new MinCat();
        String expResult = "loHi";
        String result = instance.minCat(a, b);
        assertEquals(expResult, result);
        
        a = "Hello";
        b = "java";
        expResult = "ellojava";
        result = instance.minCat(a, b);
        assertEquals(expResult, result);
        
        a = "java";
        b = "Hello";
        expResult = "javaello";
        result = instance.minCat(a, b);
        assertEquals(expResult, result);
    }

}