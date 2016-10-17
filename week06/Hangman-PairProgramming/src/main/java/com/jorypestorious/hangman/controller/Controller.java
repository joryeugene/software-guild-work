package com.jorypestorious.hangman.controller;

import com.jorypestorious.hangman.dao.DAO;
import com.jorypestorious.hangman.ui.ConsoleIO;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    DAO dao;
    ConsoleIO io;

    public Controller(DAO dao) {
        this.dao = dao;
        io = new ConsoleIO();
    }

    public void run() throws InterruptedException {
        boolean keepRunning = true;

        while (keepRunning) {
            int choice = io.promptInt("\n******HANGMAN******\n"
                    + "1.) Play\n"
                    + "2.) Add Word\n"
                    + "3.) Remove Word\n"
                    + "4.) Exit\n\n"
                    + "> ", 1, 4);
            switch (choice) {
                case 1:
                    if (dao.getNumberOfWords() > 0) {
                        play();
                    } else {
                        io.display("You need to add words before you can play");
                    }
                    break;
                case 2:
                    addWords();
                    break;
                case 3:
                    removeWords();
                    break;
                case 4:
                    io.display("\nThanks for playing!");
                    dao.writeWords();
                    keepRunning = false;
                default:
                    break;
            }

            Thread.sleep(1000);
        }
    }

    private void play() {
        String word = dao.getWordToPlayWith();
        int maxIncorrectGuesses = 6; // six wrong guesses allowed
        int incorrectGuessCount = 0;
        int correctGuessCount = 0;

        char[] correctGuesses = new char[word.length()];
        List<Character> incorrectGuesses = new ArrayList<>();

        for (int i = 0; i < correctGuesses.length; i++) {
            correctGuesses[i] = '_';
        }

        boolean stillPlaying = true;

        do {
            boolean correctGuess = false;
            boolean alreadyGuessedCorrectly = false;
            boolean alreadyGuessedIncorrectly = false;

            io.display("--------------------------");
            io.displayNoNewLine("Word: ");
            for (int i = 0; i < correctGuesses.length; i++) {
                io.displayNoNewLine(correctGuesses[i] + " ");
            }

            io.displayNoNewLine("\nGuesses: ");
            for (int i = 0; i < incorrectGuesses.size(); i++) {
                io.displayNoNewLine(incorrectGuesses.get(i) + " ");
            }
            
            io.display("\nIncorrect Guesses: " + incorrectGuessCount + "/" + maxIncorrectGuesses);

            char guess = io.promptString("\nGuess a letter: ").toUpperCase().charAt(0);

            for (int i = 0; i < incorrectGuesses.size(); i++) {
                if (incorrectGuesses.get(i) == guess) {
                    alreadyGuessedIncorrectly = true;
                    break;
                }
            }

            for (int i = 0; i < correctGuesses.length; i++) {
                if (correctGuesses[i] == guess) {
                    alreadyGuessedCorrectly = true;
                    correctGuesses[i] = guess;
                    break;
                }
            }

            if (alreadyGuessedIncorrectly) {
                io.display("! You've already guessed that incorrectly.");
            } else if (alreadyGuessedCorrectly) {
                io.display("! You've already guessed that correctly.");
            } else {
                for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) == guess) {
                        correctGuess = true;
                        correctGuesses[i] = guess;
                        correctGuessCount++;
                    }
                }
                
                if (correctGuess) io.display("* You've guessed correctly!");
                
                if (!correctGuess) {
                    incorrectGuesses.add(guess);
                    io.display("! You've guessed incorrectly.");
                    incorrectGuessCount++;
                }
            }
            
            if (incorrectGuessCount >= maxIncorrectGuesses) {
                io.display("Too many incorrect Guesses! You lost!");
                stillPlaying = false;
            } else if (correctGuessCount >= word.length()) {
                io.display("*** You got it! WINNER! ***");
                
                io.displayNoNewLine("\nWord: ");
                for (int i = 0; i < correctGuesses.length; i++) {
                    io.displayNoNewLine(correctGuesses[i] + " ");
                }
                stillPlaying = false;
            }
            
        } while (stillPlaying);
    }

    private void addWords() {
        String newWord = io.promptString("Word to add: ").toUpperCase();

        if (dao.addWords(newWord)) {
            io.display("* Word successfully added");
        } else {
            io.display("! ERROR - Word already exists");
        }
    }

    private void removeWords() {
        String wordToRemove = io.promptString("Word to remove: ").toUpperCase();

        if (dao.removeWords(wordToRemove)) {
            io.display("* Word successfully removed");
        } else {
            io.display("! ERROR - Word does not exist");
        }
    }
}
