package com.jorypestorious.studentquizgrades;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainMenu {
    
    public static void main(String[] args) throws FileNotFoundException, InterruptedException, IOException {
        ReadSaveFile rs = new ReadSaveFile();
        ConsoleIO io = new ConsoleIO();
        QuizScoresMenu quizScoresMenu = new QuizScoresMenu();
        
        String filename = "quizGrades.txt";
        
        HashMap<String, ArrayList<Integer>> studentQuizGrades = new HashMap<>();
        studentQuizGrades = rs.readFileToHashMap(filename);
        
        String mainMenuPrompt = "\n      MAIN MENU      \n" +
                                  "=====================\n" +
                                  "1. View All Students\n" +
                                  "2. Add Student\n" +
                                  "3. Remove Student\n" +
                                  "4. Quiz Scores\n" +
                                  "5. Exit\n\n" +
                                  "> Selection: ";
        
        boolean keepRunning = true;
        boolean scoresMenu = false;
        int selection;
        
        do {    
            selection = io.promptInt(mainMenuPrompt, 1, 5);
            io.display(""); // line break
            
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
                case 4:
                    scoresMenu = true;
                    break;
                case 5: 
                    keepRunning = false;
            }

            Thread.sleep(1000);
            
            while(scoresMenu) {
                scoresMenu = quizScoresMenu.run(studentQuizGrades, io);
            }
            
        } while (keepRunning);
        
        io.display("       EXITING       \n" +
                   "---------------------");
        
        io.display("* SAVING");
        rs.saveHashMapToFile(studentQuizGrades, filename);
        
        Thread.sleep(1111);
        io.display("\n      Goodbye!");
    }
    
    private static void addStudent(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) {
        String student = io.promptString("> Student's Name: ");
        
        if (studentQuizGrades.containsKey(student)) {
            io.display("! Student Already Exists");
        } else {
            studentQuizGrades.put(student, new ArrayList<Integer>());
            io.display("* Successfully Added: " + student);
        }
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
