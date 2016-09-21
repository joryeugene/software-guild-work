package com.jorypestorious.simplecalculator;

import java.util.Scanner;

public class ConsoleIO {
    
    Scanner scan = new Scanner(System.in);
    
    public int promptInt(String prompt) {
        System.out.print(prompt);
        
        while (!scan.hasNextInt()) {
            System.out.print("Enter a number: ");
            scan.next();
        }
        
        int input = scan.nextInt();
        clearBuffer();
        return input;
    }
    
    public int promptInt(String prompt, int min, int max) {
        int input;
        
        do {
            System.out.print(prompt);
            while (!scan.hasNextInt()) {
                System.out.print("Enter a number between " + min + " and " + max);
                scan.next();
            }
            input = scan.nextInt();
        } while (input > max || input < min);
        
        clearBuffer();
        return input;
    }
    
    public String promptString(String prompt) {
        System.out.print(prompt);
        return scan.nextLine();
    }
    
    public float promptFloat(String prompt) {
        System.out.print(prompt);
        
        while (!scan.hasNextFloat()) {
            System.out.print("Enter a number: ");
            scan.next();
        }
        
        float input = scan.nextFloat();
        clearBuffer();
        return input;
    }
    
    public float promptFloat(String prompt, float min, float max) {
        float input;
        
        do {
            System.out.print(prompt);
            while (!scan.hasNextFloat()) {
                System.out.print("Enter a number between " + min + " and " + max);
                scan.next();
            }
            input = scan.nextFloat();
        } while (input > max || input < min);
        
        clearBuffer();
        return input;
    }
    
    public double promptDouble(String prompt) {
        System.out.print(prompt);
        
        while (!scan.hasNextDouble()) {
            System.out.print("Enter a number: ");
            scan.next();
        }
        
        double input = scan.nextDouble();
        clearBuffer();
        return input;
    }
    
    public double promptDouble(String prompt, double min, double max) {
        double input;
        
        do {
            System.out.print(prompt);
            while (!scan.hasNextDouble()) {
                System.out.print("Enter a number between " + min + " and " + max);
                scan.next();
            }
            input = scan.nextDouble();
        } while (input > max || input < min);
        
        clearBuffer();
        return input;
    }
    
    public void printString(String out) {
        System.out.println(out);
    }
    
    public void clearBuffer() {
        scan.nextLine();
    }
    
}