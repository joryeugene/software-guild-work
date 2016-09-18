package com.jorypestorious.pbd.arrays;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class GradesInAnArrayAndAFile {
    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Name (first last): ");
        String name = scan.nextLine();
        
        System.out.print("Filename: ");
        String filename = scan.nextLine();
        scan.close();
        
        PrintWriter write = new PrintWriter(new FileWriter(filename));
        write.println(name);
        
        System.out.println("\nHere are your randomly-selected grades (hope you pass):");
        Random r = new Random();
        
        int[] grades = new int[5];
        
        for (int i = 0; i < grades.length; i++) {
            grades[i] = 1 + r.nextInt(100);
            System.out.println("Grade " + (i + 1) + ": " + grades[i]);
            write.print(grades[i] + " ");
        }
       
        write.flush();
        write.close();
        
        System.out.println("\nData saved in '" + filename + "'.");
    }

}