package com.jorypestorious.projecteuler;

public class Euler004 {
    
    //A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
    
    //Find the largest palindrome made from the product of two 3-digit numbers.
    
    public static void main(String[] args) {
        
        int max = -1;
        
        for (int i = 999; i >= 100; i--) {
            for (int j = 999; j >= 100; j--) {
                if (checkIfPalindrome(i*j)) {
                    if (max < i*j) max = i*j;
                }
            }
        }
        
        System.out.println(max); // 906609
    }
    
    static boolean checkIfPalindrome(int n) {
        String num = Integer.toString(n);
        String firstHalf;
        String secondHalf;
        
        if (num.length() == 6) {
            firstHalf = num.substring(0,3);
            secondHalf = "" + num.charAt(5) + num.charAt(4) + num.charAt(3);
        } else {
            firstHalf = num.substring(0,2);
            secondHalf = "" + num.charAt(4) + num.charAt(3);
        }
        
        if (firstHalf.equals(secondHalf)) return true;
        else return false;
    }
    
}

