package com.jorypestorious.pbd.ifstatements;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICategories {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Your height (feet only): ");
        Double feet = scan.nextDouble();
        System.out.print("Your height (inches): ");
        Double inches = scan.nextDouble();
        System.out.print("Your weight in pounds: ");
        Double weight = scan.nextDouble();
        
        Double totalInches = feet * 12 + inches;
        Double meters = totalInches * 0.0254;
        Double kilograms = weight * 0.453592;
        Double bmi = kilograms / (meters * meters);
        
        String category = "";
        
        if (bmi < 18.5) category = "underweight";
        if (bmi >= 18.5 && bmi < 25) category = "normal weight";
        if (bmi >= 25 && bmi < 30) category = "overweight";
        if (bmi >= 30) category = "obese";
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        System.out.println("Your BMI is " + df.format(bmi));
        System.out.println("BMI Category: " + category);
    }
}
