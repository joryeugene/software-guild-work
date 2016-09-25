
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountXXTest {

//
//countXX("abcxx") -> 1
//countXX("xxx") -> 2
//countXX("xxxx") -> 3

    @Test
    public void testCountXX() {
        System.out.println("countXX");
        String str = "abcxx";
        CountXX instance = new CountXX();
        int expResult = 1;
        int result = instance.countXX(str);
        assertEquals(expResult, result);
        
        str = "xxx";
        expResult = 2;
        result = instance.countXX(str);
        assertEquals(expResult, result);
        
        str = "x";
        expResult = 0;
        result = instance.countXX(str);
        assertEquals(expResult, result);
        
        str = "xxxx";
        expResult = 3;
        result = instance.countXX(str);
        assertEquals(expResult, result);
    }

}