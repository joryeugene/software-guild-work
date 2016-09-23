
package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class GetMiddleTest {

    //    getMiddle({1, 2, 3}, {4, 5, 6}) -> {2, 5}
//    getMiddle({7, 7, 7}, {3, 8, 0}) -> {7, 8}
//    getMiddle({5, 2, 9}, {1, 4, 5}) -> {2, 4}

    @Test
    public void testGetMiddle() {
        System.out.println("getMiddle");
        int[] a = {1, 2, 3};
        int[] b = {4, 5, 6};
        GetMiddle instance = new GetMiddle();
        int[] expResult = {2, 5};
        int[] result = instance.getMiddle(a, b);
        assertArrayEquals(expResult, result);
        
        int[] a2 = {7, 7, 7};
        int[] b2 = {3, 8, 0};
        int[] expResult2 = {7, 8};
        int[] result2 = instance.getMiddle(a2, b2);
        assertArrayEquals(expResult2, result2);
    }

}