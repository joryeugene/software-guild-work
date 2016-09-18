package com.jorypestorious.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class VowelCapitalization {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Open which file: ");
        String filename = scan.nextLine();
        
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
        System.out.println(""); // line break
        
        while (scanFile.hasNextLine()) {
            String currentLine = scanFile.nextLine();
            
            char[] lineCharArr= currentLine.toCharArray();
            
            for (int i = 0; i < lineCharArr.length; i++) {
                if (lineCharArr[i] == 'a') lineCharArr[i] = 'A';
                if (lineCharArr[i] == 'e') lineCharArr[i] = 'E';
                if (lineCharArr[i] == 'i') lineCharArr[i] = 'I';
                if (lineCharArr[i] == 'o') lineCharArr[i] = 'O';
                if (lineCharArr[i] == 'u') lineCharArr[i] = 'U';
            }
            
            System.out.println(String.valueOf(lineCharArr));
        }
    }

}