package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class SumTest {
    
    //sum({1, 2, 3}) -> 6
//sum({5, 11, 2}) -> 18
//sum({7, 0, 0}) -> 7
    
    @Test
    public void testS() {
        
        Sum s = new Sum();
        
        int[] test1 = {1,2,3};
        int[] test2 = {5,11,2};
        int[] test3 = {7,0,0};
        
        assertEquals(s.sum(test1), 6);
        assertEquals(s.sum(test2), 18);
        assertEquals(s.sum(test3), 7);
        assertNotEquals(s.sum(test2), 17);
        
    }

}
