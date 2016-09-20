package com.jorypestorious.refactorintoobjects;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public void run() {
        Scanner scan = new Scanner(System.in);
        String playAgain;

        do {
            System.out.print("\nHow many rounds do you want to play? (1-10) ");
            int numOfRounds = getNumInput(10);

            playGame(numOfRounds);
            
            System.out.print("\nDo you want to play again? (y/n) ");
            playAgain = scan.next();
            
        } while (playAgain.equals("y"));
        
        System.out.println("\nTHANKS FOR PLAYING!");
    }
    
    static int getNumInput(int maxNum) {
        Scanner scanNums = new Scanner(System.in);
        int input = scanNums.nextInt();
        
        while (input < 1 || input > maxNum) {
            System.out.print("Please enter a number from 1 to " + maxNum + ": ");
            input = scanNums.nextInt();
        }
        
        return input;
    }
    
    static void playGame(int numOfRounds) {
        int ties = 0,
            wins = 0,
            losses = 0;

        for (int i = 1; i <= numOfRounds; i++) {
            System.out.print("\nRound #" + i + ": Rock (1), Paper (2), or Scissors (3)? ");
            int usersChoice = getNumInput(3);

            int computersChoice = showComputersChoice();

            if (computersChoice == usersChoice) {
                System.out.println("TIE!");
                ties++;
            } else if (usersChoice == 1 && computersChoice == 3 || 
                       usersChoice == 2 && computersChoice == 1 || 
                       usersChoice == 3 && computersChoice == 2) {
                System.out.println("YOU WIN!");
                wins++;
            } else {
                System.out.println("COMPUTER WINS!");
                losses++;
            }
        }
        
        showOutcome(wins, losses, ties);
    }
    
    static int showComputersChoice() {
        Random r = new Random();
        int randomNum = 1 + r.nextInt(3);
        
        switch (randomNum) {
            case 1:
                System.out.println("COMPUTER chose: Rock");
                return 1;
            case 2:
                System.out.println("COMPUTER chose: Paper");
                return 2;
            case 3: default:
                System.out.println("COMPUTER chose: Scissors");
                return 3; 
        }
    }
    
    static void showOutcome(int wins, int losses, int ties) {
        System.out.println("\n# of wins: " + wins);
        System.out.println("# of ties: " + ties);
        System.out.println("# of losses: " + losses + "\n");

        if (wins > losses) {
            System.out.println("OVERALL WINNER: YOU!");
        } else if (wins < losses) {
            System.out.println("OVERALL WINNER: COMPUTER!");
        } else {
            System.out.println("YOU'RE BOTH WINNERS IN MY HEART!");
        }
    }
    
}

