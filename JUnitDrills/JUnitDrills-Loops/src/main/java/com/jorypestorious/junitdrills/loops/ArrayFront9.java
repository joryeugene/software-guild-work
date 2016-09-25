package com.jorypestorious.junitdrills.loops;

public class ArrayFront9 {
//Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4. 
//
//arrayFront9({1, 2, 9, 3, 4}) -> true
//arrayFront9({1, 2, 3, 4, 9}) -> false
//arrayFront9({1, 2, 3, 4, 5}) -> false
    //arrayFront9({9}) -> true
    //arrayFront9({1}) -> false

    public boolean arrayFront9(int[] numbers) {
        int limit = (numbers.length >= 4) ? 4 : numbers.length;
        for (int i = 0; i < limit; i++) {
            if (numbers[i] == 9) return true;
        }
        return false;
    }

}
