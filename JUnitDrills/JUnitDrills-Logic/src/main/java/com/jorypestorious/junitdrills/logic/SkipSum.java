package com.jorypestorious.junitdrills.logic;

public class SkipSum {
    
//    Given 2 ints, a and b, return their sum. 
    //However, sums in the range 10..19 inclusive are forbidden, so in that case just return 20. 
//
//skipSum(3, 4) → 7
//skipSum(9, 4) → 20
//skipSum(10, 11) → 21

    public int skipSum(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 19) return 20;
        return sum;
        
    }


}
