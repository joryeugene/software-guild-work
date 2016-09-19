package com.jorypestorious.projecteuler;

public class Euler010 {
    
//The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
//
//Find the sum of all the primes below two million.
    
    public static void main(String[] args) {
        
        long sum = 5;
        
        for (int i = 4; i < 2000000; i++) {
            if (isPrime(i)) {
                sum+=i;
            }
        } 
        
        System.out.println(sum); // 142913828922
    }
    
    static boolean isPrime(int n) {
        if (n%2==0) return false;

        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0) return false;
        }
        
        return true;
    }

}
