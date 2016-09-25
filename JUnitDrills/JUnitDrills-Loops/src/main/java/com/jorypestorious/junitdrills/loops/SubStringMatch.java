package com.jorypestorious.junitdrills.loops;

public class SubStringMatch {
//Given 2 Strings, a and b, return the number of the positions where they 
    //contain the same length 2 subString. So "xxcaazz" and "xxbaaz" yields 3, 
    //since the "xx", "aa", and "az" subStrings appear in the same place in both Strings. 
//
//subStringMatch("xxcaazz", "xxbaaz") -> 3
//subStringMatch("abc", "abc") -> 2
//subStringMatch("abc", "axc") -> 0
    //subStringMatch("abcook", "axcooking") -> 3
    //subStringMatch("a", "axcooking") -> 0
    

    public int subStringMatch(String a, String b) {
        if (a.length() < 2 || b.length() < 2) return 0;
        int limit = (a.length() > b.length()) ? b.length() : a.length();
        int count = 0;
        for (int i = 0; i < limit-1; i++) {
            if (a.substring(i,i+2).equals(b.substring(i,i+2))) count++;
        }
        return count;
    }

}
