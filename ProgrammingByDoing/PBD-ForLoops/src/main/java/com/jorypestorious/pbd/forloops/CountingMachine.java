package com.jorypestorious.pbd.forloops;

import java.util.Scanner;

public class CountingMachine {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Count to: ");
        int n = scan.nextInt();
        for (int i = 0; i <= n; i++) {
            System.out.print(i + " ");
        }
    }
}
