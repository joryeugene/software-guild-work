package com.jorypestorious.junitdrills.arrays;

public class KeepLast {
    
//    Given an int array, return a new array with double the length where its last element 
    //is the same as the original array, and all the other elements are 0. 
    //The original array will be length 1 or more. Note: by default, a new int array contains all 0's. 
//
//    keepLast({4, 5, 6}) -> {0, 0, 0, 0, 0, 6}
//    keepLast({1, 2}) -> {0, 0, 0, 2}
//    keepLast({3}) -> {0, 3}
    
    public int[] keepLast(int[] numbers) {
        int[] result = new int[numbers.length * 2];
        result[result.length-1] = numbers[numbers.length-1];
        return result;
    }

}
