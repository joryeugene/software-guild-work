package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReverseTest {
    
    // Given an array of ints length 3, return a new array with the elements in reverse order, 
    // so for example {1, 2, 3} becomes {3, 2, 1}. {1,2,3,4} {4,3,2,1}

    @Test
    public void testReverse() {
        System.out.println("reverse");
        int[] numbers = {1, 2, 3};
        Reverse instance = new Reverse();
        int[] expResult = {3, 2, 1};
        int[] result = instance.reverse(numbers);
        assertArrayEquals(expResult, result);
        
        int[] numbers2 = {1, 2, 3, 4};
        int[] expResult2 = {4, 3, 2, 1};
        int[] result2 = instance.reverse(numbers2);
        assertArrayEquals(expResult2, result2);
    }
    
}
