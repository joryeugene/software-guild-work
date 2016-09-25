package com.jorypestorious.junitdrills.conditionals;

public class SoAlone {
//We'll say that a number is "teen" if it is in the range 13..19 inclusive. 
    //Given 2 int values, return true if one or the other is teen, but not both. 
//
//soAlone(13, 99) -> true
//soAlone(21, 19) -> true
//soAlone(13, 13) -> false

    public boolean soAlone(int a, int b) {
        if (a>=13 && a<=19 && b>=13 && b<=19) return false;
        return a>=13 && a<=19 || b>=13 && b<=19;
    }

}
