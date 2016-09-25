package com.jorypestorious.junitdrills.strings;

public class StripX {
//Given a String, if the first or last chars are 'x', return the String without those 'x' chars, and otherwise return the String unchanged. 
//
//stripX("xHix") -> "Hi"
//stripX("xHi") -> "Hi"
//stripX("Hxix") -> "Hxi"

    public String stripX(String str) {
        if (str.length() < 1) return str;
        if (str.length() == 1 && str.charAt(0) == 'x') return "";
        if (str.length() < 2) return str;
        String result = "";
        if (str.charAt(0) != 'x') result += str.charAt(0);
        result += str.substring(1,str.length()-1);
        if (str.charAt(str.length()-1) != 'x') result += str.charAt(str.length()-1);
        return result;
    }

}
