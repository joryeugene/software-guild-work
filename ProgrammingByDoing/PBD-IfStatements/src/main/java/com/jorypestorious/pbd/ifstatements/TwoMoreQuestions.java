package com.jorypestorious.pbd.ifstatements;

import java.util.Scanner;

public class TwoMoreQuestions {
    public static void main(String[] args) {
        System.out.println("TWO QUESTIONS!\n" +
                "Think of an object, and I'll try to guess it.\n");
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Question 1: Does it belong inside or outside or both? ");
        String q1 = scan.nextLine();
        
        System.out.println("\nQuestion 2: Is it alive? (yes/no) ");
        String q2 = scan.nextLine();
        
        String myGuess = "";
        
        if (q2.equals("yes") && q1.equals("inside")) myGuess = "houseplant";
        if (q2.equals("yes") && q1.equals("outside")) myGuess = "bison";
        if (q2.equals("yes") && q1.equals("both")) myGuess = "dog";
        if (q2.equals("no") && q1.equals("inside")) myGuess = "shower curtain";
        if (q2.equals("no") && q1.equals("outside")) myGuess = "billboard";
        if (q2.equals("no") && q1.equals("both")) myGuess = "cell phone";
        
        System.out.println("\nMy guess is that you are thinking of a " + myGuess + ".");
    }
}
