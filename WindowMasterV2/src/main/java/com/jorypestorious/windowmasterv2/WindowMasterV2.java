package com.jorypestorious.windowmasterv2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WindowMasterV2 {
    
    public static double getInput(String prompt) {
        System.out.print(prompt + " ");
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }
    
    public static void main(String[] args) {
        double height = getInput("Enter window height (in feet):");
        double width = getInput("Enter window width (in feet):");
        double glassCost = getInput("Cost of the glass per square foot:");
        double trimCost = getInput("Cost of trim per linear foot:");

        Double areaOfWindow = height * width;
        Double perimeterOfWindow = 2 * (height + width);
        
        Double costOfGlass = areaOfWindow * glassCost;
        Double costOfTrim = perimeterOfWindow * trimCost;
        Double totalCost = costOfGlass + costOfTrim;
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        System.out.println("\nWindow height is " + height + " ft and width is " + width + " ft");
        System.out.println("Window area is " + areaOfWindow + " ft² and perimeter is " + perimeterOfWindow + " ft");
        System.out.println("The glass cost is $" + df.format(glassCost) + " per square foot, making the total glass cost $" + df.format(costOfGlass));
        System.out.println("The trim cost is $" + df.format(trimCost) + " per linear foot, making the total trim cost $" + df.format(costOfTrim));
        System.out.println("The total overall cost is $" + df.format(totalCost));
    }
}
