package com.jorypestorious.junitdrills.strings;

public class TweakFront {

//Given a String, return a version without the first 2 chars. Except keep the first char 
//if it is 'a' and keep the second char if it is 'b'. The String may be any length.
//
//tweakFront("Hello") -> "llo"
//tweakFront("away") -> "aay"
//tweakFront("abed") -> "abed"

    public String tweakFront(String str) {
        String result = "";
        if (str.length() < 1) return str;
        if (str.charAt(0) == 'a') result+= str.charAt(0);
        if (str.length() < 2) return result;
        if (str.charAt(1) == 'b') result+= str.charAt(1);
        return result + str.substring(2);
    }

}
