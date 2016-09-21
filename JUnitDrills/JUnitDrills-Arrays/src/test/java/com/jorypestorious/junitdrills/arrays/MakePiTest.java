
package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class MakePiTest {
    
    @Test
    public void test() {
        
        MakePi m = new MakePi();
        
        int[] test1 = {};
        int[] test2 = {3, 1, 4};
        int[] test3 = {13, 6, 1, 2, 3};
        int[] test4 = {3,1,4,1,5,9,2,6,5,3,5};
        
        assertArrayEquals(test1, m.makePi(0));
        assertArrayEquals(test2, m.makePi(3));            
        assertNotEquals(test3, m.makePi(5));
        assertArrayEquals(test4, m.makePi(11)); 
    }
    
}

