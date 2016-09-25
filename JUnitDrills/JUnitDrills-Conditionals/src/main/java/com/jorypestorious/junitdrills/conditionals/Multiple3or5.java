package com.jorypestorious.junitdrills.conditionals;

public class Multiple3or5 {
//Return true if the given non-negative number is a multiple of 3 or a multiple of 5. Use the % "mod" operator
//
//multiple3or5(3) -> true
//multiple3or5(10) -> true
//multiple3or5(8) -> false

    public boolean multiple3or5(int number) {
        return number%3 == 0 || number%5 == 0;
    }

}
