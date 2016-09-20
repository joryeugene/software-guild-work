package com.jorypestorious.pbd.records;

import java.util.Scanner;

class Student {
    String name;
    int grade;
    double average;
}

public class BasicRecords {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        
        System.out.print("Enter the first student's name: ");
        student1.name = scan.nextLine();
        System.out.print("Enter the first student's grade: ");
        student1.grade = scan.nextInt();
        System.out.print("Enter the first student's average: ");
        student1.average = scan.nextDouble();
        
        scan.nextLine();
        System.out.println("");
        
        System.out.print("Enter the second student's name: ");
        student2.name = scan.nextLine();
        System.out.print("Enter the second student's grade: ");
        student2.grade = scan.nextInt();
        System.out.print("Enter the second student's average: ");
        student2.average = scan.nextDouble();
        
        scan.nextLine();
        System.out.println("");
        
        System.out.print("Enter the third student's name: ");
        student3.name = scan.nextLine();
        System.out.print("Enter the third student's grade: ");
        student3.grade = scan.nextInt();
        System.out.print("Enter the third student's average: ");
        student3.average = scan.nextDouble();
        
        scan.close();
        System.out.println("");
        
        System.out.println("The names are: " + student1.name + ", " + student2.name + ", and " + student3.name);
        System.out.println("Their grades are: " + student1.grade + " " + student2.grade + " " + student3.grade);
        System.out.println("Their averages are: " + student1.average + " " + student2.average + " " + student3.average);
        
        System.out.println("\nThe average for the three students is: " + ((student1.average + student2.average + student3.average)/3));
    }

}