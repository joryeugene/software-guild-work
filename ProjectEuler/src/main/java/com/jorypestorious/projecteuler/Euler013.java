package com.jorypestorious.projecteuler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Euler013 {
    
    // Work out the first ten digits of the sum of the following one-hundred 50-digit numbers.
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader("100_50digitNums.txt")));
        
        BigInteger sum = new BigInteger("0");
        BigInteger temp;
        
        while (scanFile.hasNextLine()) {
            temp = new BigInteger(scanFile.nextLine());
            sum = sum.add(temp);
        }
        
        String numStr = "" + sum;
        
        System.out.println(numStr.substring(0,10)); // 5537376230
    }

}
