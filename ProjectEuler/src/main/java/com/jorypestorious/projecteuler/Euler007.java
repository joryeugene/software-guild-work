package com.jorypestorious.projecteuler;

public class Euler007 {
    
//By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
//
//What is the 10 001st prime number?
    
    public static void main(String[] args) {
        
        int count = 2;
        int target = 10001;
        
        for (int i = 4; count < target; i++) {
            if (isPrime(i)) {
                count++;
                if (count == target) System.out.println(i); // 104743
            }
        } 
    }
    
    static boolean isPrime(int n) {
        if (n%2==0) return false;

        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0) return false;
        }
        
        return true;
    }
    
}
    