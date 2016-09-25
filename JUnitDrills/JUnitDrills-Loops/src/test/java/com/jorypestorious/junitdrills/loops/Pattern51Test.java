
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class Pattern51Test {

//pattern51({1, 2, 7, 1}) -> true
//pattern51({1, 2, 8, 1}) -> false
//pattern51({2, 7, 1}) -> true
//pattern51({2, 7, 3, 8, 2}) -> true
    //pattern51({2, 7}) -> false

    @Test
    public void testPattern51() {
        System.out.println("pattern51");
        int[] numbers = {1, 2, 7, 1};
        Pattern51 instance = new Pattern51();
        boolean expResult = true;
        boolean result = instance.pattern51(numbers);
        assertEquals(expResult, result);
        
        int[] numbers2 = {1, 2, 8, 1};
        expResult = false;
        result = instance.pattern51(numbers2);
        assertEquals(expResult, result);
        
        int[] numbers3 = {2, 7, 1};
        expResult = true;
        result = instance.pattern51(numbers3);
        assertEquals(expResult, result);
        
        int[] numbers4 = {2, 7, 3, 8, 2};
        expResult = true;
        result = instance.pattern51(numbers4);
        assertEquals(expResult, result);
        
        int[] numbers5 = {2,7};
        expResult = false;
        result = instance.pattern51(numbers5);
        assertEquals(expResult, result);
    }

}