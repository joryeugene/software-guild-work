
package com.jorypestorious.junitdrills.arrays;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.IsEqual.equalTo;
import org.junit.Test;
import static org.junit.Assert.*;

public class RotateLeftTest {
    
    //rotateLeft({1, 2, 3}) -> {2, 3, 1}
//rotateLeft({5, 11, 9}) -> {11, 9, 5}
//rotateLeft({7, 0, 0}) -> {0, 0, 7}
    
    @Test
    public void test() {
        RotateLeft r = new RotateLeft();
        
        int[] test1 = {1,2,3};
        int[] test2 = {2,3,1};
        int[] test3 = {15,22,3,4,55};
        int[] test4 = {22,3,4,55,15};
        int[] test5 = {17,0,0};
        int[] test6 = {0,0,17};
        
        assertArrayEquals(test2, r.rotateLeft(test1));
        assertArrayEquals(test4, r.rotateLeft(test3));
        assertArrayEquals(test6, r.rotateLeft(test5));
        assertThat(test1, not(equalTo( r.rotateLeft(test2) )));
        
    }
    
}
