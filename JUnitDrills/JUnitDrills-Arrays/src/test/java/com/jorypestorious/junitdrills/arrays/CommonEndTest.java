package com.jorypestorious.junitdrills.arrays;

import static org.junit.Assert.*;
import org.junit.Test;

public class CommonEndTest {
    
    //commonEnd({1, 2, 3}, {7, 3}) -> true
//commonEnd({1, 2, 3}, {7, 3, 2}) -> false
//commonEnd({1, 2, 3}, {1, 3}) -> true

    
    @Test
    public void test() {
        
        CommonEnd ce = new CommonEnd();
        int[] test1 = {1, 2, 3};
        int[] test2 = {7, 3};
        int[] test3 = {7, 3, 2};
        int[] test4 = {1, 3};
        
        assertTrue(ce.commonEnd(test1, test2));
        assertFalse(ce.commonEnd(test1, test3));
        assertTrue(ce.commonEnd(test1, test4));
    }
    
}

