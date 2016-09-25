
package com.jorypestorious.junitdrills.strings;

import org.junit.Test;
import static org.junit.Assert.*;

public class MakeTagsTest {

//makeTags("i", "Yay") -> "<i>Yay</i>"
//makeTags("i", "Hello") -> "<i>Hello</i>"
//makeTags("cite", "Yay") -> "<cite>Yay</cite>"

    @Test
    public void testMakeTags() {
        System.out.println("makeTags");
        String tag = "i";
        String content = "Yay";
        MakeTags instance = new MakeTags();
        String expResult = "<i>Yay</i>";
        String result = instance.makeTags(tag, content);
        assertEquals(expResult, result);
        
        tag = "i";
        content = "Hello";
        expResult = "<i>Hello</i>";
        result = instance.makeTags(tag, content);
        assertEquals(expResult, result);
        
        tag = "cite";
        content = "Yay";
        expResult = "<cite>Yay</cite>";
        result = instance.makeTags(tag, content);
        assertEquals(expResult, result);
    }

}