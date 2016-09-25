
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class RotateRight2Test {

//rotateRight2("Hello") -> "loHel"
//rotateRight2("java") -> "vaja"
//rotateRight2("Hi") -> "Hi"

    @Test
    public void testRotateReft2() {
        System.out.println("rotateReft2");
        String str = "Hello";
        RotateRight2 instance = new RotateRight2();
        String expResult = "loHel";
        String result = instance.rotateReft2(str);
        assertEquals(expResult, result);
        
        str = "java";
        expResult = "vaja";
        result = instance.rotateReft2(str);
        assertEquals(expResult, result);
        
        str = "Hi";
        expResult = "Hi";
        result = instance.rotateReft2(str);
        assertEquals(expResult, result);
    }

}