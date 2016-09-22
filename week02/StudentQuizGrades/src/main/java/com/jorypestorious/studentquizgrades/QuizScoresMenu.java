package com.jorypestorious.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;

public class QuizScoresMenu {
    
    public boolean run(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) throws InterruptedException {
        
        String menuPrompt = "      Quiz Scores    \n" +
                            "=====================\n" +
                            "1. View All Students' Quiz Scores\n" +
                            "2. View/Edit Specific Student's Quiz Scores\n" +
                            "3. Find Class Average\n" +
                            "4. Find Students with an Average Above Certain Score\n" +
                            "5. Find Students with an Average Below Certain Score\n" +
                            "6. Exit to Main Menu\n\n" +
                            "> Selection: ";
        
        boolean keepRunning = true;
        int selection;
        
        do {    
            selection = io.promptInt(menuPrompt, 1, 6);
            io.display(""); // line break
            
            switch(selection) {
                case 1:
                    io.displayAllStudentsQuizGrades(studentQuizGrades);
                    break;
                case 2:
                    viewEditSpecficStudentsQuizGrades(studentQuizGrades, io);
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    break;
                case 6: 
                    keepRunning = false;
            }

            Thread.sleep(1000);
            io.display(""); // line break;
            
        } while (keepRunning);
        
        return false;
    }
    
    private static void viewEditSpecficStudentsQuizGrades(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) {
        String menuPrompt = "\n1. Add New Quiz Score\n" +
                              "2. Change Quiz Score\n" +
                              "3. Find Average Quiz Score\n" +
                              "4. Back\n\n" +
                              "> Selection: ";
        
        String student = io.promptString("> Student's Name: ");
        
        if (!studentQuizGrades.containsKey(student)) {
            io.display("! Student Not Found");
        } else {
            boolean stayOnMenu = true;
            int selection;
            
            do {                
                io.displaySpecificStudentsQuizGrades(studentQuizGrades, student);
                selection = io.promptInt(menuPrompt, 1, 4);
                io.display(""); // line break;
                
                switch(selection) {
                    case 1: 
                        addQuizGrade(studentQuizGrades, io, student);
                        break;
                    case 2:
                        changeQuizGrade(studentQuizGrades, io, student);
                        break;
                    case 3:
                        findAverage(studentQuizGrades, io, student);
                        break;
                    case 4:
                        stayOnMenu = false;
                }
                
            } while (stayOnMenu);
        }
    }
    
    private static void addQuizGrade(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io, String student) {
        int nextQuiz = studentQuizGrades.get(student).size() + 1;
        int quizScoreToAdd = io.promptIntWithResult("Q" + nextQuiz + " Grade: ", 0, 100, 
                                                    "* Successfully Added: Q" + nextQuiz + ": ");
        studentQuizGrades.get(student).add(quizScoreToAdd);
    }
    
    private static void changeQuizGrade(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io, String student) {
        int numOfQuizzes = studentQuizGrades.get(student).size();
        
        if (numOfQuizzes < 1) {
            io.display("! No Quizzes Found");
        } else {
            int quizToChange = io.promptInt("> Quiz Number: ", 1, numOfQuizzes);
            int newScore = io.promptIntWithResult("Q" + quizToChange + " Grade: ", 0, 100, 
                                                           "* Successfully Changed Q" + quizToChange + " to ");
            studentQuizGrades.get(student).set((quizToChange - 1), newScore);
        }
    }
    
    private static void findAverage(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io, String student) {
        int numOfQuizzes = studentQuizGrades.get(student).size();
        int scoreSum = 0;
        
        for (int i = 0; i < numOfQuizzes; i++) {
            scoreSum += studentQuizGrades.get(student).get(i);
        }
        
        io.display(student + " Quiz Average: " + (scoreSum / numOfQuizzes));
    }
    
    

}
