
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringXTest {

//stringX("xxHxix") -> "xHix"
//stringX("abxxxcd") -> "abcd"
//stringX("xabxxxcdx") -> "xabcdx"
//stringX("ax") -> "ax"
    //stringX("a") -> "a"

    @Test
    public void testStringX() {
        System.out.println("stringX");
        String str = "xxHxix";
        StringX instance = new StringX();
        String expResult = "xHix";
        String result = instance.stringX(str);
        assertEquals(expResult, result);
        
        str = "abxxxcd";
        expResult = "abcd";
        result = instance.stringX(str);
        assertEquals(expResult, result);
        
        str = "xabxxxcdx";
        expResult = "xabcdx";
        result = instance.stringX(str);
        assertEquals(expResult, result);
        
        str = "ax";
        expResult = "ax";
        result = instance.stringX(str);
        assertEquals(expResult, result);
        
        str = "a";
        expResult = "a";
        result = instance.stringX(str);
        assertEquals(expResult, result);
    }

}