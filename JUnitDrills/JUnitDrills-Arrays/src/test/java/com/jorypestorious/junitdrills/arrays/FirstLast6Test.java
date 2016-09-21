
package com.jorypestorious.junitdrills.arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FirstLast6Test {
    
    private FirstLast6 f;
    
    @Before
    public void setUp() {
        f = new FirstLast6();
    }
    
    @After
    public void tearDown() {
        f = null;
    }
    
    @Test
    public void test() {
        
        int[] test1 = {1,2,6};
        int[] test2 = {6, 1, 2, 3};
        int[] test3 = {13, 6, 1, 2, 3};
        
        assertTrue(f.firstLast6(test1));
        assertTrue(f.firstLast6(test2));
        assertFalse(f.firstLast6(test3));
        
    }
    
}
