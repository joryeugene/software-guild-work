
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class MiddleTwoTest {

//middleTwo("String") -> "ri"
//middleTwo("code") -> "od"
//middleTwo("Practice") -> "ct"

    @Test
    public void testMiddleTwo() {
        System.out.println("middleTwo");
        String str = "String";
        MiddleTwo instance = new MiddleTwo();
        String expResult = "ri";
        String result = instance.middleTwo(str);
        assertEquals(expResult, result);
        
        str = "code";
        expResult = "od";
        result = instance.middleTwo(str);
        assertEquals(expResult, result);
        
        str = "Practice";
        expResult = "ct";
        result = instance.middleTwo(str);
        assertEquals(expResult, result);
    }

}