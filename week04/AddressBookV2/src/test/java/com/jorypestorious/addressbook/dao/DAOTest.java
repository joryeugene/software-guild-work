
package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAOTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAddressBook() {
        System.out.println("getAddressBook");
        DAO instance = new DAOImpl();
        List expResult = null;
        List result = instance.getAddressBook();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetNumOfAddresses() {
        System.out.println("getNumOfAddresses");
        DAO instance = new DAOImpl();
        int expResult = 0;
        int result = instance.getNumOfAddresses();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddAddress() {
        System.out.println("addAddress");
        Address a = null;
        DAO instance = new DAOImpl();
        boolean expResult = false;
        boolean result = instance.addAddress(a);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveAddress() {
        System.out.println("removeAddress");
        int index = 0;
        DAO instance = new DAOImpl();
        instance.removeAddress(index);
        fail("The test case is a prototype.");
    }

    @Test
    public void testEditAddress() {
        System.out.println("editAddress");
        int index = 0;
        Address a = null;
        DAO instance = new DAOImpl();
        instance.editAddress(index, a);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchAddressesByLastName() {
        System.out.println("searchAddressesByLastName");
        String lastName = "";
        DAO instance = new DAOImpl();
        List expResult = null;
        List result = instance.searchAddressesByLastName(lastName);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchAddressesByCity() {
        System.out.println("searchAddressesByCity");
        String city = "";
        DAO instance = new DAOImpl();
        List expResult = null;
        List result = instance.searchAddressesByCity(city);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchAddressesByState() {
        System.out.println("searchAddressesByState");
        String state = "";
        DAO instance = new DAOImpl();
        Map expResult = null;
        Map result = instance.searchAddressesByState(state);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSearchAddressesByZip() {
        System.out.println("searchAddressesByZip");
        int zip = 0;
        DAO instance = new DAOImpl();
        List expResult = null;
        List result = instance.searchAddressesByZip(zip);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSave() {
        System.out.println("save");
        DAO instance = new DAOImpl();
        instance.save();
        fail("The test case is a prototype.");
    }

    public class DAOImpl implements DAO {

        public List getAddressBook() {
            return null;
        }

        public int getNumOfAddresses() {
            return 0;
        }

        public boolean addAddress(Address a) {
            return false;
        }

        public void removeAddress(int index) {
        }

        public void editAddress(int index, Address a) {
        }

        public List searchAddressesByLastName(String lastName) {
            return null;
        }

        public List searchAddressesByCity(String city) {
            return null;
        }

        public Map searchAddressesByState(String state) {
            return null;
        }

        public List searchAddressesByZip(int zip) {
            return null;
        }

        public void save() {
        }
    }

}