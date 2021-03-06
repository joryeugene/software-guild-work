package com.jorypestorious.junitdrills.logic;

public class InRange {
    
//    Given a number n, return true if n is in the range 1..10, inclusive. 
    //Unless "outsideMode" is true, in which case return true if the number is less or equal to 1, or greater or equal to 10. 
//
//inRange(5, false) → true
//inRange(11, false) → false
//inRange(11, true) → true

    public boolean inRange(int n, boolean outsideMode) {
        
        if (outsideMode) {
            return n <= 1 || n >= 10;
        } else {
            return n >= 1 && n <= 10;
        }
        
    }


}
