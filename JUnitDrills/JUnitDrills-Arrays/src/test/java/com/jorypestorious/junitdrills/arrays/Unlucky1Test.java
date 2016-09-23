
package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class Unlucky1Test {

    //    unlucky1({1, 3, 4, 5}) -> true
//    unlucky1({2, 1, 3, 4, 5}) -> true
//    unlucky1({1, 1, 1}) -> false

    @Test
    public void testUnlucky1() {
        System.out.println("unlucky1");
        Unlucky1 instance = new Unlucky1();
        
        int[] numbers = {1, 3, 4, 5};
        boolean expResult = true;
        boolean result = instance.unlucky1(numbers);
        assertEquals(expResult, result);
        
        int[] numbers1 = {1, 3};
        result = instance.unlucky1(numbers1);
        assertEquals(expResult, result);
        
        int[] numbers2 = {2, 1, 3, 4, 5};
        result = instance.unlucky1(numbers2);
        assertEquals(expResult, result);
        
        int[] numbers3 = {2, 1, 5, 1, 3};
        result = instance.unlucky1(numbers3);
        assertEquals(expResult, result);
        
        int[] numbers4 = {1, 1, 1, 4, 5};
        expResult = false;
        result = instance.unlucky1(numbers4);
        assertEquals(expResult, result);
        
        int[] numbers44 = {1, 1, 1, 3, 5};
        result = instance.unlucky1(numbers44);
        assertEquals(expResult, result);
        
        int[] numbers5 = {};
        result = instance.unlucky1(numbers5);
        assertEquals(expResult, result);
        
        int[] numbers6 = {1};
        result = instance.unlucky1(numbers6);
        assertEquals(expResult, result);
        
        int[] numbers7 = {1,2};
        result = instance.unlucky1(numbers7);
        assertEquals(expResult, result);
    }

}