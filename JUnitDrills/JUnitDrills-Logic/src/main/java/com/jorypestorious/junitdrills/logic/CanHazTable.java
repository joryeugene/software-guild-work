package com.jorypestorious.junitdrills.logic;

public class CanHazTable {
    
//    You and your date are trying to get a table at a restaurant. The parameter "you" is the stylishness 
//of your clothes, in the range 0..10, and "date" is the stylishness of your date's clothes. The result 
//getting the table is encoded as an int value with 0=no, 1=maybe, 2=yes. If either of you is very stylish, 
//8 or more, then the result is 2 (yes). With the exception that if either of you has style of 2 or less, 
//then the result is 0 (no). Otherwise the result is 1 (maybe). 
//
//canHazTable(5, 10) → 2
//canHazTable(5, 2) → 0
//canHazTable(5, 5) → 1

    public int canHazTable(int yourStyle, int dateStyle) {
        
        if (dateStyle <= 2 || yourStyle <= 2) return 0;
        if (dateStyle >= 8 || yourStyle >= 8) return 2;
        return 1;
    }

}