package com.jorypestorious.interestcalculator;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("QUARTERLY INTEREST CALCULATOR");
        System.out.println("Enter numbers without any formatting (no % or ,)\n");
        System.out.print("Annual interest rate: ");
        double interestRate = scan.nextDouble();
//        quarterly, monthly, or daily
//interest compound periods. 
        
        System.out.print("Initial principal: ");
        double principal = scan.nextDouble();
        System.out.print("Number of years money will stay in fund: ");
        int years = scan.nextInt();
        
        Calendar now = Calendar.getInstance();   // Gets the current date and time
        int currentYear = now.get(Calendar.YEAR);
        int targetYear = currentYear + years;
        
        DecimalFormat df = new DecimalFormat("###,##0.00");
        
        System.out.println("\nYear\tStarting\tInterest\tYear-end");
        System.out.println("-------------------------------------------------------------");
        while (currentYear != targetYear) {
            System.out.print(currentYear + "\t");
            currentYear++;
            System.out.print("$" + df.format(principal) + "\t");
            if ( principal < 1000) System.out.print("\t");
            double tempPrincipal = principal;
            for (int i = 0; i < 4 ; i++) {
                principal *= (1 + ((interestRate/4) / 100));
            }
            double yearInterest = principal - tempPrincipal;
            System.out.print("$" + df.format(yearInterest) + "\t");
            if (yearInterest < 1000) System.out.print("\t");
            System.out.println("$" + df.format(principal) + "\t");
        }
    }
}