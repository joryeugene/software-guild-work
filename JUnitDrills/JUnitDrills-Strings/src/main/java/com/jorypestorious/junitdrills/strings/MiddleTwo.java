package com.jorypestorious.junitdrills.strings;

public class MiddleTwo {
//Given a String of even length, return a String made of the middle two chars,
    //so the String "String" yields "ri". The String length will be at least 2. 
//
//middleTwo("String") -> "ri"
//middleTwo("code") -> "od"
//middleTwo("Practice") -> "ct"

    public String middleTwo(String str ) {
        if (str.length() < 3) return str;
        int index = (str.length()/2)-1;
        return str.substring(index,index+2);
    }

}
