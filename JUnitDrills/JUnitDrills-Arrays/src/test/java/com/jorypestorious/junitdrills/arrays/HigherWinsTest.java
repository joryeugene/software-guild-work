/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorypestorious.junitdrills.arrays;

import org.junit.Test;
import static org.junit.Assert.*;

public class HigherWinsTest {
    
    //    higherWins({1, 2, 3}) -> {3, 3, 3}
//    higherWins({11, 5, 9}) -> {11, 11, 11}
//    higherWins({2, 11, 3}) -> {3, 3, 3}

    @Test
    public void testHigherWins() {
        System.out.println("higherWins");
        int[] numbers = {1, 2, 3};
        HigherWins instance = new HigherWins();
        int[] expResult = {3, 3, 3};
        int[] result = instance.higherWins(numbers);
        assertArrayEquals(expResult, result);
        
        int[] numbers2 = {11, 5, 9};
        int[] expResult2 = {11, 11, 11};
        int[] result2 = instance.higherWins(numbers2);
        assertArrayEquals(expResult2, result2);
    }
    
}
