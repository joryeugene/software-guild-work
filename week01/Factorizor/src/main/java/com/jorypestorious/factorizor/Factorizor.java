package com.jorypestorious.factorizor;

import java.util.Scanner;

public class Factorizor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("What number would you like to factor? ");
        int inputNum = scan.nextInt(),
            sum = 0;
        
        System.out.println("The factors of " + inputNum + " are:");
        
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