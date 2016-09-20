package com.jorypestorious.pbd.records;

import java.util.Scanner;

//class Student {
//    String name;
//    int grade;
//    double average;
//}

public class LilDatabase {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Student[] studentDatabase = new Student[3];
        
        studentDatabase[0] = new Student();
        System.out.print("Enter the first student's name: ");
        studentDatabase[0].name = scan.nextLine();
        System.out.print("Enter the first student's grade: ");
        studentDatabase[0].grade = scan.nextInt();
        System.out.print("Enter the first student's average: ");
        studentDatabase[0].average = scan.nextDouble();
        
        scan.nextLine();
        System.out.println("");
        
        studentDatabase[1] = new Student();
        System.out.print("Enter the second student's name: ");
        studentDatabase[1].name = scan.nextLine();
        System.out.print("Enter the second student's grade: ");
        studentDatabase[1].grade = scan.nextInt();
        System.out.print("Enter the second student's average: ");
        studentDatabase[1].average = scan.nextDouble();
        
        scan.nextLine();
        System.out.println("");
        
        studentDatabase[2] = new Student();
        System.out.print("Enter the third student's name: ");
        studentDatabase[2].name = scan.nextLine();
        System.out.print("Enter the third student's grade: ");
        studentDatabase[2].grade = scan.nextInt();
        System.out.print("Enter the third student's average: ");
        studentDatabase[2].average = scan.nextDouble();
        
        scan.close();
        System.out.println("");
        
        System.out.println("The names are: " + studentDatabase[0].name + ", " + studentDatabase[1].name + ", and " + studentDatabase[2].name);
        System.out.println("Their grades are: " + studentDatabase[0].grade + " " + studentDatabase[1].grade + " " + studentDatabase[2].grade);
        System.out.println("Their averages are: " + studentDatabase[0].average + " " + studentDatabase[1].average + " " + studentDatabase[2].average);
        
        System.out.println("\nThe average for the three students is: " + ((studentDatabase[0].average + studentDatabase[1].average + studentDatabase[2].average)/3));
    }

}