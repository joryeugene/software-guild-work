package com.jorypestorious.junitdrills.logic;

public class Mod20 {
//    
//    Return true if the given non-negative number is 1 or 2 more than a multiple of 20. See also: Introduction to Mod 
//
//mod20(20) → false
//mod20(21) → true
//mod20(22) → true

    public boolean mod20(int n) {
        
        if (n % 20 == 1 || n % 20 == 2) return true;
        return false;
        
    }


}
