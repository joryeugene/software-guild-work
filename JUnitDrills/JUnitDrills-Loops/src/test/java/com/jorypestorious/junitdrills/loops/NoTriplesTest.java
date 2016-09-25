
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class NoTriplesTest {

//noTriples({1, 1, 2, 2, 1}) -> true
//noTriples({1, 1, 2, 2, 2, 1}) -> false
//noTriples({1, 1, 1, 2, 2, 2, 1}) -> false

    @Test
    public void testNoTriples() {
        System.out.println("noTriples");
        int[] numbers = {1, 1, 2, 2, 1};
        NoTriples instance = new NoTriples();
        boolean expResult = true;
        boolean result = instance.noTriples(numbers);
        assertEquals(expResult, result);
        
        int[] numbers2 = {1, 1, 2, 2, 2, 1};
        expResult = false;
        result = instance.noTriples(numbers2);
        assertEquals(expResult, result);
        
        int[] numbers3 = {1, 1, 1, 2, 2, 2, 1};
        expResult = false;
        result = instance.noTriples(numbers3);
        assertEquals(expResult, result);
        
        int[] numbers4 = {1, 1};
        expResult = true;
        result = instance.noTriples(numbers4);
        assertEquals(expResult, result);
    }

}