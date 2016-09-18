package com.jorypestorious.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SimpleFileInput {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader("name.txt")));
        
        String name = scanFile.nextLine();
        
        System.out.println("Using my psychic powers (aided by reading data from the file), I have\n" +
                "determined that your name is " + name + ".");       
    }

}