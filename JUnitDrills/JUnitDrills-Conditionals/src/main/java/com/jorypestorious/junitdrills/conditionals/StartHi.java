package com.jorypestorious.junitdrills.conditionals;

public class StartHi {
//Given a String, return true if the String starts with "hi" and false otherwise. 
//
//startHi("hi there") -> true
//startHi("hi") -> true
//startHi("high up") -> false

    public boolean startHi(String str) {
        if (str.length() < 2) return false;
        if (str.indexOf("hi") == 0 && str.length() == 2) return true;
        if (str.length() < 3) return false;
        if (str.indexOf("hi ") == 0) return true;
        return false;
    }

}
