package com.jorypestorious.typeconversions;

public class TypeIssues {
    public static void main(String[] args) {
        System.out.println(2000000000 + 500000000);
        System.out.println(2000000000L + 500000000);
        System.out.println(2.5 / 0);
        System.out.println(0.0 / 0.0);
        System.out.println("3.14 + 4 == 7.14 is " + (3.14 + 4 == 7.14)); // false
        // equality tests for doubles/floats are dangerous due to rounding/precisions issues
        double x = 3.14, y = 4, z = x + y;
        System.out.println(z);
        // 7.140000000000001
    }
}
