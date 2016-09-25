package com.jorypestorious.studentquizgradesrefactor2;

public class StudentMenu {
    
    private final ConsoleIO io;
    private final Database dm;
    
    StudentMenu(ConsoleIO io, Database dm) {
        this.io = io;
        this.dm = dm;
    }
    
    public boolean run() throws InterruptedException {

        String student = io.promptString("> Student's Name: ");
        
        if (!dm.getDatabase().containsKey(student)) {
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
            int numOfQuizzes;
            
            do {                
                io.displaySpecificStudentsQuizScores(dm.getDatabase(), student);
                selection = io.promptInt(menuPrompt, 1, 5);
                io.display(""); // line break;
                
                switch(selection) {
                    case 1: 
                        int nextQuiz = dm.getNextQuizNum(student);
                        int quizScoreToAdd = io.promptInt("Q" + nextQuiz + " Grade: ", 0, 100);
                        dm.addQuizScore(student, quizScoreToAdd);
                        io.display("* Successfully Added: Q" + nextQuiz + ": " + quizScoreToAdd);
                        break;
                    case 2:
                        numOfQuizzes = dm.getNumOfStudentsQuizzes(student);
                        if (numOfQuizzes < 1) {
                            io.display("! No Quizzes Found");
                        } else {
                            int quizToChange = io.promptInt("> Quiz Number: ", 1, numOfQuizzes);
                            int newScore = io.promptInt("Q" + quizToChange + " Grade: ", 0, 100);
                            dm.changeQuizScore(student, quizToChange, newScore);
                            io.display("* Successfully Changed Q" + quizToChange + " to ");
                        }
                        break;
                    case 3:
                        numOfQuizzes = dm.getNumOfStudentsQuizzes(student);
                        if (numOfQuizzes < 1) {
                            io.display("! No Quizzes to Remove");
                        } else {
                            dm.removeLastQuizScore(student);
                        }
                        break;
                    case 4:
                        io.display(dm.findAverageForOneStudent(student));
                        break;
                    case 5:
                        stayOnMenu = false;
                }
                
                Thread.sleep(1000); // short pause
                
            } while (stayOnMenu);
        }
        
        return false;
    }

}
