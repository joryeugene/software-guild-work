package com.jorypestorious.interestcalculator;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Scanner;

public class InterestCalculator {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n            =========================\n" +
                             "               INTEREST CALCULATOR   \n" +
                             "            =========================\n");
        
        System.out.print("Annual interest rate: ");
        double interestRate = scanCurrencyAndPercentage();
        
        boolean invalidInput;
        int compoundPeriodCode;
                
        do {
            System.out.print("Compound period (quarterly, monthly, or daily): ");
            String compoundPeriod = scan.nextLine();
            compoundPeriodCode = getCompoundPeriodCode(compoundPeriod);
            
            invalidInput = false;
            if (compoundPeriodCode == 0) invalidInput = true;
            
        } while (invalidInput);
        
        System.out.print("Initial principal: ");
        double principal = scanCurrencyAndPercentage();
        
        System.out.print("Number of years money will stay in fund: ");
        int years = scan.nextInt();
        
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        int targetYear = currentYear + years;
        
        DecimalFormat df = new DecimalFormat("###,##0.00");
        
        System.out.println("\nYear\tStarting\tInterest\tYear-end\n" +
                           "-----------------------------------------------------");
        
        while (currentYear != targetYear) {
            System.out.print(currentYear + "\t");
            currentYear++;
            
            System.out.print("$" + df.format(principal) + "\t");
            if (principal < 1000) System.out.print("\t");
            
            double oldPrincipal = principal;
            
            for (int i = 0; i < compoundPeriodCode ; i++) {
                principal *= (1 + ((interestRate / compoundPeriodCode) / 100));
            }
            
            double yearInterest = principal - oldPrincipal;
            System.out.print("$" + df.format(yearInterest) + "\t");
            if (yearInterest < 1000) System.out.print("\t");
            
            System.out.println("$" + df.format(principal));
        }
        
        System.out.println("-----------------------------------------------------\n");
    }
    
    static double scanCurrencyAndPercentage() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return Double.parseDouble(input.replaceAll("[$,%]", ""));
    }
    
    static int getCompoundPeriodCode(String compoundPeriod) {
        switch (compoundPeriod) {
                case "quarterly":
                    return 4;
                case "monthly":
                    return 12;
                case "daily":
                    return 365;
                default:
                    System.out.println("INVALID INPUT");
                    return 0;
            }
    }
    
}