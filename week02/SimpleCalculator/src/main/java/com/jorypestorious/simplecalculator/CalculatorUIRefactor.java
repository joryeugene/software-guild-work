
package com.jorypestorious.simplecalculator;

import java.util.Scanner;

public class CalculatorUIRefactor {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Calculator c = new Calculator();
        ConsoleIO io = new ConsoleIO();
        
        boolean running = true;
        String input,
               output;
        double op1,
               op2,
               calculation;
        
        do {
            input = io.promptString("\n'add', 'subtract', 'multiply', 'divide', or 'quit'? ");
            
            if (input.equalsIgnoreCase("quit")) {
                running = false;
            } else {
                op1 = io.promptDouble("First operand: ");
                op2 = io.promptDouble("Second operand: ");
                
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
                
                io.printString("> " + output);
            }
            
        } while (running);
        
        io.printString("\nThank you.");
    }
    
}
