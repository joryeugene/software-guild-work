
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class EndsWithLyTest {

//endsWithLy("oddly") -> true
//endsWithLy("y") -> false
//endsWithLy("oddy") -> false

    @Test
    public void testEndsWithLy() {
        System.out.println("endsWithLy");
        String str = "oddly";
        EndsWithLy instance = new EndsWithLy();
        boolean expResult = true;
        boolean result = instance.endsWithLy(str);
        assertEquals(expResult, result);
        
        str = "y";
        expResult = false;
        result = instance.endsWithLy(str);
        assertEquals(expResult, result);
        
        str = "oddy";
        expResult = false;
        result = instance.endsWithLy(str);
        assertEquals(expResult, result);
    }

}