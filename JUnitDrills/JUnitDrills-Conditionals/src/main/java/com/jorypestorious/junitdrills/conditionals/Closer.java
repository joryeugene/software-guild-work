package com.jorypestorious.junitdrills.conditionals;

public class Closer {
//Given 2 int values, return whichever value is nearest to the value 10, or return 0 in the event of a tie. 
//
//closer(8, 13) -> 8
//closer(13, 8) -> 8
//closer(13, 7) -> 0

    public int closer(int a, int b) {
        if (Math.abs(10-a)==Math.abs(10-b)) return 0;
        return (Math.abs(10-a) < Math.abs(10-b)) ? a : b;
    }

}
