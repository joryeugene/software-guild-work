package com.jorypestorious.junitdrills.strings;

public class SwapLast {
//Given a String of any length, return a new String where the last 2 chars, if present, are swapped, so "coding" yields "codign". 
//
//swapLast("coding") -> "codign"
//swapLast("cat") -> "cta"
//swapLast("ab") -> "ba"

    public String swapLast(String str) {
        if (str.length() < 2) return str;
        return str.substring(0,str.length()-2) + str.charAt(str.length()-1) + str.charAt(str.length()-2);
    }

}
