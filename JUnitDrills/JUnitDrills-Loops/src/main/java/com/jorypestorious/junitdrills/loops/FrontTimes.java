package com.jorypestorious.junitdrills.loops;

public class FrontTimes {
//Given a String and a non-negative int n, we'll say that the front of the String is the first 3 chars, 
    //or whatever is there if the String is less than length 3. Return n copies of the front; 
//
//frontTimes("Chocolate", 2) -> "ChoCho"
//frontTimes("Chocolate", 3) -> "ChoChoCho"
//frontTimes("Abc", 3) -> "AbcAbcAbc"
//frontTimes("A", 3) -> "AAA"

    public String frontTimes(String str, int n) {
        String result = "";
        String substr = (str.length() >= 3) ? str.substring(0,3) : str;
        
        for (int i = 0; i < n; i++) {
            result += substr;
        }
        
        return result;
    }

}
