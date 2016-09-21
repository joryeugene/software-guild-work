package com.jorypestorious.simplecalculator;

import java.util.Scanner;

public class ConsoleIO {
    
    Scanner scan = new Scanner(System.in);
    
    public int promptInt(String prompt) {
        System.out.print(prompt);
        return scan.nextInt();
    }
    
    public int promptInt(String prompt, int min, int max) {
        int input;
        System.out.print(prompt);
        input = scan.nextInt();
        
        while (input > max || input < min) {
            System.out.print("Number must be between " + min + " and " + max);
        }
        
        return input;
    }
    
    public String promptString(String prompt) {
        System.out.print(prompt);
        return scan.next();
    }
    
    public float promptFloat(String prompt) {
        System.out.print(prompt);
        return scan.nextFloat();
    }
    
    public float promptFloat(String prompt, float min, float max) {
        float input;
        System.out.print(prompt);
        input = scan.nextFloat();
        
        while (input > max || input < min) {
            System.out.print("Number must be between " + min + " and " + max);
        }
        
        return input;
    }
    
    public double promptDouble(String prompt) {
        System.out.print(prompt);
        return scan.nextDouble();
    }
    
    public double promptDouble(String prompt, double min, double max) {
        double input;
        System.out.print(prompt);
        input = scan.nextDouble();
        
        while (input > max || input < min) {
            System.out.print("Number must be between " + min + " and " + max);
        }
        
        return input;
    }
    
    public void printString(String prompt) {
        System.out.println(prompt);
    }

}