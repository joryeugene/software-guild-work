package com.jorypestorious.pbd.keyboardinput;

import java.util.Scanner;

public class MoreUserInputOfData {
    public static void main(String[] args) {
        System.out.println("Please enter the following information so I can sell it for a profit!\n");
        Scanner scan = new Scanner(System.in);
        
        System.out.print("First name: ");
        String firstName = scan.nextLine();
        System.out.print("Last name: ");
        String lastName = scan.nextLine();
        System.out.print("Grade (9-12): ");
        int grade = scan.nextInt();
        System.out.print("Student ID: ");
        int studentID = scan.nextInt();
        System.out.print("Login: ");
        scan.nextLine(); // clear the space
        String login = scan.nextLine();
        System.out.print("GPA (0.0-4.0): ");
        Double gpa = scan.nextDouble();
        
        System.out.println("\nYour information:");
        System.out.println("    Login: " + login);
        System.out.println("    ID: " + studentID);
        System.out.println("    Name: " + lastName + ", " + firstName);
        System.out.println("    Grade: " + grade);
        System.out.println("    GPA: " + gpa);
    }
}
