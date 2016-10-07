package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataStorageManagement implements DAO {
    
    private final List<Address> addressBook;
    private final DataPersistence dao;
    private final String filename;
    
    public DataStorageManagement(String filename) {
        dao = new DataPersistence();
        this.filename = filename;
        addressBook = dao.fileToHashMap(filename);
    }
    
    @Override
    public List getAddressBook() {
        return new ArrayList<>(addressBook);
    }
    
    @Override
    public int getNumOfAddresses() {
        return addressBook.size();
    }
    
    @Override
    public boolean addAddress(Address a) {
        if (addressBook.contains(a)) {
            return false;
        } else {
            addressBook.add(new Address(a.getFirstName(), a.getLastName(), a.getStreet(), 
                                        a.getCity(), a.getState(), a.getZipcode()));
            save();
            return true;
        }
    }
    
    @Override
    public void removeAddress(int index) {
        addressBook.remove(index);
        save();
    }
    
    @Override
    public void editAddress(int index, Address a) {
        addressBook.set(index, a);
        save();
    }

    @Override
    public List findAddress(String lastName) {
        List<Address> searchQuery = addressBook.stream()
                .filter(a -> a.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
        
        return searchQuery;
    }
    
    @Override
    public void save() {
        dao.saveToFile(addressBook, filename);
    }

}
