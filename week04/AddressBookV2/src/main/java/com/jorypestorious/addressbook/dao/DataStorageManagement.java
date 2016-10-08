package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataStorageManagement implements DAO {
    
    private final List<Address> addressBook;
    private final DataPersistence dao;
    private final String filename;
    
    public DataStorageManagement(String filename) {
        dao = new DataPersistence();
        this.filename = filename;
        addressBook = dao.fileToHashMap(filename);
        setAddressIds();
    }
    
    @Override
    public List<Address> getAddressBook() {
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
                                        a.getCity(), a.getState(), a.getZipcode(), getNumOfAddresses()));
            save();
            return true;
        }
    }
    
    @Override
    public void removeAddress(int index) {
        addressBook.remove(index);
        setAddressIds();
        save();
    }
    
    @Override
    public void removeAll() {
        addressBook.clear();
    }
    
    @Override
    public void setAddressIds() {
        for (int i = 0; i < addressBook.size(); i++) {
            addressBook.get(i).setid(i);
        }
    }
    
    @Override
    public void editAddress(int index, Address a) {
        addressBook.set(index, a);
        save();
    }

    @Override
    public List searchAddressesByLastName(String lastName) {
        List<Address> searchQuery = addressBook.stream()
                .filter(a -> a.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
        
        return searchQuery;
    }
    
    @Override
    public List searchAddressesByCity(String city) {
        List<Address> searchQuery = addressBook.stream()
                .filter(a -> a.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
        
        return searchQuery;
    }
    
    @Override
    public Map searchAddressesByState(String state) {        
        Map<String, List<Address>> searchQuery = addressBook.stream()
                .filter((a) -> (a.getState().equalsIgnoreCase(state)))
                .collect(Collectors.groupingBy(Address::getCity));
        
        return searchQuery;
    }
    
    @Override
    public List searchAddressesByZip(int zip) {
        List<Address> searchQuery = addressBook.stream()
                .filter(a -> a.getZipcode() == zip)
                .collect(Collectors.toList());
        
        return searchQuery;
    }
    
    @Override
    public void save() {
        dao.saveToFile(addressBook, filename);
    }

}
