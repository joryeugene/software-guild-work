package com.jorypestorious.rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsStep3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        
        System.out.print("How many rounds do you want to play? (1-10) ");
        int numOfRounds = scan.nextInt();
        
        while (numOfRounds < 1 || numOfRounds > 10) {
            System.out.print("Please only enter a number from 1 to 10: ");
            numOfRounds = scan.nextInt();
        }
        
        int ties = 0,
            wins = 0,
            loses = 0;
        
        System.out.println(""); // line break
        
        for (int i = 1; i <= numOfRounds; i++) {
            int randomNum = 1 + r.nextInt(3);
            System.out.print("Round #" + i + ": Rock (1), Paper (2), or Scissors (3)? ");
            int choice = scan.nextInt();
            
            if (randomNum == choice) {
                System.out.println("TIE!");
                ties++;
            } else if (choice == 1 && randomNum == 3 || choice == 2 && randomNum == 1 || choice == 3 && randomNum == 2) {
                System.out.println("YOU WIN!");
                wins++;
            } else {
                System.out.println("COMPUTER WINS!");
                loses++;
            }
        }
        
        System.out.println("\n# of wins: " + wins);
        System.out.println("# of ties: " + ties);
        System.out.println("# of loses: " + loses + "\n");
        
        if (wins > loses) {
            System.out.println("OVERALL WINNER: YOU!");
        } else if (wins < loses) {
            System.out.println("OVERALL WINNER: COMPUTER!");
        } else {
            System.out.println("YOU'RE BOTH WINNERS IN MY HEART!");
        }
    }
}
