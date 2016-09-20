package com.jorypestorious.pbd.records;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

class StudentRecord {
    int id;
    int year;
    int grade;
    String letterGrade;
}

public class SortingRecordsOnTwoFields {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Open which file: ");
        String filename = scan.nextLine();
        scan.close();
        
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        
        StudentRecord[] records = new StudentRecord[30];
        
        for (int i = 0; i < records.length; i++) {
            records[i] = new StudentRecord();
            records[i].id = scanFile.nextInt();
            records[i].year = scanFile.nextInt();
            records[i].grade = scanFile.nextInt();
            records[i].letterGrade = scanFile.next();
        }
        scanFile.close();
        
        System.out.println("\nData loaded.");
        
        selection_sort_id(records);
        selection_sort_year(records);
        
        System.out.println("Data sorted.\n");
        
        System.out.println("Here are the sorted grades:");
        
        for (int i = 0; i <records.length; i++) {
            System.out.println("\t" + records[i].id + " " + records[i].year + " " + records[i].grade + " " + records[i].letterGrade);
        }
    }
    
    private static void selection_sort_id(StudentRecord[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int index = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[index].id > a[j].id) index = j;
            }
            if (i != index) swap(a,i,index);
        }
    }
    
    private static void selection_sort_year(StudentRecord[] a) {
        for (int i = 0; i < a.length-1; i++) {
            int index = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[index].id == a[j].id && a[index].year > a[j].year) index = j;
            }
            if (i != index) swap(a,i,index);
        }
    }
    
    private static void swap(StudentRecord[] a, int i, int j) {
        StudentRecord temp = new StudentRecord();
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}

