package com.jorypestorious.pbd.ifstatements;

import java.util.Scanner;

public class ALittleQuiz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numCorrect = 0;
        System.out.println("A little quiz with three questions (Please enter the answer's number)\n");
        
        System.out.println("Q1) What is the capital of Alaska?\n" +
                "	1) Melbourne\n" +
                "	2) Anchorage\n" +
                "	3) Juneau");
        System.out.print("\nAnswer? ");
        if (scan.nextInt() == 3) {
            numCorrect++;
            System.out.println("That's correct!");
        } else {
            System.out.println("Incorrect.");
        }
        
        System.out.println("\nQ2) Can you store the value \"cat\" in a variable of type int?\n" +
                "	1) yes\n" +
                "	2) no");
        System.out.print("\nAnswer? ");
        if (scan.nextInt() == 2) {
            numCorrect++;
            System.out.println("That's correct!");
        } else {
            System.out.println("Incorrect.");
        }
        
        System.out.println("\nQ3) What is the result of 9+6/3?\n" +
                "	1) 5\n" +
                "	2) 11\n" +
                "	3) 15/3");
        System.out.print("\nAnswer? ");
        if (scan.nextInt() == 2) {
            numCorrect++;
            System.out.println("That's correct!");
        } else {
            System.out.println("Incorrect.");
        }
        
        System.out.println("\nOverall, you got "+ numCorrect + " out of 3 correct.\n" +
                "Thanks for playing!");
    }
}
