package com.jorypestorious.junitdrills.arrays;

public class RotateLeft {
//Given an array of ints, return an array with the elements "rotated left" so {1, 2, 3} yields {2, 3, 1}. 
//
//rotateLeft({1, 2, 3}) -> {2, 3, 1}
//rotateLeft({5, 11, 9}) -> {11, 9, 5}
//rotateLeft({7, 0, 0}) -> {0, 0, 7}

    public int[] rotateLeft(int[] numbers) {
        
        int temp = numbers[0];
               
        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length-1) {
                numbers[i] = temp;
            } else {
                numbers[i] = numbers[i+1];
            }
        }
        
        return numbers;
    }
}
