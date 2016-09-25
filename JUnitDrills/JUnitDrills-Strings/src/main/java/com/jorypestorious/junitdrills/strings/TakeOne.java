package com.jorypestorious.junitdrills.strings;

public class TakeOne {
//Given a String, return a String length 1 from its front, unless front is false, 
    //in which case return a String length 1 from its back. The String will be non-empty. 
//
//takeOne("Hello", true) -> "H"
//takeOne("Hello", false) -> "o"
//takeOne("oh", true) -> "o"

    public String takeOne(String str, boolean fromFront) {
        if (fromFront) {
            return ""+str.charAt(0);
        } else {
            return ""+str.charAt(str.length()-1);
        }
    }

}
