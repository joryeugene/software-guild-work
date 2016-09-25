package com.jorypestorious.junitdrills.conditionals;

public class MischeviousChildren {
//We have two children, a and b, and the parameters aSmile and bSmile indicate if each is smiling. 
    //We are in trouble if they are both smiling or if neither of them is smiling. Return true if we are in trouble. 
//
//areWeInTrouble(true, true) -> true
//areWeInTrouble(false, false) -> true
//areWeInTrouble(true, false) -> false

    public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
        if (aSmile && bSmile || !aSmile && !bSmile) return true;
        return false;
    }

}
