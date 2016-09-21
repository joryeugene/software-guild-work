
package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class SameFirstLastTest {
    
    @Test
    public void test() {
        
        SameFirstLast s = new SameFirstLast();
        
        int[] test1 = {};
        int[] test2 = {6, 1, 2, 6};
        int[] test3 = {13, 6, 1, 2, 3};
        
        assertFalse(s.sameFirstLast(test1));
        assertTrue(s.sameFirstLast(test2));
        assertFalse(s.sameFirstLast(test3));
        
    }
    
}

