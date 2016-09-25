package com.jorypestorious.junitdrills.loops;

public class Array123 {
//Given an array of ints, return true if .. 1, 2, 3, .. appears in the array somewhere. 
//
//array123({1, 1, 2, 3, 1}) -> true
//array123({1, 1, 2, 4, 1}) -> false
//array123({1, 1, 2, 1, 2, 3}) -> true
    //array123({1, 2, 3}) -> true
    //array123({1}) -> false

    public boolean array123(int[] numbers) {
        if (numbers.length < 3) return false;
        for (int i = 0; i < numbers.length-2; i++) {
            if (numbers[i] == 1 && numbers[i+1] == 2 && numbers[i+2] == 3) return true;
        }
        return false;
    }

}
