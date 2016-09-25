package com.jorypestorious.junitdrills.conditionals;

public class FrontBack {
//Given a String, return a new String where the first and last chars have been exchanged. 
//
//frontBack("code") -> "eodc"
//frontBack("a") -> "a"
//frontBack("ab") -> "ba"

    public String frontBack(String str) {
        if (str.length() < 2) return str;
        return str.charAt(str.length()-1) + str.substring(1,str.length()-1) + str.charAt(0);
    }

}
