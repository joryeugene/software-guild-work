package com.jorypestorious.junitdrills.arrays;

public class HigherWins {
    
//    Given an array of ints, figure out which is larger between the first and last elements in the array, 
    //and set all the other elements to be that value. Return the changed array. 
//    
//    higherWins({1, 2, 3}) -> {3, 3, 3}
//    higherWins({11, 5, 9}) -> {11, 11, 11}
//    higherWins({2, 11, 3}) -> {3, 3, 3}
    
    public int[] higherWins(int[] numbers) {
        
        int highestNum = (numbers[0] > numbers[numbers.length-1]) ? numbers[0] : numbers[numbers.length-1];
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = highestNum;
        }
        
        return numbers;
        
        
    }

}
