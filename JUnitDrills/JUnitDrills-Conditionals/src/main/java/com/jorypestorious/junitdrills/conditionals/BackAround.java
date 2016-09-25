package com.jorypestorious.junitdrills.conditionals;

public class BackAround {
//Given a String, take the last char and return a new String with the last char added at the front and back, 
    //so "cat" yields "tcatt". The original String will be length 1 or more. 
//
//backAround("cat") -> "tcatt"
//backAround("Hello") -> "oHelloo"
//backAround("a") -> "aaa"

    public String backAround(String str) {
        return str.charAt(str.length()-1) + str + str.charAt(str.length()-1);
    }

}
