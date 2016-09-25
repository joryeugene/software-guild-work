
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class RemoveDelTest {

//removeDel("adelbc") -> "abc"
//removeDel("adelHello") -> "aHello"
//removeDel("adedbc") -> "adedbc"

    @Test
    public void testRemoveDel() {
        System.out.println("removeDel");
        String str = "adelbc";
        RemoveDel instance = new RemoveDel();
        String expResult = "abc";
        String result = instance.removeDel(str);
        assertEquals(expResult, result);
        
        str = "adelHello";
        expResult = "aHello";
        result = instance.removeDel(str);
        assertEquals(expResult, result);
        
        str = "adedbc";
        expResult = "adedbc";
        result = instance.removeDel(str);
        assertEquals(expResult, result);
    }

}