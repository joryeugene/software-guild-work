package com.jorypestorious.junitdrills.loops;

public class DoubleX {
//Given a String, return true if the first instance of "x" in the String is immediately followed by another "x". 
//
//doubleX("axxbb") -> true
//doubleX("axaxxax") -> false
//doubleX("xxxxx") -> true

    public boolean doubleX(String str) {
        if (str.length() < 2) return false;
        int index = str.indexOf("x");
        if (index == -1) return false;
        return str.substring(index).startsWith("xx");
    }

}
