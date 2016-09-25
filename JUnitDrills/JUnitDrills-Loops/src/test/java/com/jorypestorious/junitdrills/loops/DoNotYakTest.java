
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class DoNotYakTest {

//doNotYak("yakpak") -> "pak"
//doNotYak("pakyak") -> "pak"
//doNotYak("yak123ya") -> "123ya"
//doNotYak("yek123ya") -> "123ya"

    @Test
    public void testDoNotYak() {
        System.out.println("doNotYak");
        String str = "yakpak";
        DoNotYak instance = new DoNotYak();
        String expResult = "pak";
        String result = instance.doNotYak(str);
        assertEquals(expResult, result);
        
        str = "pakyak";
        expResult = "pak";
        result = instance.doNotYak(str);
        assertEquals(expResult, result);
        
        str = "yak123ya";
        expResult = "123ya";
        result = instance.doNotYak(str);
        assertEquals(expResult, result);
        
        str = "yek123ya";
        expResult = "123ya";
        result = instance.doNotYak(str);
        assertEquals(expResult, result);
    }

}