
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class SayHiTest {

//sayHi("Bob") -> "Hello Bob!"
//sayHi("Alice") -> "Hello Alice!"
//sayHi("X") -> "Hello X!"

    @Test
    public void testSayHi() {
        System.out.println("sayHi");
        String name = "Bob";
        SayHi instance = new SayHi();
        String expResult = "Hello Bob!";
        String result = instance.sayHi(name);
        assertEquals(expResult, result);
        
        name = "Alice";
        expResult = "Hello Alice!";
        result = instance.sayHi(name);
        assertEquals(expResult, result);
        
        name = "X";
        expResult = "Hello X!";
        result = instance.sayHi(name);
        assertEquals(expResult, result);
    }

}