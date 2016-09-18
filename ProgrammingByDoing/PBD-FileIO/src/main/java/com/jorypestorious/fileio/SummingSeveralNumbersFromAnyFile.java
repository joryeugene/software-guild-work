package com.jorypestorious.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SummingSeveralNumbersFromAnyFile {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Which file would you like to read numbers from: ");
        String filename = scan.nextLine();
        System.out.println("Reading numbers from \"" + filename + "\"\n");
        
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
        int sum = 0;
        int currentInt;
        
        while (scanFile.hasNextInt()) {
            currentInt = scanFile.nextInt();
            System.out.print(currentInt + " ");
            sum += currentInt;
        }
        
        System.out.println("\nTotal is " + sum);        
    }

}