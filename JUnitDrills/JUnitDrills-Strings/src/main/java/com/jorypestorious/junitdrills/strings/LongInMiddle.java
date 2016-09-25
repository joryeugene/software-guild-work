package com.jorypestorious.junitdrills.strings;

public class LongInMiddle {
//Given 2 Strings, a and b, return a String of the form short+long+short, 
    //with the shorter String on the outside and the longer String on the inside. 
    //The Strings will not be the same length, but they may be empty (length 0). 
//
//longInMiddle("Hello", "hi") -> "hiHellohi"
//longInMiddle("hi", "Hello") -> "hiHellohi"
//longInMiddle("aaa", "b") -> "baaab"

    public String longInMiddle(String a, String b) {
        String middle = (a.length() > b.length()) ? a : b;
        String out = (a.length() < b.length()) ? a : b;
        return out+middle+out;
    }

}
