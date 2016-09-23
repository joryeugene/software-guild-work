
package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class Fix23Test {

    //
//    fix23({1, 2, 3}) ->{1, 2, 0}
//    fix23({2, 3, 5}) -> {2, 0, 5}
//    fix23({1, 2, 1}) -> {1, 2, 1}

    @Test
    public void testFix23() {
        System.out.println("fix23");
        int[] numbers = {1, 2, 3};
        Fix23 instance = new Fix23();
        int[] expResult = {1, 2, 0};
        int[] result = instance.fix23(numbers);
        assertArrayEquals(expResult, result);
        
        int[] numbers2 = {2, 3, 5};
        int[] expResult2 = {2, 0, 5};
        int[] result2 = instance.fix23(numbers2);
        assertArrayEquals(expResult2, result2);
        
        int[] numbers3 = {1, 2, 1};
        int[] expResult3 = {1, 2, 1};
        int[] result3 = instance.fix23(numbers3);
        assertArrayEquals(expResult3, result3);
    }

}