package com.jorypestorious.pbd.methods97;

public class FindingPrimeNumbers {
    
    public static void main(String[] args) {
//        for (int i = 2; i <= 20; i++) {
//            if (isPrime(i)) System.out.println(i + " <");
//            else System.out.println(i);
//        }
        
        for (int i = 2; i < 100; i++) {
            if (isPrime(i)) System.out.println(i);
        }
    }
    
    public static boolean isPrime( int n ) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
