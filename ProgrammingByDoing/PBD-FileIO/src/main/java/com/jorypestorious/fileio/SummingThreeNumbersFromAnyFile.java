package com.jorypestorious.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SummingThreeNumbersFromAnyFile {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Which file would you like to read numbers from: ");
        String filename = scan.nextLine();
        
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
        int num1 = Integer.parseInt(scanFile.nextLine());
        int num2 = Integer.parseInt(scanFile.nextLine());
        int num3 = Integer.parseInt(scanFile.nextLine());
        
        System.out.println("Reading numbers from file \"" + filename + "\"... done.\n");
        
        System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + (num1+num2+num3));
    }

}