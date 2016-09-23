package com.jorypestorious.studentquizgradesrefactor;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentMenu {
    
    private final ConsoleIO io;
    private final Functionality f;
    private final HashMap<String, ArrayList<Integer>> studentQuizGrades;
    
    StudentMenu(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io, Functionality f) {
        this.studentQuizGrades = studentQuizGrades;
        this.io = io;
        this.f = f;
    }
    
    public boolean run() throws InterruptedException {

        String student = io.promptString("> Student's Name: ");
        
        if (!studentQuizGrades.containsKey(student)) {
            io.display("! Student Not Found");
        } else {
            
            String menuPrompt = "\n1. Add New Quiz Score\n" +
                                  "2. Change Quiz Score\n" +
                                  "3. Remove Last Quiz Score\n" +
                                  "4. Find Average Quiz Score\n" +
                                  "5. Back\n\n" +
                                  "> Selection: ";
            
            boolean stayOnMenu = true;
            int selection;
            
            do {                
                io.displaySpecificStudentsQuizGrades(studentQuizGrades, student);
                selection = io.promptInt(menuPrompt, 1, 5);
                io.display(""); // line break;
                
                switch(selection) {
                    case 1: 
                        f.addQuizGrade(student);
                        break;
                    case 2:
                        f.changeQuizGrade(student);
                        break;
                    case 3:
                        f.removeQuizGrade(student);
                        break;
                    case 4:
                        f.findAverage(student);
                        break;
                    case 5:
                        stayOnMenu = false;
                }
                
                f.shortPause(1000);
                
            } while (stayOnMenu);
        }
        
        return false;
    }

}
