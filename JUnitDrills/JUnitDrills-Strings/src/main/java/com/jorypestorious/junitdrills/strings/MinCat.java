package com.jorypestorious.junitdrills.strings;

public class MinCat {
//Given two Strings, append them together (known as "concatenation") and return the result. 
    //However, if the Strings are different lengths, omit chars from the longer String 
    //so it is the same length as the shorter String. So "Hello" and "Hi" yield "loHi". The Strings may be any length. 
//
//minCat("Hello", "Hi") -> "loHi"
//minCat("Hello", "java") -> "ellojava"
//minCat("java", "Hello") -> "javaello"

    public String minCat(String a, String b) {
        int min = (a.length() < b.length()) ? a.length() : b.length();
        return a.substring(a.length()-min) + b.substring(b.length()-min);
    }

}
