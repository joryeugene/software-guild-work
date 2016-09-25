
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountLast2Test {

//countLast2("hixxhi") -> 1
//countLast2("xaxxaxaxx") -> 1
//countLast2("axxxaaxx") -> 2

    @Test
    public void testCountLast2() {
        System.out.println("countLast2");
        String str = "hixxhi";
        CountLast2 instance = new CountLast2();
        int expResult = 1;
        int result = instance.countLast2(str);
        assertEquals(expResult, result);
        
        str = "xxx";
        expResult = 0;
        result = instance.countLast2(str);
        assertEquals(expResult, result);
        
        str = "xaxxaxaxx";
        expResult = 1;
        result = instance.countLast2(str);
        assertEquals(expResult, result);
        
        str = "axxxaaxx";
        expResult = 2;
        result = instance.countLast2(str);
        assertEquals(expResult, result);
    }

}