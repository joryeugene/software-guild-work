//
//package com.jorypestorious.dvdlibrarymvc.dao;
//
//import com.jorypestorious.dvdlibrarymvc.dto.DVD;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import static junit.framework.TestCase.assertEquals;
//import static junit.framework.TestCase.assertNull;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//public class DVDLibraryDaoTest {
//    
//    private DVDLibraryDao dao;
//    
//    @Before
//    public void setUp() {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
//        dao = ctx.getBean("dvdLibraryDao", DVDLibraryDao.class);
//    }
//    
//    @Test
//    public void testAddGetRemoveDVD() {
//        System.out.println("addDVD");
//        DVD dvd = new DVD("Test Title", "2000", "G", "Test Director", "Test Studio", "Test note");
//        dao.addDVD(dvd);
//        DVD fromDB = dao.getDVDById(dvd.getId());
//        assertEquals(dvd, fromDB);
//        
//        dao.removeDVD(dvd.getId());
//        assertNull(dao.getDVDById(dvd.getId()));
//    }
//    
//    @Test
//    public void testUpdateDVD() {
//        System.out.println("updateDVD");
//        DVD dvd = new DVD("Test Title", "2000", "G", "Test Director", "Test Studio", "Test note");
//        dao.addDVD(dvd);
//        dvd.setTitle("New Title");
//        dao.updateDVD(dvd);
//        DVD fromDB = dao.getDVDById(dvd.getId());
//        assertEquals(dvd, fromDB);
//    }
//    
//    @Test
//    public void testGetAllDVDs() {
//        System.out.println("getAllDVDs");
//        DVD dvd1 = new DVD("Test Title", "2000", "G", "Test Director", "Test Studio", "Test note");
//        DVD dvd2 = new DVD("Test Title", "2000", "G", "Test Director", "Test Studio", "Test note");
//        dao.addDVD(dvd1);
//        dao.addDVD(dvd2);
//        assertEquals(2, dao.getAllDVDs().size());
//    }
//    
//    @Test
//    public void testSearchDVDs() {
//        System.out.println("searchDVDs");
//        DVD dvd1 = new DVD("Test Title", "2000", "G", "Test Director", "Test Studio", "Test note");
//        DVD dvd2 = new DVD("Test Title", "2000", "G", "Test Director", "Test Studio", "Test note");
//        DVD dvd3 = new DVD("Different Title", "2000", "PG", "Different Director", "Different Studio", "Test note");
//        dao.addDVD(dvd1);
//        dao.addDVD(dvd2);
//        dao.addDVD(dvd3);
//        
//        Map<SearchTerm, String> criteria = new HashMap<>();
//        criteria.put(SearchTerm.TITLE, "Different Title");
//        List<DVD> cList = dao.searchDVDs(criteria);
//        assertEquals(1, cList.size());
//        assertEquals(dvd3, cList.get(0));
//        
//        criteria.clear();
//        criteria.put(SearchTerm.YEAR, "2000");
//        cList = dao.searchDVDs(criteria);
//        assertEquals(3, cList.size());
//        
//        criteria.put(SearchTerm.MPAA, "G");
//        cList = dao.searchDVDs(criteria);
//        assertEquals(2, cList.size());        
//    }
//    
//}