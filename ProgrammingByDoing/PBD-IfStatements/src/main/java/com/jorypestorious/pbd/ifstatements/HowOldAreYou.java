package com.jorypestorious.pbd.ifstatements;

import java.util.Scanner;

public class HowOldAreYou {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Hey, what's your name? ");
        String name = scan.nextLine();
        System.out.print("\nOk, " + name +", how old are you? ");
        int age = scan.nextInt();
        System.out.println(""); // Insert blank line
        
        if (age < 16) System.out.println("You can't drive.");
        if (age < 18) System.out.println("You can't vote.");
        if (age < 25) System.out.println("You can't rent a car.");
        if (age >= 25) System.out.println("You can do anything that's legal.");
    }
}
