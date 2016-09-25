
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class EveryOtherTest {

//everyOther("Hello") -> "Hlo"
//everyOther("Hi") -> "H"
//everyOther("Heeololeo") -> "Hello"

    @Test
    public void testEveryOther() {
        System.out.println("everyOther");
        String str = "Hello";
        EveryOther instance = new EveryOther();
        String expResult = "Hlo";
        String result = instance.everyOther(str);
        assertEquals(expResult, result);
        
        str = "Hi";
        expResult = "H";
        result = instance.everyOther(str);
        assertEquals(expResult, result);
        
        str = "Heeololeo";
        expResult = "Hello";
        result = instance.everyOther(str);
        assertEquals(expResult, result);
    }

}