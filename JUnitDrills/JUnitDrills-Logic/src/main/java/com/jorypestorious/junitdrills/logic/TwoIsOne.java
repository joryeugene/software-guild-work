package com.jorypestorious.junitdrills.logic;

public class TwoIsOne {
    
//    Given three ints, a b c, return true if it is possible to add two of the ints to get the third. 
//
//twoIsOne(1, 2, 3) → true
//twoIsOne(3, 1, 2) → true
//twoIsOne(3, 2, 2) → false

    public boolean twoIsOne(int a, int b, int c) {
        
        if (a+b==c || a+c==b || b+c==a) return true;
        return false;
        
    }


}
