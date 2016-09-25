package com.jorypestorious.junitdrills.loops;

public class Array667 {
//Given an array of ints, return the number of times that two 6's are next to each other in the array. 
    //Also count instances where the second "6" is actually a 7. 
//
//array667({6, 6, 2}) -> 1
//array667({6, 6, 2, 6}) -> 1
//array667({6, 7, 2, 6}) -> 1
    //array667({6}) -> 0
    //array667({6, 7, 6, 0}) -> 1
    //array667({6, 7, 6, 6}) -> 2

    public int array667(int[] numbers) {
        int count = 0;
        if (numbers.length < 2) return count;
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] == 6 && numbers[i+1] == 6 || numbers[i+1] == 7) count++;
        }
        return count;
    }

}
