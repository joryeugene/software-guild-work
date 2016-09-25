
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayFront9Test {

//arrayFront9({1, 2, 9, 3, 4}) -> true
//arrayFront9({1, 2, 3, 4, 9}) -> false
//arrayFront9({1, 2, 3, 4, 5}) -> false
    //arrayFront9({9}) -> true
    //arrayFront9({1}) -> false

    @Test
    public void testArrayFront9() {
        System.out.println("arrayFront9");
        int[] numbers = {1, 2, 9, 3, 4};
        ArrayFront9 instance = new ArrayFront9();
        boolean expResult = true;
        boolean result = instance.arrayFront9(numbers);
        assertEquals(expResult, result);
        
        int[] numbers2 = {1, 2, 3, 4, 9};
        expResult = false;
        result = instance.arrayFront9(numbers2);
        assertEquals(expResult, result);
        
        int[] numbers3 = {1, 2, 3, 4, 5};
        expResult = false;
        result = instance.arrayFront9(numbers3);
        assertEquals(expResult, result);
        
        int[] numbers4 = {9};
        expResult = true;
        result = instance.arrayFront9(numbers4);
        assertEquals(expResult, result);
        
        int[] numbers5 = {1};
        expResult = false;
        result = instance.arrayFront9(numbers5);
        assertEquals(expResult, result);
    }

}