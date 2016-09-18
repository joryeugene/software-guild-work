package com.jorypestorious.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SummingThreeNumbersFromAFile {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader("3nums.txt")));
        
        int num1 = Integer.parseInt(scanFile.nextLine());
        int num2 = Integer.parseInt(scanFile.nextLine());
        int num3 = Integer.parseInt(scanFile.nextLine());
        
        System.out.println("Reading numbers from file \"3nums.txt\"... done.\n");
        
        System.out.println(num1 + " + " + num2 + " + " + num3 + " = " + (num1+num2+num3));
    }

}