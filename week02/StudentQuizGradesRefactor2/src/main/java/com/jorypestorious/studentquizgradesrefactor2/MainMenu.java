package com.jorypestorious.studentquizgradesrefactor2;

public class MainMenu {
    
    public static void main(String[] args) throws InterruptedException {
        
        String filename = "quizGrades.txt";
        
        ConsoleIO io = new ConsoleIO();
        ReadSaveFile rs = new ReadSaveFile();
        Database dm = new Database(rs.readFileToHashMap(filename));
        QuizScoresMenu quizScoresMenu = new QuizScoresMenu(io, dm);
        
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
        String student;
        
        do {    
            selection = io.promptInt(mainMenuPrompt, 1, 5);
            io.display(""); // line break
            
            switch(selection) {
                case 1:
                    io.displayAllStudents(dm.getDatabase());
                    break;
                case 2:
                    student = io.promptString("> Student's Name: ");
                    if (dm.addStudent(student)) io.display("* Successfully Added: " + student);
                    else io.display("! Student Already Exists");
                    break;
                case 3:
                    student = io.promptString("> Student's Name: ");
                    if (dm.removeStudent(student)) io.display("* Successfully Removed: " + student);
                    else io.display("! Student Not Found");
                    break;
                case 4:
                    scoresMenu = true;
                    break;
                case 5: 
                    keepRunning = false;
            }
            
            Thread.sleep(1000); // short pause
            
            while(scoresMenu) scoresMenu = quizScoresMenu.run();
            
        } while (keepRunning);
        
        io.display("       EXITING       \n" +
                   "---------------------");
        
        io.display("* SAVING");
        rs.saveHashMapToFile(dm.getDatabase(), filename);
        
        Thread.sleep(1111); // short pause
        io.display("\n      Goodbye!");
    }

}

