package com.jorypestorious.junitdrills.strings;

public class FrontAndBack {
//Given a String and an int n, return a String made of the first and last n chars from the String. The String length will be at least n. 
//
//frontAndBack("Hello", 2) -> "Helo"
//frontAndBack("Chocolate", 3) -> "Choate"
//frontAndBack("Chocolate", 1) -> "Ce"

    public String frontAndBack(String str, int n) {
        if (str.length() <= n) return str;
        return str.substring(0,n) + str.substring(str.length()-n);
    }

}
