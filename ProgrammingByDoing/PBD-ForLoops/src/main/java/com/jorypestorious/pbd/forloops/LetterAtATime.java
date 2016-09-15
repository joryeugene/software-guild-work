package com.jorypestorious.pbd.forloops;

import java.util.Scanner;

public class LetterAtATime {
    
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        System.out.print("What is your message? ");
        String message = kb.nextLine();
        
        System.out.println("\nYour message is " + message.length() + " characters long.");
        System.out.println("The first character is at position 0 and is '" + message.charAt(0) + "'.");
        int lastpos = message.length() - 1;
        System.out.println("The last character is at position " + lastpos + " and is '" + message.charAt(lastpos) + "'.");
        System.out.println("\nHere are all the characters, one at a time:\n");
        
        for (int i = 0; i < message.length(); i++) {
            System.out.println("\t" + i + " - '" + message.charAt(i) + "'");
        }
        
        int vowel_count = 0;
        
        // i <= message.length() causes a StringIndexOutOfBoundsException
        // "box".length == 3 and 'x' is in the 2nd position
        // 0-based, so we don't do <=
        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            if (letter == 'a' || letter == 'A' || letter == 'e' || letter == 'E' || letter == 'i' || letter == 'I' ||
                     letter == 'o' || letter == 'O' || letter == 'u' || letter == 'U') {
                vowel_count++;
            }
        }
        
        System.out.println("\nYour message contains " + vowel_count + " vowel(s). Isn't that interesting?");
        
    }
}
