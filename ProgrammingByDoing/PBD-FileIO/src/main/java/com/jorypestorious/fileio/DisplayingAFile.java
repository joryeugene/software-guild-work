package com.jorypestorious.fileio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DisplayingAFile {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Open which file: ");
        String filename = scan.nextLine();
        
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
        while (scanFile.hasNextLine()) {
            System.out.println(scanFile.nextLine());
        }
    }

}
