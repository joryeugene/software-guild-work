package com.jorypestorious.studentquizgradesrefactor2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    
    private final DecimalFormat df;
    private final HashMap<String, ArrayList<Integer>> studentQuizGrades;
    
    Database(HashMap<String, ArrayList<Integer>> studentQuizGrades) {
        this.studentQuizGrades = studentQuizGrades;
        this.df = new DecimalFormat("0.00");
    }
    
    public HashMap getDatabase() {
        return studentQuizGrades;
    }
    
    ///////////////////////// Main Menu /////////////////////////
    public boolean addStudent(String student) {
        if (studentQuizGrades.containsKey(student)) {
            return false;
        } else {
            studentQuizGrades.put(student, new ArrayList<>());
            return true;
        }
    }
    
    public boolean removeStudent(String student) {
        if (studentQuizGrades.containsKey(student)) {
            studentQuizGrades.remove(student);
            return true;
        } else {
            return false;
        }
    }
    
    //////////////////////// Quiz Scores Menu ////////////////////////
    public HashMap findHighestLowestQuizScore(boolean highest) { // if false => find lowest
        HashMap<String, ArrayList<String>> highScores = new HashMap<>();
        int highestQuiz = 0;
        int currentQuiz;
        String formattedStr;
        
        for (String student : studentQuizGrades.keySet()) {
            if (studentQuizGrades.get(student).size() < 1) continue;
            
            for (int i = 0; i < studentQuizGrades.get(student).size(); i++) {
                currentQuiz = studentQuizGrades.get(student).get(i);
                
                if (highest) if (currentQuiz > highestQuiz) highestQuiz = currentQuiz;
                else if (currentQuiz < highestQuiz) highestQuiz = currentQuiz;
            }
        }
        
        for (String student : studentQuizGrades.keySet()) {
            if (studentQuizGrades.get(student).size() < 1) continue;
            
            for (int i = 0; i < studentQuizGrades.get(student).size(); i++) {
                currentQuiz = studentQuizGrades.get(student).get(i);
                
                if (currentQuiz == highestQuiz) {
                    formattedStr = "Q" + (i+1) + ": " + highestQuiz;
                    if (!highScores.containsKey(student)) highScores.put(student, new ArrayList<>());
                    highScores.get(student).add(formattedStr);
                }
            }
        }
        
        return highScores;
    }
    
    public String findQuizAverage() {
        int numOfQuizzes = 0;
        double sumOfQuizzes = 0.0;
        
        for (String student : studentQuizGrades.keySet()) {
            if (studentQuizGrades.get(student).size() < 1) continue;
            
            numOfQuizzes += studentQuizGrades.get(student).size();
            
            for (int i = 0; i < studentQuizGrades.get(student).size(); i++) {
                sumOfQuizzes += studentQuizGrades.get(student).get(i);
            }
        }
        
        return df.format(sumOfQuizzes / numOfQuizzes);
    }
    
    public Report findStudentsAboveOrBelow(int aboveBelowThisScore, boolean above) { // false => below
        HashMap<String, String> chosenStudents = new HashMap<>();
        int count = 0;
        double avg;
        
        for (String student : studentQuizGrades.keySet()) {
            avg = findAverage(student);
            
            if (above) {
                if (avg > aboveBelowThisScore) {
                    count++;
                    chosenStudents.put(student, df.format(avg));
                }
            } else {
                if (avg < aboveBelowThisScore) {
                    count++;
                    chosenStudents.put(student, df.format(avg));
                }
            }
        }
        
        Report r;
        
        if (above) {
            r = new Report(chosenStudents, "Students with an Average Above " +
                    aboveBelowThisScore, count, studentQuizGrades.size());
        } else {
            r = new Report(chosenStudents, "Students with an Average Below " +
                    aboveBelowThisScore, count, studentQuizGrades.size());
        }
        
        return r;
    }
    
    ///////////////////////// Student Menu /////////////////////////
    public int getNextQuizNum(String student) {
        return studentQuizGrades.get(student).size() + 1;
    }
    
    public int getNumOfStudentsQuizzes(String student) {
        return studentQuizGrades.get(student).size();
    }
    
    public void addQuizScore(String student, int quizScoreToAdd) {
        studentQuizGrades.get(student).add(quizScoreToAdd);
    }
    
    public void changeQuizScore(String student, int quizToChange, int newScore) {
        studentQuizGrades.get(student).set((quizToChange - 1), newScore);
    }
    
    public void removeLastQuizScore(String student) {
        studentQuizGrades.get(student).remove(studentQuizGrades.get(student).size() - 1);
    }
    
    public String findAverageForOneStudent(String student) {
        return student + " Quiz Average: " + df.format(findAverage(student));
    }
    
    private double findAverage(String student) {
        double numOfQuizzes = (double)studentQuizGrades.get(student).size(),
               scoreSum = 0.0;
        
        for (int i = 0; i < numOfQuizzes; i++) {
            scoreSum += (double)studentQuizGrades.get(student).get(i);
        }
        
        return scoreSum / numOfQuizzes;
    }
    
}
