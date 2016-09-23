
package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class KeepLastTest {

    //    keepLast({4, 5, 6}) -> {0, 0, 0, 0, 0, 6}
//    keepLast({1, 2}) -> {0, 0, 0, 2}
//    keepLast({3}) -> {0, 3}

    @Test
    public void testKeepLast() {
        System.out.println("keepLast");
        int[] numbers = {4, 5, 6};
        KeepLast instance = new KeepLast();
        int[] expResult = {0, 0, 0, 0, 0, 6};
        int[] result = instance.keepLast(numbers);
        assertArrayEquals(expResult, result);
        
        int[] numbers2 = {1, 2};
        int[] expResult2 = {0, 0, 0, 2};
        int[] result2 = instance.keepLast(numbers2);
        assertArrayEquals(expResult2, result2);
        
        int[] numbers3 = {3};
        int[] expResult3 = {0, 3};
        int[] result3 = instance.keepLast(numbers3);
        assertArrayEquals(expResult3, result3);
    }

}