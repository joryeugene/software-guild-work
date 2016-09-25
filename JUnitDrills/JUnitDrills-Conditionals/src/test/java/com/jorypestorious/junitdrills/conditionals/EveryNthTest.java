
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class EveryNthTest {

//everyNth("Miracle", 2) -> "Mrce"
//everyNth("abcdefg", 2) -> "aceg"
//everyNth("abcdefg", 3) -> "adg"

    @Test
    public void testEveryNth() {
        System.out.println("everyNth");
        String str = "Miracle";
        int n = 2;
        EveryNth instance = new EveryNth();
        String expResult = "Mrce";
        String result = instance.everyNth(str, n);
        assertEquals(expResult, result);
        
        str = "abcdefg";
        n = 2;
        expResult = "aceg";
        result = instance.everyNth(str, n);
        assertEquals(expResult, result);
        
        str = "abcdefg";
        n = 3;
        expResult = "adg";
        result = instance.everyNth(str, n);
        assertEquals(expResult, result);
    }

}