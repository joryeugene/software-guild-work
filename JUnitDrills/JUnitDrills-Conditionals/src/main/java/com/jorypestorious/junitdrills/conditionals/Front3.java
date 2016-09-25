package com.jorypestorious.junitdrills.conditionals;

public class Front3 {
//Given a String, we'll say that the front is the first 3 chars of the String. 
    //If the String length is less than 3, the front is whatever is there. Return a new String which is 3 copies of the front. 
//
//front3("Microsoft") -> "MicMicMic"
//front3("Chocolate") -> "ChoChoCho"
//front3("at") -> "atatat"

    public String front3(String str) {
        int len = (str.length() > 3) ? 3 : str.length();
        String s = str.substring(0,len);
        return s+s+s;
    }

}
