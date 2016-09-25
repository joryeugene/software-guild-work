package com.jorypestorious.junitdrills.loops;

public class StringX {
//Given a String, return a version where all the "x" have been removed. Except an "x" at the very start or end should not be removed. 
//
//stringX("xxHxix") -> "xHix"
//stringX("abxxxcd") -> "abcd"
//stringX("xabxxxcdx") -> "xabcdx"
//stringX("ax") -> "ax"
    //stringX("a") -> "a"

    public String stringX(String str) {
        if (str.length() < 3) return str;
        String mid = "";
        for (int i = 1; i < str.length()-1; i++) {
            if (str.charAt(i) != 'x') mid+=str.charAt(i);
        }
        return str.charAt(0) + mid + str.charAt(str.length()-1);
    }

}
