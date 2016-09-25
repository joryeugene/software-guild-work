
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class SubStringMatchTest {

//subStringMatch("xxcaazz", "xxbaaz") -> 3
//subStringMatch("abc", "abc") -> 2
//subStringMatch("abc", "axc") -> 0
    //subStringMatch("abcook", "axcooking") -> 5
    //subStringMatch("a", "axcooking") -> 0

    @Test
    public void testSubStringMatch() {
        System.out.println("subStringMatch");
        String a = "xxcaazz";
        String b = "xxbaaz";
        SubStringMatch instance = new SubStringMatch();
        int expResult = 3;
        int result = instance.subStringMatch(a, b);
        assertEquals(expResult, result);
        
        a = "abc";
        b = "abc";
        expResult = 2;
        result = instance.subStringMatch(a, b);
        assertEquals(expResult, result);
        
        a = "abc";
        b = "axc";
        expResult = 0;
        result = instance.subStringMatch(a, b);
        assertEquals(expResult, result);
        
        a = "abcook";
        b = "abcooking";
        expResult = 5;
        result = instance.subStringMatch(a, b);
        assertEquals(expResult, result);
        
        a = "a";
        b = "abcooking";
        expResult = 0;
        result = instance.subStringMatch(a, b);
        assertEquals(expResult, result);
    }

}