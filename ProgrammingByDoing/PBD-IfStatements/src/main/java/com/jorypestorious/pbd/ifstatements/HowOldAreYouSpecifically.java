package com.jorypestorious.pbd.ifstatements;

import java.util.Scanner;

public class HowOldAreYouSpecifically {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Hey, what's your name? ");
        String name = scan.nextLine();
        System.out.print("\nOk, " + name +", how old are you? ");
        int age = scan.nextInt();
        System.out.println(""); // Insert blank line
        
        if (age < 16) {
            System.out.println("You can't drive.");
        } else if (age < 18) {
            System.out.println("You can drive but not vote.");
        } else if (age < 25) {
            System.out.println("You can vote but not rent a car.");
        } else {
            System.out.println("You can do pretty much anything.");
        }
    }
}
