
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class CanHazTableTest {

//
//canHazTable(5, 10) → 2
//canHazTable(5, 2) → 0
//canHazTable(5, 5) → 1

    @Test
    public void testCanHazTable() {
        System.out.println("canHazTable");
        int yourStyle = 5;
        int dateStyle = 10;
        CanHazTable instance = new CanHazTable();
        int expResult = 2;
        int result = instance.canHazTable(yourStyle, dateStyle);
        assertEquals(expResult, result);
        
        dateStyle = 2;
        expResult = 0;
        result = instance.canHazTable(yourStyle, dateStyle);
        assertEquals(expResult, result);
        
        dateStyle = 5;
        expResult = 1;
        result = instance.canHazTable(yourStyle, dateStyle);
        assertEquals(expResult, result);
    }

}