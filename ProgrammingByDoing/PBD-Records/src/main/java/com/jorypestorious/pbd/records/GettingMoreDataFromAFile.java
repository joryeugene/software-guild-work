package com.jorypestorious.pbd.records;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class Person {
    String name;
    int age;
}

public class GettingMoreDataFromAFile {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Which file to open: ");
        String filename = scan.nextLine();
        
        System.out.println("Reading data from " + filename + "\n");
        
        Person[] personDatabase = new Person[5];
        
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
        for (int i = 0; i < personDatabase.length; i++) {
            personDatabase[i] = new Person();
            personDatabase[i].name = scanFile.nextLine();
            personDatabase[i].age = scanFile.nextInt();
            if (i < personDatabase.length - 1) scanFile.nextLine();
        }
        
        for (int i = 0; i < personDatabase.length; i++) {
            System.out.println(personDatabase[i].name + " is " + personDatabase[i].age);
        }
    }

}
