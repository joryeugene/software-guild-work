package com.jorypestorious.studentquizgradesrefactor;

import java.util.ArrayList;
import java.util.HashMap;

public class MainMenu {
    
    public static void main(String[] args) throws InterruptedException {
        
        String filename = "quizGrades.txt";
        
        ReadSaveFile rs = new ReadSaveFile();
        HashMap<String, ArrayList<Integer>> studentQuizGrades;
        studentQuizGrades = rs.readFileToHashMap(filename);
        
        ConsoleIO io = new ConsoleIO();
        DatabaseManipulation dm = new DatabaseManipulation(studentQuizGrades, io);
        QuizScoresMenu quizScoresMenu = new QuizScoresMenu(studentQuizGrades, io, dm);
        
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
                    dm.addStudent();
                    break;
                case 3:
                    dm.removeStudent();
                    break;
                case 4:
                    scoresMenu = true;
                    break;
                case 5: 
                    keepRunning = false;
            }
            
            dm.shortPause(1000);
            
            while(scoresMenu) {
                scoresMenu = quizScoresMenu.run();
            }
            
        } while (keepRunning);
        
        io.display("       EXITING       \n" +
                   "---------------------");
        
        io.display("* SAVING");
        rs.saveHashMapToFile(studentQuizGrades, filename);
        
        dm.shortPause(1111);
        io.display("\n      Goodbye!");
    }

}

