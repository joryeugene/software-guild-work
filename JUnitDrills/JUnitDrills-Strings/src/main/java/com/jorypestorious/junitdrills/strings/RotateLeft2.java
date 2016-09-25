package com.jorypestorious.junitdrills.strings;

public class RotateLeft2 {
//Given a String, return a "rotated left 2" version where the first 2 chars are moved to the end. The String length will be at least 2. 
//
//rotateLeft2("Hello") -> "lloHe"
//rotateLeft2("java") -> "vaja"
//rotateLeft2("Hi") -> "Hi"

    public String rotateLeft2(String str) {
        if (str.length() <3) return str;
        return str.substring(2) + str.substring(0,2);
    }

}
