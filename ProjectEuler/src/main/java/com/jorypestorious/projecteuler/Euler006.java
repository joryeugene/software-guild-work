package com.jorypestorious.projecteuler;

import java.math.BigInteger;

public class Euler006 {
    
//The sum of the squares of the first ten natural numbers is,
//12 + 22 + ... + 102 = 385
    
//The square of the sum of the first ten natural numbers is,
//(1 + 2 + ... + 10)2 = 552 = 3025
//Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
//
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

    public static void main(String[] args) {
        BigInteger powers, squareOfSums, sumOfSquares = new BigInteger("0");

        int sum = 0;
        
        for (int i = 1; i <= 100; i++) {
            powers = new BigInteger(Integer.toString(i*i));
            sumOfSquares = sumOfSquares.add(powers);
            sum += i;
        }
        
        squareOfSums = new BigInteger(Long.toString(sum*sum));
        
        System.out.println(squareOfSums.subtract(sumOfSquares)); // 25164150
    }

}
