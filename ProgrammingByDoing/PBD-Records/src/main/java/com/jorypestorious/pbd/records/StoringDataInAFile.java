package com.jorypestorious.pbd.records;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Car {
    String make;
    String model;
    int year;
    String license;
}

public class StoringDataInAFile {
    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        
        Car[] carDatabase = new Car[5];
        
        for (int i = 0; i < carDatabase.length; i++) {
            System.out.println("Car " + (i+1));
            carDatabase[i] = new Car();
            
            System.out.print("\tMake: ");
            carDatabase[i].make = scan.nextLine();
            
            System.out.print("\tModel: ");
            carDatabase[i].model = scan.nextLine();
            
            System.out.print("\tYear: ");
            carDatabase[i].year = scan.nextInt();
            
            scan.nextLine();
            
            System.out.print("\tLicense: ");
            carDatabase[i].license = scan.nextLine();
            
            System.out.println("");
        }
        
        System.out.print("To which file do you want to save this information? ");
        String filename = scan.nextLine();
        
        PrintWriter write = new PrintWriter(new FileWriter(filename));
        
        for (int i = 0; i < carDatabase.length; i++) {
            write.println(carDatabase[i].make + " " + carDatabase[i].model + " " + carDatabase[i].year + " " + carDatabase[i].license);
        }
        
        write.flush();
        write.close();

        System.out.println("\nData saved.");
    }
    
}