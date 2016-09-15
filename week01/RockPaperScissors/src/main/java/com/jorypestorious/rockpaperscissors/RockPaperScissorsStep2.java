package com.jorypestorious.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsStep2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        
        System.out.print("How many rounds do you want to play? (1-10) ");
        int numOfRounds = scan.nextInt();
        
        while (numOfRounds < 1 || numOfRounds > 10) {
            System.out.print("Please only enter a number from 1 to 10: ");
            numOfRounds = scan.nextInt();
        }
        
        for (int i = 1; i <= numOfRounds; i++) {
            int randomNum = 1 + r.nextInt(3);
            System.out.print("Round #" + i + ": Rock (1), Paper (2), or Scissors (3)? ");
            int choice = scan.nextInt();
            
            if (randomNum == choice) {
                System.out.println("TIE!");
            } else if (choice == 1 && randomNum == 3 || choice == 2 && randomNum == 1 || choice == 3 && randomNum == 2) {
                System.out.println("YOU WIN!");
            } else {
                System.out.println("COMPUTER WINS!");
            }
        }
    }
}
