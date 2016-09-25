
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class TrimOneTest {

//trimOne("Hello") -> "ell"
//trimOne("java") -> "av"
//trimOne("coding") -> "odin"

    @Test
    public void testTrimOne() {
        System.out.println("trimOne");
        String str = "Hello";
        TrimOne instance = new TrimOne();
        String expResult = "ell";
        String result = instance.trimOne(str);
        assertEquals(expResult, result);
        
        str = "java";
        expResult = "av";
        result = instance.trimOne(str);
        assertEquals(expResult, result);
        
        str = "coding";
        expResult = "odin";
        result = instance.trimOne(str);
        assertEquals(expResult, result);
    }

}