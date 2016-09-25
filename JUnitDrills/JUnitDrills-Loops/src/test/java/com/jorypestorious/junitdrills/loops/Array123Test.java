
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class Array123Test {

//array123({1, 1, 2, 3, 1}) -> true
//array123({1, 1, 2, 4, 1}) -> false
//array123({1, 1, 2, 1, 2, 3}) -> true
    //array123({1, 2, 3}) -> true
    //array123({1}) -> false

    @Test
    public void testArray123() {
        System.out.println("array123");
        int[] numbers = {1, 1, 2, 3, 1};
        Array123 instance = new Array123();
        boolean expResult = true;
        boolean result = instance.array123(numbers);
        assertEquals(expResult, result);
        
        int[] numbers2 = {1, 1, 2, 4, 1};
        expResult = false;
        result = instance.array123(numbers2);
        assertEquals(expResult, result);
        
        int[] numbers3 = {1, 1, 2, 1, 2, 3};
        expResult = true;
        result = instance.array123(numbers3);
        assertEquals(expResult, result);
        
        int[] numbers4 = {1, 2, 3};
        expResult = true;
        result = instance.array123(numbers4);
        assertEquals(expResult, result);
        
        int[] numbers5 = {1};
        expResult = false;
        result = instance.array123(numbers5);
        assertEquals(expResult, result);
    }

}