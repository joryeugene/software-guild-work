package com.jorypestorious.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleIO {
    
    public void display(String str) {
        System.out.println(str);
    }
    
    public void displayAllStudentsQuizGrades(HashMap<String, ArrayList<Integer>> studentQuizGrades) {
        int currentGrade;
        for (String name : studentQuizGrades.keySet()) {
            
            System.out.print(name + ":\t");
            if (name.length() < 13) System.out.print("\t");
            
            for (int i = 0; i < studentQuizGrades.get(name).size(); i++) {
                System.out.print("Q" + (i+1) + ": ");
                currentGrade = studentQuizGrades.get(name).get(i);
                System.out.print(currentGrade);
                if (currentGrade < 10) System.out.print("  ");
                else if (currentGrade < 100) System.out.print(" ");
                System.out.print(" | ");
            }
            
            System.out.println(""); // line break
        }
    }
    
    public void displayAllStudents(HashMap<String, ArrayList<Integer>> studentQuizGrades) {
        System.out.print("      Students       \n" +
                           "---------------------");
        for (String name : studentQuizGrades.keySet()) {
            System.out.println("   " + name);
        }
    }
    
    //////////////////// Input //////////////////////
    
    Scanner scan = new Scanner(System.in);
    
    public String promptString(String prompt) {
        System.out.print(prompt);
        String input = scan.nextLine();
        input = toTitleCase(input);
        return input;
    }
    
    public String promptStringWithResult(String prompt, String result) {
        System.out.print(prompt);
        String input = scan.nextLine();
        input = toTitleCase(input);
        System.out.println(result + input);
        return input;
    }
    
    public int promptInt(String prompt, int min, int max) {
        int input;
        System.out.print(prompt);
        
        do {
            while (!scan.hasNextInt()) {
                System.out.print("Enter a number between " + min + " and " + max);
                scan.next();
            }
            
            input = scan.nextInt();
            
            if (input > max || input < min) {
                System.out.print("Enter a selection between " + min + " and " + max);
            }

        } while (input > max || input < min);
        
        clearBuffer();
        return input;
    }
    
    public void clearBuffer() {
        scan.nextLine();
    }
    
    public static String toTitleCase(String str) {
        str = str.toLowerCase();
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            sb.append(Character.toUpperCase(arr[i].charAt(0)))
                    .append(arr[i].substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

}
