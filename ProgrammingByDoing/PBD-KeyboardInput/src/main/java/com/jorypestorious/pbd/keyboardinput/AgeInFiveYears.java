package com.jorypestorious.pbd.keyboardinput;

import java.util.Scanner;

public class AgeInFiveYears {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Hello.  What is your name? ");
        String inputName = scan.nextLine();
        System.out.print("\nHi " + inputName + "! How old are you? ");
        int inputAge = scan.nextInt();
        int futureAge = inputAge + 5;
        int pastAge = inputAge - 5;
        System.out.println("\nDid you know that in five years you will be " + futureAge + " years old?");
        System.out.println("And five years ago you were " + pastAge + "! Imagine that!");
    }
}
