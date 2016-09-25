
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class EndUpTest {

//endUp("Hello") -> "HeLLO"
//endUp("hi there") -> "hi thERE"
//endUp("hi") -> "HI"

    @Test
    public void testEndUp() {
        System.out.println("endUp");
        String str = "Hello";
        EndUp instance = new EndUp();
        String expResult = "HeLLO";
        String result = instance.endUp(str);
        assertEquals(expResult, result);
        
        str = "hi there";
        expResult = "hi thERE";
        result = instance.endUp(str);
        assertEquals(expResult, result);
        
        str = "hi";
        expResult = "HI";
        result = instance.endUp(str);
        assertEquals(expResult, result);
    }

}