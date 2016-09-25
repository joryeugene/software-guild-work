package com.jorypestorious.junitdrills.strings;

public class EndsWithLy {
//Given a String, return true if it ends in "ly". 
//
//endsWithLy("oddly") -> true
//endsWithLy("y") -> false
//endsWithLy("oddy") -> false

    public boolean endsWithLy(String str) {
        if (str.length() < 2) return false;
        return str.substring(str.length()-2).equals("ly");
    }

}
