
package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class Make2Test {

    //    make2({4, 5}, {1, 2, 3}) -> {4, 5}
//    make2({4}, {1, 2, 3}) -> {4, 1}
//    make2({}, {1, 2}) -> {1, 2}

    @Test
    public void testMake2() {
        System.out.println("make2");
        Make2 instance = new Make2();
        
        int[] a = {4, 5};
        int[] b = {1, 2, 3};
        int[] expResult = {4, 5};
        int[] result = instance.make2(a, b);
        assertArrayEquals(expResult, result);
        
        int[] a2 = {4};
        int[] expResult2 = {4, 1};
        int[] result2 = instance.make2(a2, b);
        assertArrayEquals(expResult2, result2);
        System.out.println(result2);
        
        int[] a3 = {};
        int[] expResult3 = {1, 2};
        int[] result3 = instance.make2(a3, b);
        assertArrayEquals(expResult3, result3);
        System.out.println(result3);
    }

}