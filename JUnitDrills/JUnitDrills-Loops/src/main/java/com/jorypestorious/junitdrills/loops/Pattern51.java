package com.jorypestorious.junitdrills.loops;

public class Pattern51 {
//Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a value,
    //followed by the value plus 5, followed by the value minus 1.
//
//pattern51({1, 2, 7, 1}) -> true
//pattern51({1, 2, 8, 1}) -> false
//pattern51({2, 7, 1}) -> true
//pattern51({2, 7, 3, 8, 2}) -> true
    //pattern51({2, 7}) -> false

    public boolean pattern51(int[] numbers) {
        if (numbers.length < 3) return false;
        for (int i = 0; i < numbers.length-2; i++) {
            if (numbers[i]+5==numbers[i+1] && numbers[i]-1==numbers[i+2]) return true;
        }
        return false;
    }

}
