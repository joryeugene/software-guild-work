package com.jorypestorious.junitdrills.logic;

public class LoveSix {
    
//    The number 6 is a truly great number. Given two int values, a and b, return true if either one is 6. 
    //Or if their sum or difference is 6.
//
//loveSix(6, 4) → true
//loveSix(4, 5) → false
//loveSix(1, 5) → true

    public boolean loveSix(int a, int b) {
        int sum = a + b;
        int diff = Math.abs(a-b);
        
        if (sum == 6 || diff == 6 || a == 6 || b == 6 ) return true;
        return false;
        
    }


}
