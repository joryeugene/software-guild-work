package com.jorypestorious.junitdrills.logic;

public class LastDigit {
    
//    Given three ints, a b c, return true if two or more of them have the same rightmost digit. The ints are non-negative. 
//
//lastDigit(23, 19, 13) → true
//lastDigit(23, 19, 12) → false
//lastDigit(23, 19, 3) → true

    public boolean lastDigit(int a, int b, int c) {
        a %= 10;
        b %= 10;
        c %= 10;
        if (a==b||a==c||b==c) return true;
        return false;
    }


}
