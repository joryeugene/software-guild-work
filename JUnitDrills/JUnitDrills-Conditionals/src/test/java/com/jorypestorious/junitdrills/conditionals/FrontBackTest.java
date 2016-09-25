
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class FrontBackTest {

//frontBack("code") -> "eodc"
//frontBack("a") -> "a"
//frontBack("ab") -> "ba"

    @Test
    public void testFrontBack() {
        System.out.println("frontBack");
        String str = "code";
        FrontBack instance = new FrontBack();
        String expResult = "eodc";
        String result = instance.frontBack(str);
        assertEquals(expResult, result);
        
        str = "a";
        expResult = "a";
        result = instance.frontBack(str);
        assertEquals(expResult, result);
        
        str = "ab";
        expResult = "ba";
        result = instance.frontBack(str);
        assertEquals(expResult, result);
    }

}