package com.jorypestorious.pbd.ifstatements;

import java.util.Scanner;

public class TwoQuestions {
    public static void main(String[] args) {
        System.out.println("TWO QUESTIONS!\n" +
                "Think of an object, and I'll try to guess it.\n");
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Question 1) Is it an animal, vegetable, or mineral? ");
        String q1Type = scan.nextLine();
        
        System.out.println("\nQuestion 2) Is it bigger than a breadbox? (yes/no) ");
        String q2Size = scan.nextLine();
        
        String myGuess;
        
        if (q2Size.equals("yes")) {
            if (q1Type.equals("animal")) myGuess = "moose";
            else if (q1Type.equals("vegetable")) myGuess = "watermelon";
            else if (q1Type.equals("mineral")) myGuess = "Camaro";
            else myGuess = "(INPUT ERROR - I can't guess)";
        } else if (q2Size.equals("no")) {
            if (q1Type.equals("animal")) myGuess = "squirrel";
            else if (q1Type.equals("vegetable")) myGuess = "carrot";
            else if (q1Type.equals("mineral")) myGuess = "paper clip";
            else myGuess = "(INPUT ERROR - I can't guess)";
        } else {
            myGuess = "(INPUT ERROR - I can't guess)";
        }
        
        System.out.println("\nMy guess is that you are thinking of a " + myGuess + ".");
    }
}
