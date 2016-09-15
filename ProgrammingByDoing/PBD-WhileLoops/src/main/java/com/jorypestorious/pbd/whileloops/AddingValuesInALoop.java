package com.jorypestorious.pbd.whileloops;

import java.util.Scanner;

public class AddingValuesInALoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("I will add up the numbers you give me.");
        
        int input = -1,
            sum = 0;
        
        while (input != 0) {
            System.out.print("Number: ");
            input = scan.nextInt();
            if (input == 0) break;
            sum += input;
            System.out.println("The total so far is " + sum);
        }
        
        System.out.println("\nThe total is " + sum);
    }
}