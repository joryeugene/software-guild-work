
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class AbbaTest {

//abba("Hi", "Bye") -> "HiByeByeHi"
//abba("Yo", "Alice") -> "YoAliceAliceYo"
//abba("What", "Up") -> "WhatUpUpWhat"

    @Test
    public void testAbba() {
        System.out.println("abba");
        String a = "Hi";
        String b = "Bye";
        Abba instance = new Abba();
        String expResult = "HiByeByeHi";
        String result = instance.abba(a, b);
        assertEquals(expResult, result);
        
        a = "Yo";
        b = "Alice";
        expResult = "YoAliceAliceYo";
        result = instance.abba(a, b);
        assertEquals(expResult, result);
        
        a = "What";
        b = "Up";
        expResult = "WhatUpUpWhat";
        result = instance.abba(a, b);
        assertEquals(expResult, result);
    }

}