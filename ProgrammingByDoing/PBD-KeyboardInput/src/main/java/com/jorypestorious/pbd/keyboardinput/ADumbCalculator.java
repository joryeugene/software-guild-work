package com.jorypestorious.pbd.keyboardinput;

import java.util.Scanner;

public class ADumbCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your first number? ");
        Double num1 = scan.nextDouble();
        System.out.print("What is your second number? ");
        Double num2 = scan.nextDouble();
        System.out.print("What is your third number? ");
        Double num3 = scan.nextDouble();
        Double total = (num1 + num2 + num3) / 2;
        System.out.print("\n( " + num1 + " + " + num2 + " + " + num3 + " ) / 2 is... " + total);
    }
}
