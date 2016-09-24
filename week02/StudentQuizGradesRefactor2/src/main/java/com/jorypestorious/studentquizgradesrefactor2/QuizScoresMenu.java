package com.jorypestorious.studentquizgradesrefactor2;

public class QuizScoresMenu {
    
    private final ConsoleIO io;
    private final Database dm;
    
    QuizScoresMenu(ConsoleIO io, Database dm) {
        this.io = io;
        this.dm = dm;
    }
    
    public boolean run() throws InterruptedException {
        
        StudentMenu viewEditSpecficStudentsQuizGrades = new StudentMenu(io, dm);
        
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
                    io.displayAllStudentsQuizScores(dm.getDatabase());
                    break;
                case 2:
                    studentMenu = true;
                    break;
                case 3:
                    io.displayHighestLowestQuizScore(dm.findHighestLowestQuizScore(true), "Highest Quiz");
                    break;
                case 4:
                    io.displayHighestLowestQuizScore(dm.findHighestLowestQuizScore(false), "Lowest Quiz");
                    break;
                case 5:
                    io.display("Average Quiz Score: " + dm.findQuizAverage());
                    break;
                case 6:
                    int aboveThisScore = io.promptInt("Above Score of: ", 0, 100);
                    io.displayStudentAverages(dm.findStudentsAboveOrBelow(aboveThisScore, true));
                    break;
                case 7:
                    int belowThisScore = io.promptInt("Below Score of: ", 0, 100);
                    io.displayStudentAverages(dm.findStudentsAboveOrBelow(belowThisScore, false));
                    break;
                case 8: 
                    keepRunning = false;
            }

            Thread.sleep(1000); // short pause
            
            while (studentMenu) studentMenu = viewEditSpecficStudentsQuizGrades.run();
            
        } while (keepRunning);
        
        return false;
    }

}
