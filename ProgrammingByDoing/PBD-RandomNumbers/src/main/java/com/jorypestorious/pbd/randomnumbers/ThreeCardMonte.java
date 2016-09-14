package com.jorypestorious.pbd.randomnumbers;

import java.util.Random;
import java.util.Scanner;

public class ThreeCardMonte {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("You slide up to Fast Eddie's card table and plop down your cash.\n" +
                "He glances at you out of the corner of his eye and starts shuffling.\n" +
                "He lays down three cards.\n" +
                "\n" +
                "Which one is the ace?\n" +
                "\n" +
                "	##  ##  ##\n" +
                "	##  ##  ##\n" +
                "	1   2   3\n\n> ");
        int guess = scan.nextInt();
        
        Random r = new Random();
        int randomNum = 1 + r.nextInt(3);
        
        if (guess == randomNum) {
            System.out.println("\nYou nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n");
        } else {
            System.out.println("\nHa! Fast Eddie wins again! The ace was card number " + randomNum + ".\n");
        }
        
        if (randomNum == 1) {
            System.out.println("	AA  ##  ##\n" +
                    "	AA  ##  ##\n" +
                    "	1   2   3");
        } else if (randomNum == 2) {
            System.out.println("	##  AA  ##\n" +
                    "	##  AA  ##\n" +
                    "	1   2   3");
        } else {
            System.out.println("	##  ##  AA\n" +
                    "	##  ##  AA\n" +
                    "	1   2   3");
        }
    }
}
