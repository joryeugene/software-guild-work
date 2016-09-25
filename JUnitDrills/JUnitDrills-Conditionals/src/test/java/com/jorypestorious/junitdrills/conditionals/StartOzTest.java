
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class StartOzTest {

//startOz("ozymandias") -> "oz"
//startOz("bzoo") -> "z"
//startOz("oxx") -> "o"

    @Test
    public void testStartOz() {
        System.out.println("startOz");
        String str = "ozymandias";
        StartOz instance = new StartOz();
        String expResult = "oz";
        String result = instance.startOz(str);
        assertEquals(expResult, result);
        
        str = "bzoo";
        expResult = "z";
        result = instance.startOz(str);
        assertEquals(expResult, result);
        
        str = "oxx";
        expResult = "o";
        result = instance.startOz(str);
        assertEquals(expResult, result);
    }

}