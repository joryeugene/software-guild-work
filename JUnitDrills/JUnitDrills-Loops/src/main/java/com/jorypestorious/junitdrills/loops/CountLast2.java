package com.jorypestorious.junitdrills.loops;

public class CountLast2 {
//Given a String, return the count of the number of times that 
    //a subString length 2 appears in the String and also as the last 2 chars of the String,
    //so "hixxxhi" yields 1 (we won't count the end subString). 
//
//countLast2("hixxhi") -> 1
//countLast2("xaxxaxaxx") -> 1
//countLast2("axxxaaxx") -> 2

    public int countLast2(String str) {
        int count = 0;
        if (str.length() < 4) return count;
        String match = str.substring(str.length()-2);
        for (int i = 0; i < str.length()-3; i++) {
            if (str.substring(i,i+2).equals(match)) count++;
        }
        return count;
    }

}
