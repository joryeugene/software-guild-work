package com.jorypestorious.addressbook.ui;

import java.util.Scanner;

public class ConsoleIO {
    
    private final Scanner scan = new Scanner(System.in);
    
    //////////////////// Input //////////////////////    
    public String promptString(String prompt) {
        System.out.print(prompt);
        String input = scan.nextLine();
        input = toTitleCase(input);
        return input;
    }
    
    public String promptStateCode(String prompt) {
        System.out.print(prompt);
        String input = scan.nextLine().toUpperCase().trim();
        while(input.length() != 2) {
            System.out.print("Enter a state code consisting of two characters: ");
            input = scan.nextLine().toUpperCase().trim();
        }
        return input;
    }
    
    public int promptInt(String prompt, int min, int max) {
        String errorMsg = "Enter a number between " + min + " and " + max + ": ";
        int input;
        System.out.print(prompt);
        
        do {
            while (!scan.hasNextInt()) {
                System.out.print(errorMsg);
                scan.next();
            }
            
            input = scan.nextInt();
            
            if (input > max || input < min) {
                System.out.print(errorMsg);
            }

        } while (input > max || input < min);
        
        clearBuffer();
        return input;
    }
    
    private void clearBuffer() {
        scan.nextLine();
    }
    
    private String toTitleCase(String str) {
        str = str.toLowerCase().trim();
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
            
            if (arr[i].length() > 0) {
                sb.append(Character.toUpperCase(arr[i].charAt(0)))
                  .append(arr[i].substring(1)).append(" ");
            }
        }
        
        return sb.toString().trim();
    }
    
    //////////////////// Output ////////////////////// 
    public void display(String str) {
        System.out.println(str);
    }

}
