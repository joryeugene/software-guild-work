package com.jorypestorious.junitdrills.strings;

public class FrontAgain {
//Given a String, return true if the first 2 chars in the String also appear at the end of the String, such as with "edited". 
//
//frontAgain("edited") -> true
//frontAgain("edit") -> false
//frontAgain("ed") -> true

    public boolean frontAgain(String str) {
        if (str.length() < 2) return false;
        return str.substring(0,2).equals(str.substring(str.length()-2));
    }

}
