package com.jorypestorious.studentquizgradesrefactor;

import java.util.ArrayList;
import java.util.HashMap;

public class QuizScoresMenu {
    
    private final ConsoleIO io;
    private final DatabaseManipulation dm;
    private final HashMap<String, ArrayList<Integer>> studentQuizGrades;
    
    QuizScoresMenu(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io, DatabaseManipulation dm) {
        this.studentQuizGrades = studentQuizGrades;
        this.io = io;
        this.dm = dm;
    }
    
    public boolean run() throws InterruptedException {
        
        StudentMenu viewEditSpecficStudentsQuizGrades = new StudentMenu(studentQuizGrades, io, dm);
        
        String menuPrompt = "\n      Quiz Scores    \n" +
                              "=====================\n" +
                              "1. View All Students' Quiz Scores\n" +
                              "2. View/Edit Specific Student's Quiz Scores\n" +
                              "3. Find Student(s) with Highest Quiz Score \n" +
                              "4. Find Student(s) with Lowest Quiz Score \n" +
                              "5. Find Average Quiz Score\n" +
                              "6. Find Students with Average Above Certain Score\n" +
                              "7. Find Students with Average Below Certain Score\n" +
                              "8. Exit to Main Menu\n\n" +
                              "> Selection: ";
        
        boolean keepRunning = true;
        boolean studentMenu = false;
        int selection;
        
        do {    
            selection = io.promptInt(menuPrompt, 1, 8);
            io.display(""); // line break
            
            switch(selection) {
                case 1:
                    io.displayAllStudentsQuizGrades(studentQuizGrades);
                    break;
                case 2:
                    studentMenu = true;
                    break;
                case 3:
                    dm.findHighestQuiz();
                    break;
                case 4:
                    dm.findLowestQuiz();
                    break;
                case 5:
                    //f.findClassAverage();
                    dm.findQuizAverage();
                    break;
                case 6:
                    dm.findStudentsAbove();
                    break;
                case 7:
                    dm.findStudentsBelow();
                    break;
                case 8: 
                    keepRunning = false;
            }

            dm.shortPause(1000);
            
            while (studentMenu) {
                studentMenu = viewEditSpecficStudentsQuizGrades.run();
            }
            
        } while (keepRunning);
        
        return false;
    }

}
