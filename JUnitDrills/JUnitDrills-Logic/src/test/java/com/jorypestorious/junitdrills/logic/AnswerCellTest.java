
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class AnswerCellTest {

//answerCell(false, false, false) → true
//answerCell(false, false, true) → false
//answerCell(true, false, false) → false

    @Test
    public void testAnswerCell() {
        System.out.println("answerCell");
        boolean isMorning = false;
        boolean isMom = false;
        boolean isAsleep = false;
        AnswerCell instance = new AnswerCell();
        boolean expResult = true;
        boolean result = instance.answerCell(isMorning, isMom, isAsleep);
        assertEquals(expResult, result);
        
        isMorning = false;
        isMom = false;
        isAsleep = true;
        expResult = false;
        result = instance.answerCell(isMorning, isMom, isAsleep);
        assertEquals(expResult, result);
        
        isMorning = true;
        isMom = false;
        isAsleep = false;
        expResult = false;
        result = instance.answerCell(isMorning, isMom, isAsleep);
        assertEquals(expResult, result);
    }

}