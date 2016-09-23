package com.jorypestorious.junitdrills.arrays;

public class Unlucky1 {
    
//    We'll say that a 1 immediately followed by a 3 in an array is an "unlucky" 1. 
//    Return true if the given array contains an unlucky 1 in the first 2 or last 2 positions in the array.
//    
//    unlucky1({1, 3, 4, 5}) -> true
//    unlucky1({2, 1, 3, 4, 5}) -> true
//    unlucky1({1, 1, 1}) -> false
    
    public boolean unlucky1(int[] numbers) {
        
        if (numbers.length < 2) return false;
        if (numbers[numbers.length-2] == 1 && numbers[numbers.length-1] == 3) return true;
        if (numbers.length < 3) return false;
        
        boolean prev1 = false;
        
        for (int i = 0; i < 3; i++) {
            if (prev1 && numbers[i] == 3) {
                return true;
            } else if (numbers[i] == 1) {
                prev1 = true;
            } else {
                prev1 = false;
            }
        }
        
        return false;
    }
}
