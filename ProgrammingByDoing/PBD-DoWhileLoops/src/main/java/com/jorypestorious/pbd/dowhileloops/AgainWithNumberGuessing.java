package com.jorypestorious.pbd.dowhileloops;

import java.util.Random;
import java.util.Scanner;

public class AgainWithNumberGuessing {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = 1 + r.nextInt(10);
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("I have chosen a number between 1 and 10. Try to guess it.\n" +
                "Your guess: ");
        int guess = scan.nextInt();
        int guessCount = 1;
        
        do {
            if (guess == randomNum) break;
            System.out.print("That is incorrect. Guess again.\n" +
                    "Your guess: ");
            guess = scan.nextInt();
            guessCount++;
        } while (guess != randomNum);
        
        System.out.println("That's right!");
        
        String tries = " tries.";
        
        if (guessCount == 1) tries = " try!";
        
        System.out.println("It only took you " + guessCount + tries);
    }
}
