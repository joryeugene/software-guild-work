
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class RotateLeft2Test {

//rotateLeft2("Hello") -> "lloHe"
//rotateLeft2("java") -> "vaja"
//rotateLeft2("Hi") -> "Hi"

    @Test
    public void testRotateLeft2() {
        System.out.println("rotateLeft2");
        String str = "Hello";
        RotateLeft2 instance = new RotateLeft2();
        String expResult = "lloHe";
        String result = instance.rotateLeft2(str);
        assertEquals(expResult, result);
        
        str = "java";
        expResult = "vaja";
        result = instance.rotateLeft2(str);
        assertEquals(expResult, result);
        
        str = "Hi";
        expResult = "Hi";
        result = instance.rotateLeft2(str);
        assertEquals(expResult, result);
    }

}