package com.jorypestorious.gamebot.games;

import com.jorypestorious.gamebot.ui.ConsoleIO;
import java.util.Random;

public class RockPaperScissors implements Game{
    
    ConsoleIO io = new ConsoleIO();

    @Override
    public String getTitle() {
        return "Rock Paper Scissors";
    }
    
    @Override
    public void run() {
        
        io.display("     ROCK PAPER SCISSORS    \n" +
                   "=============================");
        
        String playAgain;

        do {
            int numOfRounds = io.promptInt("How many rounds do you want to play? (1-10) ", 1, 10);

            playGame(numOfRounds);
            
            playAgain = io.promptString("\nDo you want to play again? (y/n) ");
            io.display(""); // line break
            
        } while (playAgain.equalsIgnoreCase("Y"));
        
    }
    
    private void playGame(int numOfRounds) {
        int ties = 0,
            wins = 0,
            losses = 0;

        for (int i = 1; i <= numOfRounds; i++) {
            int usersChoice = io.promptInt("\nRound #" + i + ": Rock (1), Paper (2), or Scissors (3)? ", 1, 3);

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
    
    private int showComputersChoice() {
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
    
    private void showOutcome(int wins, int losses, int ties) {
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
