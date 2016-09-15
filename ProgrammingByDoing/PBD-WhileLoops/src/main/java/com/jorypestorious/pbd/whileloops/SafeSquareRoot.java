package com.jorypestorious.pbd.whileloops;

import java.util.Scanner;

public class SafeSquareRoot {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("SQUARE ROOT!\n" +
                "Enter a number: ");
        
        double n = scan.nextDouble();
        
        while (n < 0) {
            System.out.print("You can't take the square root of a negative number, silly.\n" +
                    "Try again: ");
            n = scan.nextDouble();
        }
        
        System.out.println("The square root of " + n + " is " + Math.sqrt(n));
    }
}