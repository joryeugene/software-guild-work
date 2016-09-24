package com.jorypestorious.junitdrills.logic;

public class AreInOrder {
    
//    Given three ints, a b c, return true if b is greater than a, and c is greater than b. 
    //However, with the exception that if "bOk" is true, b does not need to be greater than a. 


    public boolean areInOrder(int a, int b, int c, boolean bOk) {
        if (bOk) {
            if (c > b) return true;
        } else {
            if (c > b && b > a) return true;
        }
        return false;
    }


}
