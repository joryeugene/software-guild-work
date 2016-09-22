package com.jorypestorious.studentquizgrades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainMenu {
    
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException {
        ReadSaveFile rs = new ReadSaveFile();
        ConsoleIO io = new ConsoleIO();
        
        HashMap<String, ArrayList<Integer>> studentQuizGrades = new HashMap<>();
        studentQuizGrades = rs.readFileToHashMap("quizGrades.txt");
        
        String mainMenuPrompt = "\n      MAIN MENU      \n" +
                                  "=====================\n" +
                                  "1. View All Students\n" +
                                  "2. Add Student\n" +
                                  "3. Remove Student\n" +
                                  "4. Quiz Scores\n" +
                                  "5. Exit\n\n" +
                                  "> Selection: ";
        
        boolean keepRunning = true;
        int selection;
        
        do {    
            selection = io.promptInt(mainMenuPrompt, 1, 5);
            io.display(""); // line break
            
            if (selection == 5) {
                keepRunning = false;
                io.display("       EXITING       \n" +
                           "---------------------");
            } else {
                
                switch(selection) {
                    case 1:
                        io.displayAllStudents(studentQuizGrades);
                        break;
                    case 2:
                        addStudent(studentQuizGrades, io);
                        break;
                    case 3:
                        removeStudent(studentQuizGrades, io);
                        break;
                }
                
                Thread.sleep(1500);
            }
            
        } while (keepRunning);
        
        io.display("* SAVING");
        //io.saveStudentsQuizGrades(studentQuizGrades);
        
        Thread.sleep(3000);
        io.display("\n      Goodbye!");
        
        
        //io.displayStudentsQuizGrades(studentQuizGrades);
        
        
    }
    
    private static void addStudent(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) {
        String student = io.promptStringWithResult("> Student's Name: ", "* Successfully Added: ");
        studentQuizGrades.put(student, new ArrayList<Integer>());
    }
    
    private static void removeStudent(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) {
        String student = io.promptString("> Student's Name: ");
        
        if (studentQuizGrades.containsKey(student)) {
            studentQuizGrades.remove(student);
            io.display("* Successfully Removed: " + student);
        } else {
            io.display("! Student Not Found");
        }
    }

}
