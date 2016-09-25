
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class Array667Test {

//array667({6, 6, 2}) -> 1
//array667({6, 6, 2, 6}) -> 1
//array667({6, 7, 2, 6}) -> 1
    //array667({6}) -> 0
    //array667({6, 7, 6, 0}) -> 1
    //array667({6, 7, 6, 6}) -> 2

    @Test
    public void testArray667() {
        System.out.println("array667");
        int[] numbers = {6, 6, 2};
        Array667 instance = new Array667();
        int expResult = 1;
        int result = instance.array667(numbers);
        assertEquals(expResult, result);
        
        int[] numbers2 = {6, 6, 2, 6};
        expResult = 1;
        result = instance.array667(numbers2);
        assertEquals(expResult, result);
        
        int[] numbers3 = {6, 7, 2, 6};
        expResult = 1;
        result = instance.array667(numbers3);
        assertEquals(expResult, result);
        
        int[] numbers4 = {6};
        expResult = 0;
        result = instance.array667(numbers4);
        assertEquals(expResult, result);
        
        int[] numbers5 = {6, 7, 6, 0};
        expResult = 1;
        result = instance.array667(numbers5);
        assertEquals(expResult, result);
        
        int[] numbers6 = {6, 7, 6, 6};
        expResult = 2;
        result = instance.array667(numbers6);
        assertEquals(expResult, result);
        
        int[] numbers7 = {6, 6, 6, 6};
        expResult = 3;
        result = instance.array667(numbers7);
        assertEquals(expResult, result);
    }

}