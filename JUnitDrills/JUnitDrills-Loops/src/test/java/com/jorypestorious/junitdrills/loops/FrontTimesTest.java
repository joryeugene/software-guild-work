
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class FrontTimesTest {

//frontTimes("Chocolate", 2) -> "ChoCho"
//frontTimes("Chocolate", 3) -> "ChoChoCho"
//frontTimes("Abc", 3) -> "AbcAbcAbc"
//frontTimes("A", 3) -> "AAA"

    @Test
    public void testFrontTimes() {
        System.out.println("frontTimes");
        String str = "Chocolate";
        int n = 2;
        FrontTimes instance = new FrontTimes();
        String expResult = "ChoCho";
        String result = instance.frontTimes(str, n);
        assertEquals(expResult, result);
        
        str = "Chocolate";
        n = 3;
        expResult = "ChoChoCho";
        result = instance.frontTimes(str, n);
        assertEquals(expResult, result);
        
        str = "Abc";
        n = 3;
        expResult = "AbcAbcAbc";
        result = instance.frontTimes(str, n);
        assertEquals(expResult, result);
        
        str = "A";
        n = 3;
        expResult = "AAA";
        result = instance.frontTimes(str, n);
        assertEquals(expResult, result);
    }

}