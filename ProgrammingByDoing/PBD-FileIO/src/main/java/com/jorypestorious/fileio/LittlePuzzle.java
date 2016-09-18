package com.jorypestorious.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LittlePuzzle {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Open which file: ");
        String filename = scan.nextLine();
        
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        String puzzle = scanFile.nextLine();
        
        for (int i = 0; i < puzzle.length(); i++) {
            if ((i+1) % 3 == 0) System.out.print(puzzle.charAt(i));
        }

    }

}
