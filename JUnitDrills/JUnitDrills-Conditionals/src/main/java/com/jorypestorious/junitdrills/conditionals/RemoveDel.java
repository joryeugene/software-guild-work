package com.jorypestorious.junitdrills.conditionals;

public class RemoveDel {
//Given a String, if the String "del" appears starting at index 1, 
//return a String where that "del" has been deleted. Otherwise, return the String unchanged. 
//
//removeDel("adelbc") -> "abc"
//removeDel("adelHello") -> "aHello"
//removeDel("adedbc") -> "adedbc"

    public String removeDel(String str) {
        if (str.length() <4) return str;
        if (str.indexOf("del") == 1) return str.charAt(0) + str.substring(4);
        return str;
    }

}
