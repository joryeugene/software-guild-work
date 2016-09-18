package com.jorypestorious.fileio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HighScore {
    
    public static void main(String[] args) throws IOException {
        PrintWriter write = new PrintWriter(new FileWriter("score.txt"));
        Scanner scan = new Scanner(System.in);
        
        System.out.println("You got a high score!\n");
        
        System.out.print("Please enter your score: ");
        write.print(scan.nextInt() + "\t");
        scan.nextLine();
        
        System.out.print("Please enter your name: ");
        write.println(scan.nextLine());
        write.flush();
        write.close();
        
        System.out.println("Data stored into score.txt.");
    }

}