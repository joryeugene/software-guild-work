package com.jorypestorious.typeconversions;

public class TypeIssues {
    public static void main(String[] args) {
        System.out.println(2000000000 + 500000000);
        System.out.println(2000000000L + 500000000);
        System.out.println(2.5 / 0);
        System.out.println(0.0 / 0.0);
    }
}
