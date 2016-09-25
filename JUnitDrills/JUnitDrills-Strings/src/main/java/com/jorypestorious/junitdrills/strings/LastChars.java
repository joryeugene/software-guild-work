package com.jorypestorious.junitdrills.strings;

public class LastChars {
//Given 2 Strings, a and b, return a new String made of the first char of a and 
    //the last char of b, so "yo" and "java" yields "ya". If either String is length 0, use '@' for its missing char. 
//
//lastChars("last", "chars") -> "ls"
//lastChars("yo", "mama") -> "ya"
//lastChars("hi", "") -> "h@"

    public String lastChars(String str1, String str2) {
        if (str1.length() == 0) str1 = "@";
        if (str2.length() == 0) str2 = "@";
        return ""+str1.charAt(0)+str2.charAt(str2.length()-1);
    }

}
