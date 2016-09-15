package com.jorypestorious.pbd.whileloops;

import java.util.Scanner;

public class CollatzSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("COLLATZ SEQUENCE");
        System.out.print("Starting number: ");
        int n = scan.nextInt();
        
        while (n < 1) {
            System.out.print("Enter a positive integer: ");
            n = scan.nextInt();
        }
        
        int max = n,
            count = 0,
            tabCount = 1;
        
        while (n != 1) {
            if (tabCount == 6) {
                System.out.print(n + "\n");
                tabCount = 0;
            } else System.out.print(n + "\t");
            if (n % 2 == 0) n /= 2;
            else n = 3 * n + 1;
            count++;
            tabCount++;
            if (max < n) max = n;
        }
        
        System.out.println(n);
        count++;
        String steps = " steps.";
        if (count == 1) steps = " step.";
        System.out.println("\nTerminated after " + count + steps);
        System.out.println("The largest value was " + max + ".");
    }
}
