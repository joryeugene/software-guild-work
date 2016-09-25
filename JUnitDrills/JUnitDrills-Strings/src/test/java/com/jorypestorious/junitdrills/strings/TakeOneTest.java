
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class TakeOneTest {

//takeOne("Hello", true) -> "H"
//takeOne("Hello", false) -> "o"
//takeOne("oh", true) -> "o"

    @Test
    public void testTakeOne() {
        System.out.println("takeOne");
        String str = "Hello";
        boolean fromFront = true;
        TakeOne instance = new TakeOne();
        String expResult = "H";
        String result = instance.takeOne(str, fromFront);
        assertEquals(expResult, result);
        
        str = "Hello";
        fromFront = false;
        expResult = "o";
        result = instance.takeOne(str, fromFront);
        assertEquals(expResult, result);
        
        str = "oh";
        fromFront = true;
        expResult = "o";
        result = instance.takeOne(str, fromFront);
        assertEquals(expResult, result);
    }

}