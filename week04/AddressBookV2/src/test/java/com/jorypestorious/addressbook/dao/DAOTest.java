
package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAOTest {
    
    DAO instance = new DataStorageManagement("test.txt");
    
    @Before
    public void setUp() {
        instance.removeAll();
        
        instance.addAddress(new Address("First1", "Last1", "1 Street Street", "City1", "AA", 10000));
        instance.addAddress(new Address("First2", "Last2", "2 Street Street", "City2", "AA", 10000));
        instance.addAddress(new Address("First3", "Last3", "3 Street Street", "City3", "AA", 20000));
        instance.addAddress(new Address("First4", "Last4", "4 Street Street", "City4", "BB", 10000));
    }
    
    @After
    public void tearDown() {
        instance.removeAll();
    }
    
    @Test
    public void testGetAddressBook() {
        System.out.println("getAddressBook");
        instance.getAddressBook().stream().forEach(a -> System.out.println(a));
        int expResult = 4;
        int result = instance.getAddressBook().size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetNumOfAddresses() {
        System.out.println("getNumOfAddresses");
        int expResult = 4;
        int result = instance.getAddressBook().size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAddAddress() {
        System.out.println("addAddress");
        instance.addAddress(new Address("First5", "Last5", "5 Street Street", "City5", "BB", 10000));
        int expResult = 5;
        int result = instance.getAddressBook().size();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoveAddress() {
        System.out.println("removeAddress");
        int index = 0;
        instance.removeAddress(index);
        int expResult = 3;
        int result = instance.getAddressBook().size();
        assertEquals(expResult, result);
    }
//
    @Test
    public void testEditAddress() {
        System.out.println("editAddress");
        int index = 0;
        Address a = instance.getAddressBook().get(index);
        a.setFirstName("TEST");
        instance.editAddress(index, a);
        assertEquals(instance.getAddressBook().get(index), a);
    }

    @Test
    public void testSearchAddressesByLastName() {
        System.out.println("searchAddressesByLastName");
        String lastName = "Last4";
        int expResult = 1;
        int result = instance.searchAddressesByLastName(lastName).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchAddressesByCity() {
        System.out.println("searchAddressesByCity");
        String city = "City4";
        int expResult = 1;
        int result = instance.searchAddressesByCity(city).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchAddressesByState() {
        System.out.println("searchAddressesByState");
        String state = "AA";
        int expResult = 3;
        int result = instance.searchAddressesByState(state).size();
        assertEquals(expResult, result);
    }

    @Test
    public void testSearchAddressesByZip() {
        System.out.println("searchAddressesByZip");
        int zip = 10000;
        int expResult = 3;
        int result = instance.searchAddressesByZip(zip).size();
        assertEquals(expResult, result);
    }
    
}