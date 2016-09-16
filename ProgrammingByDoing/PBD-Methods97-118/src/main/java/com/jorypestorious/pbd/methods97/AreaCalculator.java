package com.jorypestorious.pbd.methods97;

import java.util.Scanner;

public class AreaCalculator {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Shape Area Calculator");
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            System.out.print("\n"
                    + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n"
                    + "\n"
                    + "1) Triangle\n"
                    + "2) Rectangle\n"
                    + "3) Square\n"
                    + "4) Circle\n"
                    + "5) Quit\n\n"
                    + "Which shape: ");
            
            int choice = scan.nextInt();
            System.out.println(""); // line break
            
            switch (choice) {
                case 1:
                    System.out.print("Base: ");
                    int base = scan.nextInt();
                    System.out.print("Height: ");
                    int height = scan.nextInt();
                    double triangleArea = area_triangle(base, height);
                    System.out.println("\nThe area is: " + triangleArea);
                    break;
                case 2:
                    System.out.print("Length: ");
                    int length = scan.nextInt();
                    System.out.print("Width: ");
                    int width = scan.nextInt();
                    int rectangleArea = area_rectangle(length, width);
                    System.out.println("\nThe area is: " + rectangleArea);
                    break;
                case 3:
                    System.out.print("Side length: ");
                    int squareArea = area_square(scan.nextInt());
                    System.out.println("\nThe area is: " + squareArea);
                    break;
                case 4:
                    System.out.print("Radius: ");
                    double circleArea = area_circle(scan.nextInt());
                    System.out.println("\nThe area is: " + circleArea);
                    break;
                case 5:
                    System.out.println("Goodbye.");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
        
    }
    
    public static double area_triangle( int base, int height ) {
        return (base * height) / 2;
    }
    
    public static int area_rectangle( int length, int width ) {
        return length * width;
    }
    
    public static int area_square( int side ) {
        return side * side;
    }
    
    public static double area_circle( int radius ) {
        return Math.PI * Math.pow(radius, 2);
    }
}

