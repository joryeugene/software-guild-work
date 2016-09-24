
package com.jorypestorious.studentquizgradesrefactor2;

import java.util.ArrayList;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class DatabaseTest {
    
    static Database dm;
    
    @BeforeClass
    public static void setUpClass() {
        ReadSaveFile rs = new ReadSaveFile();
        dm = new Database(rs.readFileToHashMap("test.txt"));
    }

    @AfterClass
    public static void tearDownClass() {
        dm = null;
    }

    @Test
    public void testGetDatabase() {
        System.out.println("getDatabase");
        int expResult = 7;
        int result = dm.getDatabase().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddStudent() {
        System.out.println("addStudent");
        String student = "test student";
        boolean expResult = true;
        boolean result = dm.addStudent(student);
        assertEquals(expResult, result);

        assertTrue(dm.getDatabase().containsKey("test student"));
    }
    
    @Test
    public void testRemoveStudent() {
        System.out.println("removeStudent");
        String student = "test student";
        boolean expResult = true;
        boolean result = dm.removeStudent(student);
        assertEquals(expResult, result);
    }

    @Test
    public void testFindHighestLowestQuizScore() {
        System.out.println("findHighestLowestQuizScore");
        int expResult = 3;
        int result = dm.findHighestLowestQuizScore(true).size();
        assertEquals(expResult, result);
        
        expResult = 2;
        result = dm.findHighestLowestQuizScore(false).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testFindQuizAverage() {
        System.out.println("findQuizAverage");
        String expResult = "37.00";
        String result = dm.findQuizAverage();
        assertEquals(expResult, result);
    }

    @Test
    public void testFindStudentsAboveOrBelow() {
        System.out.println("findStudentsAboveOrBelow");
        int aboveBelowThisScore = 49;
        boolean above = true;
        int expResult = 3;
        int result = dm.findStudentsAboveOrBelow(aboveBelowThisScore, above).count;
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNextQuizNum() {
        System.out.println("getNextQuizNum");
        String student = "Student 123";
        int expResult = 4;
        int result = dm.getNextQuizNum(student);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNumOfStudentsQuizzes() {
        System.out.println("getNumOfStudentsQuizzes");
        String student = "Student 100";
        int expResult = 1;
        int result = dm.getNumOfStudentsQuizzes(student);
        assertEquals(expResult, result);
    }

    @Test
    public void testAddRemoveQuizScore() {
        Map<String, ArrayList<Integer>> m = dm.getDatabase();
        System.out.println("addQuizScore");
        String student = "Student 75";
        int quizScoreToAdd = 50;
        dm.addQuizScore(student, quizScoreToAdd);
        int expResult = 4;
        int result = m.get(student).size();
        assertEquals(expResult, result);
        
        result = m.get(student).get(3);
        assertEquals(quizScoreToAdd, result);
    }

    @Test
    public void testChangeQuizScore() {
        Map<String, ArrayList<Integer>> m = dm.getDatabase();
        System.out.println("changeQuizScore");
        String student = "Student 0";
        int quizToChange = 2;
        int newScore = 100;
        dm.changeQuizScore(student, quizToChange, newScore);
        int result = m.get(student).get(1);
        assertEquals(newScore, result);
    }

    @Test
    public void testRemoveLastQuizScore() {
        Map<String, ArrayList<Integer>> m = dm.getDatabase();
        System.out.println("addQuizScore");
        String student = "Student 75";
        dm.removeLastQuizScore(student);
        int expResult = 2;
        int result = m.get(student).size();
        assertEquals(expResult, result);
        dm.addQuizScore(student, 100);
    }

    @Test
    public void testFindAverageForOneStudent() {
        System.out.println("findAverageForOneStudent");
        String student = "Student 75";
        String expResult = "Student 75 Quiz Average: 75.00";
        String result = dm.findAverageForOneStudent(student);
        assertEquals(expResult, result);
    }

}