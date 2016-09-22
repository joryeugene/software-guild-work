package com.jorypestorious.studentquizgrades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ReadSaveFile {
    
    public HashMap readFileToHashMap(String filename) throws FileNotFoundException {
        
        HashMap<String, ArrayList<Integer>> studentQuizGrades = new HashMap<>();
        
        Scanner scanFile = new Scanner(new BufferedReader(new FileReader(filename)));
        String currentStudent;
        
        while (scanFile.hasNext()) {
            currentStudent = scanFile.nextLine();
            studentQuizGrades.put(currentStudent, new ArrayList());
        
            while (scanFile.hasNextInt()) {
                studentQuizGrades.get(currentStudent).add(scanFile.nextInt());
            }
        }
        
        return studentQuizGrades;
    }

}
