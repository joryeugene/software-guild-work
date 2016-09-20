package com.jorypestorious.pbd.records;

import java.util.Scanner;

class Student {
    String name;
    int grade;
    double average;
}

public class LilDatabaseLoop {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Student[] studentDatabase = new Student[3];
        
        for (int i = 0; i < studentDatabase.length; i++) {
            studentDatabase[i] = new Student();
            System.out.print("Enter the student's name: ");
            studentDatabase[i].name = scan.nextLine();
            System.out.print("Enter the student's grade: ");
            studentDatabase[i].grade = scan.nextInt();
            System.out.print("Enter the student's average: ");
            studentDatabase[i].average = scan.nextDouble();
            scan.nextLine();
            System.out.println("");
        }
        
        scan.close();
        
        System.out.println("The names are: " + studentDatabase[0].name + ", " + studentDatabase[1].name + ", and " + studentDatabase[2].name);
        System.out.println("Their grades are: " + studentDatabase[0].grade + " " + studentDatabase[1].grade + " " + studentDatabase[2].grade);
        System.out.println("Their averages are: " + studentDatabase[0].average + " " + studentDatabase[1].average + " " + studentDatabase[2].average);
        
        System.out.println("\nThe average for the three students is: " + ((studentDatabase[0].average + studentDatabase[1].average + studentDatabase[2].average)/3));
    }

}