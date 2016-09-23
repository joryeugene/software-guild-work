package com.jorypestorious.studentquizgradesrefactor;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadSaveFile {
    
    public HashMap readFileToHashMap(String filename) {
        
        HashMap<String, ArrayList<Integer>> studentQuizGrades = new HashMap<>();
        
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
            String currentStudent;
            
            while (scanFile.hasNext()) {
                currentStudent = scanFile.nextLine();
                studentQuizGrades.put(currentStudent, new ArrayList());
                
                while (scanFile.hasNextInt()) {
                    studentQuizGrades.get(currentStudent).add(scanFile.nextInt());
                }
                
                if (scanFile.hasNext()) scanFile.nextLine(); // clear \n
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "\n~ Loading Sample Data");
            
            // if file not found - add one test student with sample quiz scores
            studentQuizGrades.put("Sample Student", new ArrayList());
            int[] temp = {0, 25, 50, 75, 100};
            
            for (int i = 0; i < temp.length; i++) {
                studentQuizGrades.get("Sample Student").add(i);
            }
        }
        
        return studentQuizGrades;
    }
    
    public void saveHashMapToFile(HashMap<String, ArrayList<Integer>> studentQuizGrades, String filename) throws IOException {
        
        PrintWriter write = new PrintWriter(new FileWriter(filename));
        
        for (String name : studentQuizGrades.keySet()) {
            write.println(name);
            
            for (int i = 0; i < studentQuizGrades.get(name).size(); i++) {
                write.print(studentQuizGrades.get(name).get(i) + " ");
            }
            
            write.println();
        }
        
        write.flush();
        write.close();
    }
}
