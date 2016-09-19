package com.jorypestorious.projecteuler;

public class Euler014 {
    
//The following iterative sequence is defined for the set of positive integers:
//
//n → n/2 (n is even)
//n → 3n + 1 (n is odd)
//
//Using the rule above and starting with 13, we generate the following sequence:
//
//13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
//It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
//
//Which starting number, under one million, produces the longest chain?
//
//NOTE: Once the chain starts the terms are allowed to go above one million.

    public static void main(String[] args) {
        
        long longestChain = 0;
        long startingNumLongestChain = 0;
        long currentChain = 1;
        long startingNum;
        
        for (int i = 999999; i > 1; i--) {
            startingNum = i;
            
            while (startingNum > 1) {
                currentChain++;
                if (startingNum%2==0) startingNum /= 2;
                else startingNum = startingNum * 3 + 1;
            }
            
            if (currentChain > longestChain) {
                longestChain = currentChain;
                startingNumLongestChain = i;
//                System.out.println("Starting number: " + i + " | Chain length: " + longestChain);
            }
            
            currentChain = 1;
        }
        
        System.out.println(startingNumLongestChain); // 837799
    }
    
}
