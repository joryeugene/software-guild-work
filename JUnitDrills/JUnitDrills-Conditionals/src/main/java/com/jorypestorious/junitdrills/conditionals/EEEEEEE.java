package com.jorypestorious.junitdrills.conditionals;

public class EEEEEEE {
//Return true if the given String contains between 1 and 3 'e' chars. 
//
//gotE("Hello") -> true
//gotE("Heelle") -> true
//gotE("Heelele") -> false

    public boolean gotE(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') count++;
        }
        return count>=1&&count<=3;
    }

}
