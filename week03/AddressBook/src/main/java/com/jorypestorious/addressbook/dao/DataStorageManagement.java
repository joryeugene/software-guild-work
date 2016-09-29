package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.util.HashMap;
import java.util.Map;

public class DataStorageManagement implements DAO {
    
    private final Map<String, Address> addressBook;
    private final DataPersistence dao;
    private final String filename;
    
    public DataStorageManagement(String filename) {
        dao = new DataPersistence();
        this.filename = filename;
        addressBook = dao.fileToHashMap(filename);
    }
    
    @Override
    public Map getAddressBook() {
        return new HashMap<>(addressBook);
    }
    
    @Override
    public int getNumOfAddresses() {
        return addressBook.size();
    }
    
    @Override
    public boolean addAddress(Address a) {
        if (addressBook.containsKey(a.getLastName())) {
            return false;
        } else {
            addressBook.put(a.getFirstName() + " " + a.getLastName(), new Address(a.getFirstName(), a.getLastName(), a.getStreet(), 
                                                         a.getCity(), a.getState(), a.getZipcode()));
            
            dao.saveToFile(addressBook, filename);
            return true;
        }
    }
    
    @Override
    public boolean removeAddress(String name) {
        if (addressBook.containsKey(name)) {            
            addressBook.remove(name);
            dao.saveToFile(addressBook, filename);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public void editAddress(String fullName, Address a) {
        addressBook.replace(fullName, a);
        dao.saveToFile(addressBook, filename);
    }

    @Override
    public Map findAddress(String lastName) {
        Map<String, Address> searchQuery = new HashMap<>();
        
        for (String name : addressBook.keySet()) {
            if (addressBook.get(name).getLastName().equalsIgnoreCase(lastName)) {
                searchQuery.put(name, addressBook.get(name));
            }
        }
        
        return searchQuery;
    }
    
    @Override
    public void save() {
        dao.saveToFile(addressBook, filename);
    }

}
