
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class Count9Test {

//
//count9({1, 2, 9}) -> 1
//count9({1, 9, 9}) -> 2
//count9({1, 9, 9, 3, 9}) -> 3

    @Test
    public void testCount9() {
        System.out.println("count9");
        int[] numbers = {1, 2, 9};
        Count9 instance = new Count9();
        int expResult = 1;
        int result = instance.count9(numbers);
        assertEquals(expResult, result);
        
        int[] numbers2 = {1, 9, 9};
        expResult = 2;
        result = instance.count9(numbers2);
        assertEquals(expResult, result);
        
        int[] numbers3 = {1, 9, 9, 3, 9};
        expResult = 3;
        result = instance.count9(numbers3);
        assertEquals(expResult, result);
    }

}