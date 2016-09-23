package com.jorypestorious.junitdrills.arrays;

public class Reverse {
    
    // Given an array of ints length 3, return a new array with the elements in reverse order, 
    // so for example {1, 2, 3} becomes {3, 2, 1}. {1,2,3,4} {4,3,2,1}
    
    public int[] reverse(int[] numbers) {
        
        int[] rev = new int[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            rev[i] = numbers[numbers.length-1-i];
        }
        
        return rev;
    }
    
}
