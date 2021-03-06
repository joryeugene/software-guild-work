package com.jorypestorious.junitdrills.strings;

public class AtFirst {
//Given a String, return a String length 2 made of its first 2 chars. If the String length is less than 2, use '@' for the missing chars. 
//
//atFirst("hello") -> "he"
//atFirst("hi") -> "hi"
//atFirst("h") -> "h@"

    public String atFirst(String str) {
        if (str.length() == 0) return "@@";
        if (str.length() == 1) return str.charAt(0) + "@";
        return str.substring(0,2);
    }

}
