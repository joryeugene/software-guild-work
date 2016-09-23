package com.jorypestorious.studentquizgrades;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class QuizScoresMenu {
    
    private static final DecimalFormat DF = new DecimalFormat("0.00");
    
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
                    findClassAverage(studentQuizGrades, io);
                    findQuizAverage(studentQuizGrades, io);
                    break;
                case 4:
                    findStudentsAbove(studentQuizGrades, io);
                    break;
                case 5:
                    findStudentsBelow(studentQuizGrades, io);
                    break;
                case 6: 
                    keepRunning = false;
            }

            Thread.sleep(1000);
            io.display(""); // line break;
            
        } while (keepRunning);
        
        return false;
    }
    
    private static void viewEditSpecficStudentsQuizGrades(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) throws InterruptedException {
        String menuPrompt = "\n1. Add New Quiz Score\n" +
                              "2. Change Quiz Score\n" +
                              "3. Remove Last Quiz Score\n" +
                              "4. Find Average Quiz Score\n" +
                              "5. Back\n\n" +
                              "> Selection: ";
        
        String student = io.promptString("> Student's Name: ");
        
        if (!studentQuizGrades.containsKey(student)) {
            io.display("! Student Not Found");
        } else {
            boolean stayOnMenu = true;
            int selection;
            
            do {                
                io.displaySpecificStudentsQuizGrades(studentQuizGrades, student);
                selection = io.promptInt(menuPrompt, 1, 5);
                io.display(""); // line break;
                
                switch(selection) {
                    case 1: 
                        addQuizGrade(studentQuizGrades, io, student);
                        break;
                    case 2:
                        changeQuizGrade(studentQuizGrades, io, student);
                        break;
                    case 3:
                        removeQuizGrade(studentQuizGrades, io, student);
                        break;
                    case 4:
                        findAverage(studentQuizGrades, io, student);
                        break;
                    case 5:
                        stayOnMenu = false;
                }
                
                Thread.sleep(1000);
                
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
    
    private static void removeQuizGrade(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io, String student) {
        int quizToRemove = studentQuizGrades.get(student).size() - 1;
        studentQuizGrades.get(student).remove(quizToRemove);
    }
    
    private static double findAverage(HashMap<String, ArrayList<Integer>> studentQuizGrades, String student) { /// integreated into all 3 below
        double numOfQuizzes = (double)studentQuizGrades.get(student).size(),
               scoreSum = 0.0;
        
        for (int i = 0; i < numOfQuizzes; i++) {
            scoreSum += (double)studentQuizGrades.get(student).get(i);
        }
        
        return scoreSum / numOfQuizzes;
    }
    
    private static void findAverage(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io, String student) {
        io.display(student + " Quiz Average: " + DF.format(findAverage(studentQuizGrades, student)));
    }
    
    private static void findClassAverage(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) {
        int numOfStudents = 0;
        double avgSum = 0.0;
        
        for (String student : studentQuizGrades.keySet()) {
            if (studentQuizGrades.get(student).size() < 1) continue;
            numOfStudents++; // not including students with no quiz scores recorded
            avgSum += findAverage(studentQuizGrades, student);
        }
        
        io.display("Class Grade Average: " + DF.format(avgSum / numOfStudents));
    }
    
    private static void findQuizAverage(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) {
        int numOfQuizzes = 0;
        double sumOfQuizzes = 0.0;
        
        for (String student : studentQuizGrades.keySet()) {
            if (studentQuizGrades.get(student).size() < 1) continue;
            numOfQuizzes += studentQuizGrades.get(student).size();
            
            for (int i = 0; i < studentQuizGrades.get(student).size(); i++) {
                sumOfQuizzes += studentQuizGrades.get(student).get(i);
            }
        }
        
        io.display("Average Quiz Score: " + DF.format(sumOfQuizzes / numOfQuizzes));
    }
    
    private static void findStudentsAbove(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) {
        HashMap<String, String> highAvgStudents = new HashMap<>();
        int count = 0;
        double avg;
        int aboveThisScore = io.promptInt("Above Score of: ", 0, 100);

        for (String student : studentQuizGrades.keySet()) {
            avg = findAverage(studentQuizGrades, student);
            if (avg > aboveThisScore) {
                count++;
                highAvgStudents.put(student, DF.format(avg));
            }
        }
        
        if (highAvgStudents.size() < 1) {
            io.display("! No Students Found");
        } else {
            io.displayStudentAverages(highAvgStudents, "Students with an Average Above " + aboveThisScore, count, studentQuizGrades.size());
        }
    }
    
    private static void findStudentsBelow(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) {
        HashMap<String, String> lowAvgStudents = new HashMap<>();
        int count = 0;
        double avg;
        int belowThisScore = io.promptInt("Below Score of: ", 0, 100);

        for (String student : studentQuizGrades.keySet()) {
            avg = findAverage(studentQuizGrades, student);
            if (avg < belowThisScore) {
                count++;
                lowAvgStudents.put(student, DF.format(avg));
            }
        }
        
        if (lowAvgStudents.size() < 1) {
            io.display("! No Students Found");
        } else {
            io.displayStudentAverages(lowAvgStudents, "Students with an Average Below " + belowThisScore, count, studentQuizGrades.size());
        }
    }

}
