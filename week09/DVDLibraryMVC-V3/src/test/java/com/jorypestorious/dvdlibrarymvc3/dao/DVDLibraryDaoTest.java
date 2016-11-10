package com.jorypestorious.dvdlibrarymvc3.dao;

import com.jorypestorious.dvdlibrarymvc3.dao.DVDLibraryDao;
import com.jorypestorious.dvdlibrarymvc3.dto.DVD;
import com.jorypestorious.dvdlibrarymvc3.dto.MpaaDVDCount;
import com.jorypestorious.dvdlibrarymvc3.dto.YearDVDCount;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DVDLibraryDaoTest {
    
    private DVDLibraryDao dao;
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = (DVDLibraryDao) ctx.getBean("dvdLibraryDao");
        JdbcTemplate cleaner = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        cleaner.execute("delete from Dvds");
    }
    
    @Test
    public void testAddGetDeleteDVD() {
        DVD dvd = new DVD("Finding Nemo", "2003", "G", "Andrew Stanton", "Pixar", "Stupid fish swims around aimlessly");
        dao.addDVD(dvd);
        DVD dvdFromDb = dao.getDVDById(dvd.getId());
        
        assertEquals(dvdFromDb.getTitle(), dvd.getTitle());
        assertEquals(dvdFromDb.getYear(), dvd.getYear());
        assertEquals(dvdFromDb.getMpaa(), dvd.getMpaa());
        assertEquals(dvdFromDb.getDirector(), dvd.getDirector());
        assertEquals(dvdFromDb.getStudio(), dvd.getStudio());
        assertEquals(dvdFromDb.getNote(), dvd.getNote());
        assertEquals(dvdFromDb.getId(), dvd.getId());
        
        dao.removeDVD(dvd.getId());
        assertNull(dao.getDVDById(dvd.getId()));
    }

    @Test
    public void testUpdateDVD() {
        DVD dvd = new DVD("Finding Nemo", "2003", "G", "Andrew Stanton", "Pixar", "Stupid fish swims around aimlessly");
        dao.addDVD(dvd);
        
        dvd.setTitle("Test");
        dao.updateDVD(dvd);
        
        DVD dvdFromDb = dao.getDVDById(dvd.getId());
        
        assertEquals(dvdFromDb.getTitle(), dvd.getTitle());
        assertEquals(dvdFromDb.getYear(), dvd.getYear());
        assertEquals(dvdFromDb.getMpaa(), dvd.getMpaa());
        assertEquals(dvdFromDb.getDirector(), dvd.getDirector());
        assertEquals(dvdFromDb.getStudio(), dvd.getStudio());
        assertEquals(dvdFromDb.getNote(), dvd.getNote());
        assertEquals(dvdFromDb.getId(), dvd.getId());
    }

    @Test
    public void testGetAllDVDs() {
        addDVDs();
        
        List<DVD> dvds = dao.getAllDVDs();
        assertEquals(dvds.size(), 11);
    }

    @Test
    public void testGetMpaaDVDCounts() {
        addDVDs();
        
        int expResult = 4;
        List<MpaaDVDCount> result = dao.getMpaaDVDCounts();
        assertEquals(expResult, result.size());
        
        MpaaDVDCount mpaaCountG = result.stream().filter(mdc -> mdc.getMpaa().equalsIgnoreCase("G")).findFirst().get();
        assertEquals(mpaaCountG.getNumDVDs(), 3);
    }

    @Test
    public void testGetYearDVDCounts() {
        addDVDs();
        
        int expResult = 9;
        List<YearDVDCount> result = dao.getYearDVDCounts();
        assertEquals(expResult, result.size());
        
        YearDVDCount yearCount2001 = result.stream().filter(ydc -> ydc.getYear().equalsIgnoreCase("2001")).findFirst().get();
        assertEquals(yearCount2001.getNumDVDs(), 2);
    }
    
    private void addDVDs() {
        dao.addDVD(new DVD("My Neighbor Totoro", "1988", "G", "Hayao Miyazaki", "Studio Ghibli", "Scary monsters try to eat two kids"));
        dao.addDVD(new DVD("Kiki's Delivery Service", "1989", "G", "Hayao Miyazaki", "Studio Ghibli", "Young witch leads on nerd boy while starting a business"));
        dao.addDVD(new DVD("Princess Mononoke", "1997", "PG-13", "Hayao Miyazaki", "Studio Ghibli", "Cute little forest spirits get mad"));
        
        dao.addDVD(new DVD("Spirited Away", "2001", "PG", "Hayao Miyazaki", "Studio Ghibli", "Girl does some dirty work at a bathhouse"));
        dao.addDVD(new DVD("Amélie", "2001", "R", "Jean-Pierre Jeunet", "Claudie Ossard Productions", "Weird cute French girl does things around town"));
        
        dao.addDVD(new DVD("Spring, Summer, Fall, Winter... and Spring", "2003", "R", "Ki-duk Kim", "Korea Pictures", "Buddhist gets horny and goes to town"));
        dao.addDVD(new DVD("Finding Nemo", "2003", "G", "Andrew Stanton", "Pixar", "Stupid fish swims around aimlessly"));
        
        
        dao.addDVD(new DVD("Howl's Moving Castle", "2004", "PG", "Hayao Miyazaki", "Studio Ghibli", "Crazy guy with cool mobile home"));
        dao.addDVD(new DVD("Mr. Nobody", "2009", "R", "Jaco Van Dormael", "Pan Européenne", "Future guy with face tattoos interviews old crazy man"));
        dao.addDVD(new DVD("Inside Out", "2015", "PG", "Pete Docter", "Pixar", "Lunatics inside our heads drive all our actions"));
        dao.addDVD(new DVD("10 Cloverfield Lane", "2016", "PG-13", "Dan Trachtenberg", "Paramount Pictures", "Aliens are real"));
        
    }
}
