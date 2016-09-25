
package com.jorypestorious.junitdrills.conditionals;

import org.junit.Test;
import static org.junit.Assert.*;

public class Multiple3or5Test {

//multiple3or5(3) -> true
//multiple3or5(10) -> true
//multiple3or5(8) -> false

    @Test
    public void testMultiple3or5() {
        System.out.println("multiple3or5");
        int number = 3;
        Multiple3or5 instance = new Multiple3or5();
        boolean expResult = true;
        boolean result = instance.multiple3or5(number);
        assertEquals(expResult, result);
        
        number = 10;
        expResult = true;
        result = instance.multiple3or5(number);
        assertEquals(expResult, result);
        
        number = 8;
        expResult = false;
        result = instance.multiple3or5(number);
        assertEquals(expResult, result);
    }

}