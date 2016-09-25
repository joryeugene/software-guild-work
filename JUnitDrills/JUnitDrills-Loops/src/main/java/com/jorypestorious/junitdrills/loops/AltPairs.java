package com.jorypestorious.junitdrills.loops;

public class AltPairs {
//Given a String, return a String made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien". 
//
//altPairs("kitten") -> "kien"
//altPairs("Chocolate") -> "Chole"
//altPairs("CodingHorror") -> "Congrr"
    //altPairs("C") -> "C"

    public String altPairs(String str) {
        boolean switc = true;
        int count = 0;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (switc) {
                result += str.charAt(i);
                count++;
                if (count == 2) {
                    switc = false;
                    count = 0;                         
                }
            } else {
                count++;
                if (count == 2) {
                    switc = true;
                    count = 0;                         
                }
            }
        }
        return result;
    }

}
