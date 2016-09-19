package com.jorypestorious.projecteuler;

public class Euler009 {
    
//A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
//
//a2 + b2 = c2
//For example, 32 + 42 = 9 + 16 = 25 = 52.
//
//There exists exactly one Pythagorean triplet for which a + b + c = 1000.
//Find the product abc.
    
    public static void main(String[] args) {
        
        int a;
        int b;
        int c;
        int n = 1000;
        
        // Brute force
        
        for (a = 2; a < n; a++) {
            for (b = 2; b < n; b++) {
                for (c = 2; c < n; c++) {
                    if (a*a + b*b == c*c && a + b + c == 1000) {
                        // 200 375 425
                        System.out.println(a*b*c); // 31875000
                        System.exit(0);
                    }
                }
            }
        }
    }
}
