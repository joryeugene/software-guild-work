package com.jorypestorious.windowmasterv2;

import java.util.Scanner;

public class WindowMasterV2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter window height (in feet):");
        Double height = scan.nextDouble();
        System.out.println("Enter window width (in feet):");
        Double width = scan.nextDouble();
        System.out.println("Cost of the glass per square foot:");
        Double glassCost = scan.nextDouble();
        System.out.println("Cost of trim per linear foot:");
        Double trimCost = scan.nextDouble();
        
        Double areaOfWindow = height * width;
        Double perimeterOfWindow = 2 * (height + width);
        
        Double costOfGlass = areaOfWindow * glassCost;
        Double costOfTrim = perimeterOfWindow * trimCost;
        Double totalCost = costOfGlass + costOfTrim;
        
        System.out.println("Window height is " + height + " and width is " + width);
        System.out.println("Window area is " + areaOfWindow + " and perimeter is " + perimeterOfWindow);
        System.out.println("The glass cost is $" + glassCost + " per square foot, making the total glass cost $" + costOfGlass);
        System.out.println("The trim cost is $" + trimCost + " per linear foot, making the total trim cost $" + costOfTrim);
        System.out.println("The total overall cost is $" + totalCost);       
    }
}
