package com.jorypestorious.windowmasterv2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class WindowMasterV2 {
    
    public static double getInput(String prompt) {
        System.out.print(prompt + " ");
        Scanner scan = new Scanner(System.in);
        return scan.nextDouble();
    }
    
    public static double rangeCheck(double input) {
        if (input >= 0.5 && input <=50) {
            return input;
        } else {
            System.out.print("Input out of range.. try again: ");
            Scanner s = new Scanner(System.in);
            return rangeCheck(s.nextDouble());
        }
    }
    
    public static void main(String[] args) {
        double height = rangeCheck(getInput("Enter window height (in feet):"));
        double width = rangeCheck(getInput("Enter window width (in feet):"));
        double glassCost = getInput("Cost of the glass per square foot:");
        double trimCost = getInput("Cost of trim per linear foot:");

        double areaOfWindow = height * width;
        double perimeterOfWindow = 2 * (height + width);
        
        double costOfGlass = areaOfWindow * glassCost;
        double costOfTrim = perimeterOfWindow * trimCost;
        double totalCost = costOfGlass + costOfTrim;
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        System.out.println("\nWindow height is " + height + " ft and width is " + width + " ft");
        System.out.println("Window area is " + areaOfWindow + " ft² and perimeter is " + perimeterOfWindow + " ft");
        System.out.println("The glass cost is $" + df.format(glassCost) + " per square foot, making the total glass cost $" + df.format(costOfGlass));
        System.out.println("The trim cost is $" + df.format(trimCost) + " per linear foot, making the total trim cost $" + df.format(costOfTrim));
        System.out.println("The total overall cost is $" + df.format(totalCost));
    }
}
