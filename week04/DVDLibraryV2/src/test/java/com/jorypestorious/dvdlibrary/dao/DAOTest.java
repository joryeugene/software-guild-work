
package com.jorypestorious.dvdlibrary.dao;

import com.jorypestorious.dvdlibrary.dto.DVD;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAOTest {

    DAO instance = new DVDLibrary("test.txt");

    @Before
    public void setUp() {
        if (instance.getDVDLibrary().size() > 0) instance.getDVDLibrary().keySet().stream()
                .forEach( title -> instance.removeDVD(title) );
        
        instance.addDVD(new DVD("Title1", 2001, "G", "Director1", "Studio1", "Note1"));
        instance.addDVD(new DVD("Title2", 2002, "PG", "Director1", "Studio1", "Note2"));
        instance.addDVD(new DVD("Title3", 2003, "PG-13", "Director1", "Studio3", "Note3"));
        instance.addDVD(new DVD("Title4", 2004, "PG-13", "Director4", "Studio4", "Note4"));
    }
    @After
    public void tearDown() {
        instance.getDVDLibrary().keySet().stream()
                .forEach( title -> instance.removeDVD(title) );
    }

    @Test
    public void testGetDVDLibrary() {
        System.out.println("getDVDLibrary");
        int expResult = 4;
        int result = instance.getDVDLibrary().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchByTitle() {
        System.out.println("searchByTitle");
        String title = "Title1";
        DVD result = instance.searchByTitle(title);
        assertNotEquals(null, result);
    }

    @Test
    public void testSearchByStudio() {
        System.out.println("searchByStudio");
        String studio = "Studio2";
        List<DVD> result = instance.searchByStudio(studio);
        assertNotEquals(null, result);
    }

    @Test
    public void testSearchByMpaa() {
        System.out.println("searchByMpaa");
        String mpaa = "PG-13";
        int expResult = 2;
        int result = instance.searchByMpaa(mpaa).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchByDirector() {
        System.out.println("searchByDirector");
        String director = "Director1";
        int expResult = 3;
        int result = instance.searchByDirector(director).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testFindRecent() {
        System.out.println("findRecent");
        int years = 13;
        int expResult = 2;
        int result = instance.findRecent(years).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testFindNewest() {
        System.out.println("findNewest");
        String expResult = "Title4";
        String result = instance.findNewest().getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testFindOldest() {
        System.out.println("findOldest");
        String expResult = "Title1";
        String result = instance.findOldest().getTitle();
        assertEquals(expResult, result);
    }

    @Test
    public void testFindAverageAge() {
        System.out.println("findAverageAge");
        int expResult = 2003;
        int result = instance.findAverageAge();
        assertEquals(expResult, result);
    }

    @Test
    public void testAddDVD() {
        System.out.println("addDVD");
        instance.addDVD(new DVD("Title5", 2004, "PG-13", "Director4", "Studio4", "Note4"));
        int expResult = 5;
        int result = instance.getDVDLibrary().size();
        assertEquals(expResult, result);
    }

    @Test
    public void testRemoveDVD() {
        System.out.println("removeDVD");
        String title = "Title1";
        instance.removeDVD(title);
        int expResult = 3;
        int result = instance.getDVDLibrary().size();
        assertEquals(expResult, result);
    }

}