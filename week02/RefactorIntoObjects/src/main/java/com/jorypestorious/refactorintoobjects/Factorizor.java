package com.jorypestorious.refactorintoobjects;

import java.util.Scanner;

public class Factorizor {
    Scanner scan = new Scanner(System.in);
    
    public void run() {
        System.out.print("What real number would you like the factors of? ");
        int inputNum = scan.nextInt(),
            sum = 0;
        
        while (inputNum < 1) {
            System.out.print("Input a real number: ");
            inputNum = scan.nextInt();
        }
        
        System.out.println("\nThe factors of " + inputNum + " are:");
        
        for (int i = 1; i < inputNum; i++) {
            if (inputNum % i == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        
        System.out.println(""); // line break
        if (inputNum == sum) System.out.println(inputNum + " is a perfect number.");
        else System.out.println(inputNum + " is NOT a perfect number.");
        
        if (inputNum + sum == inputNum + 1) System.out.println(inputNum + " is a prime number.");
        else System.out.println(inputNum + " is NOT a prime number.");
    }
}