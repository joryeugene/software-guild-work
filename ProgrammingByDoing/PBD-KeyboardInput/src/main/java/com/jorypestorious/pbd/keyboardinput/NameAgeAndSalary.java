package com.jorypestorious.pbd.keyboardinput;

import java.util.Scanner;

public class NameAgeAndSalary {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello. What is your name?");
        String inputName = scan.nextLine();
        System.out.println("Hi " + inputName + "! How old are you?");
        Short inputAge = scan.nextShort();
        System.out.println("So you're " + inputAge + "? Awesome! Same as me!");
        System.out.println("How much do you make per year?");
        int inputSalary = scan.nextInt();
        System.out.println(inputSalary + "! Please give me some money!");
    }
}
