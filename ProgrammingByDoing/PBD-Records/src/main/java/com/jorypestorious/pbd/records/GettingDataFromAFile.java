package com.jorypestorious.pbd.records;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class Dog {
    String name;
    int age;
    double weight;
}

public class GettingDataFromAFile {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Which file to open: ");
        String filename = scan.nextLine();
        System.out.print("Reading data from " + filename);
        
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        
        dog1.name = scanFile.nextLine();
        dog1.age = scanFile.nextInt();
        dog1.weight = scanFile.nextDouble();
        
        scanFile.nextLine();
        
        dog2.name = scanFile.nextLine();
        dog2.age = scanFile.nextInt();
        dog2.weight = scanFile.nextDouble();
        
        System.out.println("\n\nFirst dog: " + dog1.name + ", " + dog1.age + ", " + dog1.weight);
        System.out.println("Second dog: " + dog2.name + ", " + dog2.age + ", " + dog2.weight);
    }
    
}
