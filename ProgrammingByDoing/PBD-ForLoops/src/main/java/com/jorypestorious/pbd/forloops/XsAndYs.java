package com.jorypestorious.pbd.forloops;

public class XsAndYs {
    public static void main(String[] args) {
        System.out.println("x       y\n" +
                           "--------------");
        for (double i = -10; i <= 10; i+=0.5) {
            System.out.println(i + "\t" + (i*i));
        }
    }
}
