
package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class Double23Test {

    //    double23({2, 2, 3}) -> true
//    double23({3, 4, 5, 3}) -> true
//    double23({2, 3, 2, 2}) -> false

    @Test
    public void testDouble23() {
        System.out.println("double23");
        int[] numbers = {2, 2, 3};
        Double23 instance = new Double23();
        boolean expResult = true;
        boolean result = instance.double23(numbers);
        assertEquals(expResult, result);
        
        int[] numbers2 = {3, 4, 5, 3};
        result = instance.double23(numbers2);
        assertEquals(expResult, result);
        
        int[] numbers3 = {2, 3, 2, 2};
        expResult = false;
        result = instance.double23(numbers3);
        assertEquals(expResult, result);
    }

}