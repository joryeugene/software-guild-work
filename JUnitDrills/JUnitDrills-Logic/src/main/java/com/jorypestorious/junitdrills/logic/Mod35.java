package com.jorypestorious.junitdrills.logic;

public class Mod35 {
    
//    Return true if the given non-negative number is a multiple of 3 or 5, but not both. Use the % "mod" operator
//
//mod35(3) → true
//mod35(10) → true
//mod35(15) → false

    public boolean mod35(int n) {
        
        if (n % 15 == 0) return false;
        if (n % 3 == 0 || n % 5 == 0) return true;
        return false;
    }


}
