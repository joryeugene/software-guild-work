package com.jorypestorious.junitdrills.conditionals;

public class MissingChar {
//Given a non-empty String and an int n, return a new String where the char at index n has been removed. 
    //The value of n will be a valid index of a char in the original String (Don't check for bad index). 
//
//missingChar("kitten", 1) -> "ktten"
//missingChar("kitten", 0) -> "itten"
//missingChar("kitten", 4) -> "kittn"
    
    public String missingChar(String str, int n) {
        return str.substring(0,n) + str.substring(n+1);
    }

}
