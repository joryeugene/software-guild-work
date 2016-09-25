
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class BackAroundTest {

//backAround("cat") -> "tcatt"
//backAround("Hello") -> "oHelloo"
//backAround("a") -> "aaa"

    @Test
    public void testBackAround() {
        System.out.println("backAround");
        String str = "cat";
        BackAround instance = new BackAround();
        String expResult = "tcatt";
        String result = instance.backAround(str);
        assertEquals(expResult, result);
        
        str = "Hello";
        expResult = "oHelloo";
        result = instance.backAround(str);
        assertEquals(expResult, result);
        
        str = "a";
        expResult = "aaa";
        result = instance.backAround(str);
        assertEquals(expResult, result);
    }

}