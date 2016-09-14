package com.jorypestorious.pbd.randomnumbers;

import java.util.Random;
import java.util.Scanner;

public class ANumberGuessingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("I'm thinking of a number from 1 to 10.\n" +
                "Your guess: ");
        int guess = scan.nextInt();
        
        Random r = new Random();
        int randomNum = 1 + r.nextInt(10);
        
        if (guess == randomNum) System.out.println("That's right!  My secret number was " + randomNum + "!");
        else System.out.println("Sorry, but I was really thinking of " + randomNum + ".");
    }
}
