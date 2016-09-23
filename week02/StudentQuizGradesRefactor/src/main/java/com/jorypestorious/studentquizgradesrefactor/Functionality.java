package com.jorypestorious.studentquizgradesrefactor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Functionality {
    
    private final ConsoleIO io;
    private final DecimalFormat df;
    private final HashMap<String, ArrayList<Integer>> studentQuizGrades;

    Functionality(HashMap<String, ArrayList<Integer>> studentQuizGrades, ConsoleIO io) {
        this.studentQuizGrades = studentQuizGrades;
        this.df = new DecimalFormat("0.00");
        this.io = io;
    }
    
    ///////////////////////// Main Menu /////////////////////////
    public void addStudent() {
        String student = io.promptString("> Student's Name: ");
        
        if (studentQuizGrades.containsKey(student)) {
            io.display("! Student Already Exists");
        } else {
            studentQuizGrades.put(student, new ArrayList<>());
            io.display("* Successfully Added: " + student);
        }
    }
    
    public void removeStudent() {
        String student = io.promptString("> Student's Name: ");
        
        if (studentQuizGrades.containsKey(student)) {
            studentQuizGrades.remove(student);
            io.display("* Successfully Removed: " + student);
        } else {
            io.display("! Student Not Found");
        }
    }
    
    //////////////////////// Quiz Scores Menu ////////////////////////
    public void findClassAverage() { // not including quizzes not done yet
        int numOfStudents = 0;
        double avgSum = 0.0;
        
        for (String student : studentQuizGrades.keySet()) {
            if (studentQuizGrades.get(student).size() < 1) continue;
            numOfStudents++; // not including students with no quiz scores recorded
            avgSum += findAverage(studentQuizGrades, student);
        }
        
        io.display("Class Grade Average: " + df.format(avgSum / numOfStudents));
    }
    
    public void findQuizAverage() {
        int numOfQuizzes = 0;
        double sumOfQuizzes = 0.0;
        
        for (String student : studentQuizGrades.keySet()) {
            if (studentQuizGrades.get(student).size() < 1) continue;
            numOfQuizzes += studentQuizGrades.get(student).size();
            
            for (int i = 0; i < studentQuizGrades.get(student).size(); i++) {
                sumOfQuizzes += studentQuizGrades.get(student).get(i);
            }
        }
        
        io.display("Average Quiz Score: " + df.format(sumOfQuizzes / numOfQuizzes));
    }
    
    public void findStudentsAbove() {
        HashMap<String, String> highAvgStudents = new HashMap<>();
        int count = 0;
        double avg;
        int aboveThisScore = io.promptInt("Above Score of: ", 0, 100);

        for (String student : studentQuizGrades.keySet()) {
            avg = findAverage(studentQuizGrades, student);
            if (avg > aboveThisScore) {
                count++;
                highAvgStudents.put(student, df.format(avg));
            }
        }
        
        if (highAvgStudents.size() < 1) {
            io.display("! No Students Found");
        } else {
            io.displayStudentAverages(highAvgStudents, "Students with an Average Above " + aboveThisScore, count, studentQuizGrades.size());
        }
    }
    
    public void findStudentsBelow() {
        HashMap<String, String> lowAvgStudents = new HashMap<>();
        int count = 0;
        double avg;
        int belowThisScore = io.promptInt("Below Score of: ", 0, 100);

        for (String student : studentQuizGrades.keySet()) {
            avg = findAverage(studentQuizGrades, student);
            if (avg < belowThisScore) {
                count++;
                lowAvgStudents.put(student, df.format(avg));
            }
        }
        
        if (lowAvgStudents.size() < 1) {
            io.display("! No Students Found");
        } else {
            io.displayStudentAverages(lowAvgStudents, "Students with an Average Below " + belowThisScore, count, studentQuizGrades.size());
        }
    }
    
    ///////////////////////// Student Menu /////////////////////////
    private static double findAverage(HashMap<String, ArrayList<Integer>> studentQuizGrades, String student) {
        double numOfQuizzes = (double)studentQuizGrades.get(student).size(),
               scoreSum = 0.0;
        
        for (int i = 0; i < numOfQuizzes; i++) {
            scoreSum += (double)studentQuizGrades.get(student).get(i);
        }
        
        return scoreSum / numOfQuizzes;
    }
    
    public void findAverage(String student) {
        io.display(student + " Quiz Average: " + df.format(findAverage(studentQuizGrades, student)));
    }
    
    public void addQuizGrade(String student) {
        int nextQuiz = studentQuizGrades.get(student).size() + 1;
        int quizScoreToAdd = io.promptIntWithResult("Q" + nextQuiz + " Grade: ", 0, 100, 
                                                    "* Successfully Added: Q" + nextQuiz + ": ");
        studentQuizGrades.get(student).add(quizScoreToAdd);
    }
    
    public void changeQuizGrade(String student) {
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
    
    public void removeQuizGrade(String student) {
        int quizToRemove = studentQuizGrades.get(student).size() - 1;
        studentQuizGrades.get(student).remove(quizToRemove);
    }

}
