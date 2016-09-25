
package com.jorypestorious.junitdrills.loops;

import org.junit.Test;
import static org.junit.Assert.*;

public class AltPairsTest {

//altPairs("kitten") -> "kien"
//altPairs("Chocolate") -> "Chole"
//altPairs("CodingHorror") -> "Congrr"
    //altPairs("C") -> "C"

    @Test
    public void testAltPairs() {
        System.out.println("altPairs");
        String str = "kitten";
        AltPairs instance = new AltPairs();
        String expResult = "kien";
        String result = instance.altPairs(str);
        assertEquals(expResult, result);
        
        str = "Chocolate";
        expResult = "Chole";
        result = instance.altPairs(str);
        assertEquals(expResult, result);
        
        str = "CodingHorror";
        expResult = "Congrr";
        result = instance.altPairs(str);
        assertEquals(expResult, result);
        
        str = "C";
        expResult = "C";
        result = instance.altPairs(str);
        assertEquals(expResult, result);
    }

}