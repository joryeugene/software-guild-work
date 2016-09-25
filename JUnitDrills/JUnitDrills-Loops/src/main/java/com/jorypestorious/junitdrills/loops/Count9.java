package com.jorypestorious.junitdrills.loops;

public class Count9 {
//Given an array of ints, return the number of 9's in the array. 
//
//count9({1, 2, 9}) -> 1
//count9({1, 9, 9}) -> 2
//count9({1, 9, 9, 3, 9}) -> 3

    public int count9 (int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 9) count++;
        }
        return count;
    }

}
