package com.jorypestorious.pbd.forloops;

import java.util.Scanner;

public class AddingValuesForLoop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Number: ");
        int n = scan.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.print("\nThe sum is " + sum);
    }
}