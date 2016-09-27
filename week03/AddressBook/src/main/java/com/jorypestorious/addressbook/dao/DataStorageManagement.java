package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.util.HashMap;

public class DataStorageManagement {
    
    private final HashMap<String, Address> addressBook;
    private final DataPersistence dao;
    private final String filename;
    
    public DataStorageManagement(String filename) {
        dao = new DataPersistence();
        this.filename = filename;
        addressBook = dao.fileToHashMap(filename);
    }
    
    public HashMap getAddressBook() {
        return new HashMap<>(addressBook);
    }
    
    public int getNumOfAddresses() {
        return addressBook.size();
    }
    
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
    
    public boolean removeAddress(String name) {
        if (addressBook.containsKey(name)) {            
            addressBook.remove(name);
            dao.saveToFile(addressBook, filename);
            return true;
        } else {
            return false;
        }
    }
    
    public void editAddress(String fullName, Address a) {
        addressBook.replace(fullName, a);
        dao.saveToFile(addressBook, filename);
    }

    public HashMap findAddress(String lastName) {
        HashMap<String, Address> searchQuery = new HashMap<>();
        
        for (String name : addressBook.keySet()) {
            if (addressBook.get(name).getLastName().equalsIgnoreCase(lastName)) {
                searchQuery.put(name, addressBook.get(name));
            }
        }
        
        return searchQuery;
    }
    
    public void save() {
        dao.saveToFile(addressBook, filename);
    }

}
