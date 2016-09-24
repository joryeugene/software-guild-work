
package com.jorypestorious.junitdrills.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class RollDiceTest {

//rollDice(2, 3, true) → 5
//rollDice(3, 3, true) → 7
//rollDice(6, 6, true) → 7
//rollDice(3, 3, false) → 6

    @Test
    public void testRollDice() {
        System.out.println("rollDice");
        int die1 = 2;
        int die2 = 3;
        boolean noDoubles = true;
        RollDice instance = new RollDice();
        int expResult = 5;
        int result = instance.rollDice(die1, die2, noDoubles);
        assertEquals(expResult, result);
        
        die1 = 3;
        die2 = 3;
        noDoubles = true;
        expResult = 7;
        result = instance.rollDice(die1, die2, noDoubles);
        assertEquals(expResult, result);
        
        die1 = 6;
        die2 = 6;
        noDoubles = true;
        expResult = 7;
        result = instance.rollDice(die1, die2, noDoubles);
        assertEquals(expResult, result);
        
        die1 = 3;
        die2 = 3;
        noDoubles = false;
        expResult = 6;
        result = instance.rollDice(die1, die2, noDoubles);
        assertEquals(expResult, result);
    }

}