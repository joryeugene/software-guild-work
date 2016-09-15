package com.jorypestorious.pbd.whileloops;

import java.util.Random;
import java.util.Scanner;

public class KeepGuessing {
    public static void main(String[] args) {
        Random r = new Random();
        int randomNum = 1 + r.nextInt(10);
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("I have chosen a number between 1 and 10. Try to guess it.\n" +
                "Your guess: ");
        int guess = scan.nextInt();
        
        while (guess != randomNum) {
            System.out.print("That is incorrect. Guess again.\n" +
                    "Your guess: ");
            guess = scan.nextInt();
        }
        
        System.out.println("That's right! You're a good guesser.");
    }
}