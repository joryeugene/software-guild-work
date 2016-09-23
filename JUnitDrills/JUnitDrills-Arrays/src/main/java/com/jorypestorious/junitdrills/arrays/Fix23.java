package com.jorypestorious.junitdrills.arrays;

public class Fix23 {
    
//    Given an int array length 3, if there is a 2 in the array immediately followed by a 3, 
    //set the 3 element to 0. Return the changed array. 
//
//    fix23({1, 2, 3}) ->{1, 2, 0}
//    fix23({2, 3, 5}) -> {2, 0, 5}
//    fix23({1, 2, 1}) -> {1, 2, 1}
    
    public int[] fix23(int[] numbers) {
        
        boolean previous2 = false;
        
        for (int i = 0; i < numbers.length; i++) {
            if (previous2 && numbers[i] == 3) {
                numbers[i] = 0;
                previous2 = false;
            } else if (numbers[i] == 2) {
                previous2 = true;
            } else {
                previous2 = false;
            }
        }
        
        return numbers;
        
    }

}
