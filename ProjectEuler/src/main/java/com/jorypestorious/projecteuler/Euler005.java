package com.jorypestorious.projecteuler;

public class Euler005 {

//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
    
    public static void main(String[] args) {
        
        boolean divisible;
        
        // MAJOR BRUTE FORCE :(
        for (long i = 100000000; i < 500000000L; i++) {
            divisible = true;
            for (int j = 2; j <= 20; j++) {
                if (i%j!=0) divisible = false;
            }
            if (divisible) {
                 System.out.println(i); // 232792560
                 break;
            }
        }
        
    }

}
