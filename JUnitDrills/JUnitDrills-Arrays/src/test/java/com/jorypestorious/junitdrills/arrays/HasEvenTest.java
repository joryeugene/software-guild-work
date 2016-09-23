
package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class HasEvenTest {

    //    hasEven({2, 5}) -> true
//    hasEven({4, 3}) -> true
//    hasEven({7, 5}) -> false

    @Test
    public void testHasEven() {
        System.out.println("hasEven");
        int[] numbers = {2, 5};
        HasEven instance = new HasEven();
        boolean expResult = true;
        boolean result = instance.hasEven(numbers);
        assertEquals(expResult, result);
        
        int[] numbers2 = {2, 5};
        result = instance.hasEven(numbers2);
        assertEquals(expResult, result);
        
        int[] numbers3 = {7, 5};
        expResult = false;
        result = instance.hasEven(numbers3);
        assertEquals(expResult, result);
    }

}