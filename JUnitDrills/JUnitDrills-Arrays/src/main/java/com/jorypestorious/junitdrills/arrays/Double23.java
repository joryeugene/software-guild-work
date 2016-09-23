package com.jorypestorious.junitdrills.arrays;

public class Double23 {
    
//    Given an int array, return true if the array contains 2 twice, or 3 twice. 
//
//    double23({2, 2, 3}) -> true
//    double23({3, 4, 5, 3}) -> true
//    double23({2, 3, 2, 2}) -> false

    public boolean double23(int[] numbers) {
        
        boolean twice = false;
        int count2 = 0;
        int count3 = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 2) count2++;
            if (numbers[i] == 3) count3++;
        }
        
        if (count2 == 2 || count3 == 2) twice = true;
        
        return twice;

    }

}
