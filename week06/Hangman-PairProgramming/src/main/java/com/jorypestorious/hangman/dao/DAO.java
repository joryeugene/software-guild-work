package com.jorypestorious.hangman.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class DAO {

    List<String> words;

    public DAO() {
        words = readWords();
    }

    public boolean addWords(String word) {
        if (words.indexOf(word) == -1) {
            words.add(word);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeWords(String word) {
        if (words.indexOf(word) == -1) {
            return false;
        } else {
            words.remove(word);
            return true;
        }
    }

    public void writeWords() {
        try (PrintWriter out = new PrintWriter(new FileWriter("words.txt"))) {
            for (String word : words) {
                out.println(word);
            }
            out.flush();
            out.close();
        } catch (IOException ex) {
            System.out.println("ERROR SAVING TO FILE");
        }
    }

    private List<String> readWords() {
        List<String> wordsRead = new ArrayList<>();
        try (Scanner kb = new Scanner(new BufferedReader(new FileReader("words.txt")))) {
            while (kb.hasNextLine()) {
                String wordToAdd = kb.nextLine().trim();
                if (wordToAdd.length() > 0) wordsRead.add(wordToAdd);
            }
            kb.close();
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR READING words.txt NO WORDS TO PLAY WITH");
        }
        return wordsRead;
    }
    
    public String getWordToPlayWith() {
        Random r = new Random();
        int randomNum = r.nextInt(words.size());
        String word = words.get(randomNum);
        words.remove(randomNum);
        return word;
    }
    
    public int getNumberOfWords() {
        return words.size();
    }
}
