package com.jorypestorious.junitdrills.loops;

public class DoNotYak {
//Suppose the String "yak" is unlucky. Given a String, 
//return a version where all the "yak" are removed, but the "a" can be any char. The "yak" Strings will not overlap. 
//
//doNotYak("yakpak") -> "pak"
//doNotYak("pakyak") -> "pak"
//doNotYak("yak123ya") -> "123ya"
//doNotYak("yek123ya") -> "123ya"
    
    public String doNotYak(String str) {
        if (str.length() < 3) return str;
        String result = "";
        for (int i = 0; i < str.length()-2; i++) {
            if (str.charAt(i) == 'y' && str.charAt(i+2) == 'k') {
                i+=2;
            } else {
                if (i==str.length()-3) {
                    result+=str.substring(i);
                } else {
                    result+=str.charAt(i);
                }
            }
        }
        return result;
    }

}
