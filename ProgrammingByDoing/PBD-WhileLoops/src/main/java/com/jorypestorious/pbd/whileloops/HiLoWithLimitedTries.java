package com.jorypestorious.pbd.whileloops;

import java.util.Random;
import java.util.Scanner;

public class HiLoWithLimitedTries {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = 1 + r.nextInt(100);
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("I'm thinking of a number between 1-100. You have 7 guesses.\n");
        int guess,
            tries = 1;
        
        System.out.print("Guess #" + tries + ": ");
        guess = scan.nextInt();
        
        while (guess != randomNum && tries < 7) {
            tries++;
            if (guess < randomNum) System.out.println("Guess higher!");
            if (guess > randomNum) System.out.println("Guess lower!");
            System.out.print("Guess #" + tries + ": ");
            guess = scan.nextInt();
        }
        
        if (guess == randomNum) System.out.println("\nYou guessed it!  What are the odds?!?");
        else System.out.println("\nYou didn't guess it within 7 tries.  You lose.");
    }
}
