package com.jorypestorious.pbd.keyboardinput;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICalculator {
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
        
        DecimalFormat df = new DecimalFormat("0.00");
        
        System.out.println("Your BMI is " + df.format(bmi));
    }
}
