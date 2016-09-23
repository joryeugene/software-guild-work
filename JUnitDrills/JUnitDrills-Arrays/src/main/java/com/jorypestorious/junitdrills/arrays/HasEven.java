package com.jorypestorious.junitdrills.arrays;

public class HasEven {
    
//    Given an int array , return true if it contains an even number (HINT: Use Mod (%)). 
//
//    hasEven({2, 5}) -> true
//    hasEven({4, 3}) -> true
//    hasEven({7, 5}) -> false

    public boolean hasEven(int[] numbers) {
        
        boolean hasEven = false;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0 && numbers[i] != 0) hasEven = true;
        }
        
        return hasEven;

    }

}
