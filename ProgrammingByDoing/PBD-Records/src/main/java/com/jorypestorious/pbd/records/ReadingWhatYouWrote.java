package com.jorypestorious.pbd.records;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadingWhatYouWrote {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("From which file do you want to load this information? ");
        String filename = scan.nextLine();
        System.out.println("Data loaded.");
        
        Car[] carsArr = new Car[5];
        
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
        for (int i = 0; i < carsArr.length; i++) {
            carsArr[i] = new Car();
            carsArr[i].make = scanFile.next();
            carsArr[i].model = scanFile.next();
            carsArr[i].year = scanFile.nextInt();
            carsArr[i].license = scanFile.next();
        }
        
        for (int i = 0; i < carsArr.length; i++) {
            System.out.println("\nCar " + (i+1));
       
            System.out.println("\tMake: " + carsArr[i].make);
            
            System.out.println("\tModel: " + carsArr[i].model);
            
            System.out.println("\tYear: " + carsArr[i].year);
            
            System.out.println("\tLicense: " + carsArr[i].license);
        }
    }

}