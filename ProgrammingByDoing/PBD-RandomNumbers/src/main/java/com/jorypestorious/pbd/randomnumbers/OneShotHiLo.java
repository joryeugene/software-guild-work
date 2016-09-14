package com.jorypestorious.pbd.randomnumbers;

import java.util.Random;
import java.util.Scanner;

public class OneShotHiLo {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = 1 + r.nextInt(100);
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("I'm thinking of a number between 1-100.  Try to guess it.\n" + "> ");
        int guess = scan.nextInt();
        
        if (guess < randomNum) System.out.println("\nSorry, you are too low.  I was thinking of " + randomNum + ".");
        else if (guess > randomNum) System.out.println("\nSorry, you are too high.  I was thinking of " + randomNum + ".");
        else if (guess == randomNum) System.out.println("You guessed it!  What are the odds?!?");
        else System.out.println("ERROR");
    }
}
