package com.jorypestorious.pbd.arrays;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        
        String[] wordChoices = {"beer", "stool", "balloon", "watch", "buffalo", 
            "computer", "hangman", "lavashark"};
        
        boolean playAgain = false;
                
        do {
            String wordToFind = wordChoices[r.nextInt((wordChoices.length))];
        
            int numCorrectGuesses = 0;
            int correctGuessesNeeded = wordToFind.length();
            int numOfTriesAllowed = (int)(correctGuessesNeeded * 2.2);
            
            char[] correctGuesses = new char[correctGuessesNeeded];
            char[] incorrectGuesses = new char[numOfTriesAllowed];
            
            for (int i = 0; i < correctGuesses.length; i++) {
                correctGuesses[i] = '_';
            }
            
            boolean gameOver = false,
                    correctGuess = false,
                    inputInvalid = false;
            int turnCount = 0;
            char guess;
            
            while (!gameOver) {
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
                
                System.out.print("Word: ");
                for (int i = 0; i < correctGuesses.length; i++) {
                    System.out.print(correctGuesses[i] + " ");
                }
                
                System.out.println("\n"); // line break
                System.out.print("Misses: ");
                for (int i = 0; i < incorrectGuesses.length; i++) {
                    if (incorrectGuesses[i] != '\u0000') System.out.print(incorrectGuesses[i] + " ");
                }
                System.out.println(""); // line break
                
                do {
                    inputInvalid = false;
                    System.out.println(""); // line break
                    System.out.print("Guess (" + (turnCount + 1) + "/" + numOfTriesAllowed + "): ");
                    guess = scan.nextLine().charAt(0);
                    
                    for (int i = 0; i < correctGuesses.length; i++) {
                        if (correctGuesses[i] == guess) {
                            inputInvalid = true;
                            System.out.println("You've already correctly guesses this.");
                            break;
                        }
                    }
                    
                    for (int i = 0; i < incorrectGuesses.length; i++) {
                        if (incorrectGuesses[i] == guess) {
                            inputInvalid = true;
                            System.out.println("You've already guessed this.");
                            break;
                        }
                    }
                } while (inputInvalid);
                
                for (int i = 0; i < correctGuessesNeeded; i++) {
                    if (guess == wordToFind.charAt(i)) {
                        correctGuesses[i] = guess;
                        numCorrectGuesses++;
                        correctGuess = true;
                    }
                }
                
                if (!correctGuess) incorrectGuesses[turnCount] = guess;
                
                turnCount++;
                correctGuess = false;
                
                System.out.println(""); // line break
                
                if (correctGuessesNeeded == numCorrectGuesses) {
                    gameOver = true;
                    System.out.println("YOU DID IT!");
                } else if (numOfTriesAllowed == turnCount) {
                    gameOver = true;
                    System.out.println("You've used all your chances. You lose.");
                }
                
            }
            
            System.out.print("\nPlay \"again\" or \"quit\"? ");
            playAgain = (scan.nextLine().equals("again")) ? true : false;
            
        } while (playAgain);
        
    }
    
}