package com.jorypestorious.pbd.ifstatements;

import java.util.Scanner;

public class GenderGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("What is your gender (M or F): ");
        String gender = scan.nextLine();
        System.out.print("First name: ");
        String firstName = scan.nextLine();
        System.out.print("Last name: ");
        String lastName = scan.nextLine();
        System.out.print("Age: ");
        int age = scan.nextInt();
        
        String married = "n";
        
        if (gender.equals("F") && age >= 20) {
            System.out.print("\n" + firstName + ", are you married? (y/n) ");
            scan.nextLine(); // clear after nextInt
            married = scan.nextLine();
        }
        
        String personalAddress = "";
        
        if (gender.equals("F")) {
            if (married.equals("y")) personalAddress = "Mrs. " + lastName;
            else if (age >= 20) personalAddress = "Ms. " + lastName;
            else personalAddress = firstName + " " + lastName;
        }
        
        if (gender.equals("M")) {
            if (age >= 20) personalAddress = "Mr. " + lastName;
            else personalAddress = firstName + " " + lastName;
        }
        
        System.out.println("Then I shall call you " + personalAddress);
    }
}
