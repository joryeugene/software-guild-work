package com.jorypestorious.pbd.methods97;

import java.util.Scanner;

public class BabyCalculator {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        double a, b, c;
        String op;
        boolean keepRunning = true;
        
        System.out.println("Four-function Calculator +-*/");
        System.out.println("       Ex: 4 + 2\n");

        do {
            System.out.print("> ");
            a = keyboard.nextDouble();
            op = keyboard.next();
            b = keyboard.nextDouble();

            if (a == 0) keepRunning = false;
            
            switch (op) {
                case "+":
                    add(a,b);
                    break;
                case "*":
                    multiply(a,b);
                    break;
                case "-":
                    subtract(a,b);
                    break;
                case "/":
                    divide(a,b);
                    break;
                
                default:
                    System.out.println("INVALID INPUT");
            }

        } while (keepRunning);
        
        System.out.println("\nBye.");
    }
    
    static void add(double a, double b) {
        System.out.println(a + b);
    }
    
    static void divide(double a, double b) {
        System.out.println(a / b);
    }
    
    static void subtract(double a, double b) {
        System.out.println(a - b);
    }
    
    static void multiply(double a, double b) {
        System.out.println(a * b);
    }
}
