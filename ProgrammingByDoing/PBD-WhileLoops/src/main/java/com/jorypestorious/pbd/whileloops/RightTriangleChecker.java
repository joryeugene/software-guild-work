package com.jorypestorious.pbd.whileloops;

import java.util.Scanner;

public class RightTriangleChecker {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int side1, side2, side3;
        
        System.out.println("RIGHT TRIANGLE CHECKER");
        System.out.println("Enter three integers in ascending order for each side of the triangle: ");
        System.out.print("Side 1: ");
        side1 = scan.nextInt();
        
        do {
            System.out.print("Side 2: ");
            side2 = scan.nextInt();
            
            if (side1 > side2) {
                System.out.println(side2 + " is smaller than " + side1 + ". Try again.");
            }
        } while (side1 > side2);
        
        do {
            System.out.print("Side 3: ");
            side3 = scan.nextInt();
            
            if (side2 > side3) {
                System.out.println(side3 + " is smaller than " + side2 + ". Try again.");
            }
        } while (side2 > side3);
        
        System.out.println("Your three sides are " + side1 + " " + side2 + " " + side3);
        
        double rightTriangleTest = Math.sqrt((side1 * side1) + (side2 * side2));
        
        if (rightTriangleTest == side3) {
            System.out.println("These sides *do* make a right triangle. Yippy-skippy!");
        } else {
            System.out.println("NO! These sides do not make a right triangle!");
        }
    }
}
