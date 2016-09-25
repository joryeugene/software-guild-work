
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class Front3Test {

//front3("Microsoft") -> "MicMicMic"
//front3("Chocolate") -> "ChoChoCho"
//front3("at") -> "atatat"

    @Test
    public void testFront3() {
        System.out.println("front3");
        String str = "Microsoft";
        Front3 instance = new Front3();
        String expResult = "MicMicMic";
        String result = instance.front3(str);
        assertEquals(expResult, result);
        
        str = "Chocolate";
        expResult = "ChoChoCho";
        result = instance.front3(str);
        assertEquals(expResult, result);
        
        str = "at";
        expResult = "atatat";
        result = instance.front3(str);
        assertEquals(expResult, result);
    }

}