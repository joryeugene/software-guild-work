package com.jorypestorious.pbd.ifstatements;

import java.util.Scanner;

public class AgeMessages3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Your name: ");
        String name = scan.nextLine();
        System.out.print("\nYour age: ");
        int age = scan.nextInt();
        System.out.println(""); // Insert blank line
        
        if (age > 0 && age < 16) {
            System.out.println("You can't drive.");
        }
        if (age >= 16 && age < 18) {
            System.out.println("You can drive but not vote.");
        } 
        if (age >= 18 && age < 25) {
            System.out.println("You can vote but not rent a car.");
        }
        if (age >= 25 && age < 100) {
            System.out.println("You can do pretty much anything.");
        }
    }
}
