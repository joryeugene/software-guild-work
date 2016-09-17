package com.jorypestorious.pbd.methods97;

import java.util.Scanner;

public class CalculatorProject {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        double a, b, c;
        String op;
        boolean keepRunning = true;
        
        System.out.println("Six-function Calculator +-*/^%");
        System.out.println("     Example: 2 ^ 3");
        System.out.println("     Exit by typing: 0 + 0\n");

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
                case "^":
                    pow(a,b);
                    break;
                case "%":
                    mod(a,b);
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
    
    static void pow(double a, double b) {
        System.out.println(Math.pow(a, b));
    }
    
    static void mod(double a, double b) {
        System.out.println(a % b);
    }
}
