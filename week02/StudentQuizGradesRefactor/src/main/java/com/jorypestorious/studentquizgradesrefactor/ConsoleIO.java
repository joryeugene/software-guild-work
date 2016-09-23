package com.jorypestorious.studentquizgradesrefactor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ConsoleIO {
    
    private final Scanner scan;
    
    ConsoleIO() {
        this.scan = new Scanner(System.in);
    }
    
    //////////////////// Output ////////////////////// 
    public void display(String str) {
        System.out.println(str);
    }
    
    public void displayAllStudents(HashMap<String, ArrayList<Integer>> studentQuizGrades) {
        System.out.println("      Students       \n" +
                           "---------------------");
        for (String name : studentQuizGrades.keySet()) {
            System.out.println("   " + name);
        }
        
        System.out.println("---------------------");
    }
    
    public void displayAllStudentsQuizGrades(HashMap<String, ArrayList<Integer>> studentQuizGrades) {
        System.out.println("                          Student Quiz Scores                            \n" +
                           "-------------------------------------------------------------------------");
        
        int currentGrade;
        for (String name : studentQuizGrades.keySet()) {
            
            System.out.print(name + ":\t");
            if (name.length() < 15) System.out.print("\t");
            if (name.length() < 7) System.out.print("\t");
            
            for (int i = 0; i < studentQuizGrades.get(name).size(); i++) {
                System.out.print("Q" + (i+1) + ": ");
                currentGrade = studentQuizGrades.get(name).get(i);
                System.out.print(currentGrade);
                
                if (currentGrade < 10) System.out.print("  ");
                else if (currentGrade < 100) System.out.print(" ");
                System.out.print(" | ");
            }
            
            if (studentQuizGrades.get(name).size() < 1) {
                System.out.print("No Quiz Scores Recorded");
            }
            
            System.out.println(""); // line break;
        }
        
        System.out.println("-------------------------------------------------------------------------");
    }
    
    public void displaySpecificStudentsQuizGrades(HashMap<String, ArrayList<Integer>> studentQuizGrades, String name) {
        int currentGrade;
        
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.print(name + ":\t");
        
        if (name.length() < 15) System.out.print("\t");
        if (name.length() < 7) System.out.print("\t");
        
        for (int i = 0; i < studentQuizGrades.get(name).size(); i++) {
            System.out.print("Q" + (i+1) + ": ");
            currentGrade = studentQuizGrades.get(name).get(i);
            System.out.print(currentGrade);
            
            if (currentGrade < 10) System.out.print("  ");
            else if (currentGrade < 100) System.out.print(" ");
            System.out.print(" | ");
        }
        
        if (studentQuizGrades.get(name).size() < 1) {
            System.out.print("No Quiz Scores Recorded");
        }
        
        System.out.println("\n-------------------------------------------------------------------------");
    }
    
    public void displayStudentAverages(HashMap<String, String> students, String note, int count, int total) {
        System.out.println("\n                   " + note + "                      \n" +
                           "-------------------------------------------------------------------------");
        
        int currentGrade;
        for (String name : students.keySet()) {
            System.out.print(name + ":\t");
            if (name.length() < 15) System.out.print("\t");
            if (name.length() < 7) System.out.print("\t");
            
            System.out.println("Avg: " + students.get(name));
        }
        
        System.out.println("\nNumber of Students: " + count + " out of " + total);
        
        System.out.println("-------------------------------------------------------------------------");
    }
    
    //////////////////// Input //////////////////////    
    public String promptString(String prompt) {
        System.out.print(prompt);
        String input = scan.nextLine();
        input = toTitleCase(input);
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
    
    public int promptIntWithResult(String prompt, int min, int max, String result) {
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
        
        System.out.println(result + input);
        clearBuffer();
        return input;
    }
    
    public void clearBuffer() {
        scan.nextLine();
    }
    
    public static String toTitleCase(String str) {
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

}
