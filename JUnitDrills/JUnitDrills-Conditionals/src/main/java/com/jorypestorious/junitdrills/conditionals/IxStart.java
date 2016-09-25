package com.jorypestorious.junitdrills.conditionals;

public class IxStart {
//Return true if the given String begins with "*ix", the '*' can be anything, so "pix", "9ix" .. all count. 
//
//ixStart("mix snacks") -> true
//ixStart("pix snacks") -> true
//ixStart("piz snacks") -> false

    public boolean ixStart(String str) {
        if (str.length() < 3) return false;
        return str.indexOf("ix") == 1;
    }

}
