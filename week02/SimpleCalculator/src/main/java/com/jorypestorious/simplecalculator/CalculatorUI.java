package com.jorypestorious.simplecalculator;

import java.util.Scanner;

public class CalculatorUI {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator c = new Calculator();
        
        boolean running = true;
        String input,
                output;
        double op1,
                op2,
                calculation = 0.0;
        
        do {
            System.out.print("\n'add', 'subtract', 'multiply', 'divide', or 'quit'? ");
            input = scan.next();
            
            if (input.equalsIgnoreCase("quit")) {
                running = false;
            } else {
                System.out.print("Two operands: ");
                op1 = scan.nextDouble();
                op2 = scan.nextDouble();
                
                switch(input) {
                    case "add":
                        calculation = c.add(op1, op2);
                        break;
                    case "subtract":
                        calculation = c.subtract(op1, op2);
                        break;
                    case "divide":
                        calculation = c.divide(op1, op2);
                        break;
                    case "multiply":
                        calculation = c.multiply(op1, op2);
                        break;
                    default:
                        calculation = -Math.PI;
                        break;
                }
                
                output = (calculation == -Math.PI) ? "Invalid" : Double.toString(calculation);
                
                System.out.println("> " + output);
            }
            
        } while (running);
        
        System.out.println("\nThank you.");
    }
    
}
