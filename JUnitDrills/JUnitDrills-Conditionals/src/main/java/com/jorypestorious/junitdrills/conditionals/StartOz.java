package com.jorypestorious.junitdrills.conditionals;

public class StartOz {
//Given a String, return a String made of the first 2 chars (if present), 
    //however include first char only if it is 'o' and include the second only if it is 'z', so "ozymandias" yields "oz". 
//
//startOz("ozymandias") -> "oz"
//startOz("bzoo") -> "z"
//startOz("oxx") -> "o"

    public String startOz(String str) {
        if (str.length() < 1) return str;
        if (str.length() < 2 && str.charAt(0) == 'o') return "o";
        String result = "";
        if (str.charAt(0) == 'o') result += "o";
        if (str.charAt(1) == 'z') result += "z";
        return result;
    }

}
