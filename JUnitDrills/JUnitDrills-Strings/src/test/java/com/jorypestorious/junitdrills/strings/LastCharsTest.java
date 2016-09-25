
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class LastCharsTest {

//lastChars("last", "chars") -> "ls"
//lastChars("yo", "mama") -> "ya"
//lastChars("hi", "") -> "h@"

    @Test
    public void testLastChars() {
        System.out.println("lastChars");
        String str1 = "last";
        String str2 = "chars";
        LastChars instance = new LastChars();
        String expResult = "ls";
        String result = instance.lastChars(str1, str2);
        assertEquals(expResult, result);
        
        str1 = "yo";
        str2 = "mama";
        expResult = "ya";
        result = instance.lastChars(str1, str2);
        assertEquals(expResult, result);
        
        str1 = "hi";
        str2 = "";
        expResult = "h@";
        result = instance.lastChars(str1, str2);
        assertEquals(expResult, result);
    }

}