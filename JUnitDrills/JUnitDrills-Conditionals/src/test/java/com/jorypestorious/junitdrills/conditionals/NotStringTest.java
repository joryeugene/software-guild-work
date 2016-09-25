
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class NotStringTest {

//notString("candy") -> "not candy"
//notString("x") -> "not x"
//notString("not bad") -> "not bad"

    @Test
    public void testNotString() {
        System.out.println("notString");
        String s = "candy";
        NotString instance = new NotString();
        String expResult = "not candy";
        String result = instance.notString(s);
        assertEquals(expResult, result);
        
        s = "x";
        expResult = "not x";
        result = instance.notString(s);
        assertEquals(expResult, result);
        
        s = "not bad";
        expResult = "not bad";
        result = instance.notString(s);
        assertEquals(expResult, result);
    }

}