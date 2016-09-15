package com.jorypestorious.pbd.methods97;

public class HeronsFormula {

    public static void main(String[] args) {
        
        // Same output as the one without formulas, but this one with formulas is not as many lines
        // easier to fix changes with functions -- make change in one place
        double a;

        a = triangleArea(3, 3, 3);
        System.out.println("A triangle with sides 3,3,3 has an area of " + a);

        a = triangleArea(3, 4, 5);
        System.out.println("A triangle with sides 3,4,5 has an area of " + a);

        a = triangleArea(7, 8, 9);
        System.out.println("A triangle with sides 7,8,9 has an area of " + a);

        System.out.println("A triangle with sides 5,12,13 has an area of " + triangleArea(5, 12, 13));
        System.out.println("A triangle with sides 10,9,11 has an area of " + triangleArea(10, 9, 11));
        System.out.println("A triangle with sides 8,15,17 has an area of " + triangleArea(8, 15, 17));
        System.out.println("A triangle with sides 9,9,9 has an area of " + triangleArea(9, 9, 9));
        // easier with functions
    }

    public static double triangleArea(int a, int b, int c) {
        // the code in this function computes the area of a triangle whose sides have lengths a, b, and c
        double s, A;

        s = (a + b + c) / 2.0;
        A = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        return A;
    }
}
