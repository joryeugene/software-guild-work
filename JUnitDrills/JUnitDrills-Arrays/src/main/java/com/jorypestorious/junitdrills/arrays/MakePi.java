package com.jorypestorious.junitdrills.arrays;

public class MakePi {
//Return an int array length n containing the first n digits of pi.
//
//    makePi(3) -> {3, 1, 4}
    
    public int[] makePi(int n) {
        
        Double pie = Math.PI;
        int[] pieArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            pieArr[i] = (int) Math.floor(pie);
            pie -= pieArr[i];
            pie *= 10;
        }
        
        return pieArr;
    }
    
}
