package com.jorypestorious.junitdrills.strings;

public class RotateRight2 {
//Given a String, return a "rotated right 2" version where the last 2 chars are moved to the start. The String length will be at least 2. 
//
//rotateRight2("Hello") -> "loHel"
//rotateRight2("java") -> "vaja"
//rotateRight2("Hi") -> "Hi"

    public String rotateReft2(String str) {
        if (str.length() <3) return str;
        return str.substring(str.length()-2)+str.substring(0,str.length()-2);
    }

}
