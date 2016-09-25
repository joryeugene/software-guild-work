package com.jorypestorious.junitdrills.strings;

public class TakeTwoFromPosition {
//Given a String and an index, return a String length 2 starting at the given index. 
    //If the index is too big or too small to define a String length 2, use the first 2 chars. The String length will be at least 2. 
//
//takeTwoFromPosition("java", 0) -> "ja"
//takeTwoFromPosition("java", 2) -> "va"
//takeTwoFromPosition("java", 3) -> "ja"

    public String takeTwoFromPosition(String str, int n) {
        if (str.length()-2 < n) return str.substring(0,2);
        return str.substring(n,n+2);
    }

}
