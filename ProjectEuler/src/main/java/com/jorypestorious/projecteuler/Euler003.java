package com.jorypestorious.projecteuler;

public class Euler003 {
    
    // The prime factors of 13195 are 5, 7, 13 and 29.
    
    // What is the largest prime factor of the number 600851475143 ?
    
    public static void main(String[] args) {
        long n = 600851475143L;
        
        // Sieve
        for (long i = 3; i <= n; i+=2) {
            if (n%i==0) {
                System.out.println(i); // 6857
                n = n / i;
            }
        }
    }
    
}
