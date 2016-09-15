package com.jorypestorious.pbd.whileloops;

import java.util.Scanner;

public class CountingWhile {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Type in a message, and I'll display it however many times you want.");
        System.out.print("Message: ");
        String message = keyboard.nextLine();
        System.out.print("How many times? ");
        int times = keyboard.nextInt();

        int n = 10;
        int max = times * 10 + 1;
        while (n < max) {
            System.out.println((n) + ". " + message);
            n+=10;
        }

    }
}
