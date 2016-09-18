package com.jorypestorious.unitoneskillcheck;


public class AreTheyTrue {
    
    public static void main(String[] args) {
        
        AreTheyTrue obj = new AreTheyTrue();
        
        System.out.println("Are they true?\n--------------");
        
        System.out.println("true and true: " + obj.howTrue(true,true));
        System.out.println("false and false: " + obj.howTrue(false,false));
        System.out.println("true and false: " + obj.howTrue(true,false));
        System.out.println("false and true: " + obj.howTrue(false,true));
        
    }
    
    String howTrue(boolean first, boolean second) {
        if (first && second) return "BOTH";
        else if (first || second) return "ONLY ONE";
        else return "NEITHER";
    }

}