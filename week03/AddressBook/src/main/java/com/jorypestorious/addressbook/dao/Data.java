package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.util.HashMap;

public class Data {
    
    private final HashMap<String, Address> addressBook;
    private final DataAccess dao;
    
    public Data(String filename) {
        dao = new DataAccess();
        addressBook = dao.fileToHashMap(filename);
    }
    
    public HashMap getAddressBook() {
        return new HashMap<>(addressBook);
    }
    
    public int getNumOfAddresses() {
        return addressBook.size();
    }
    
    public boolean addAddress(Address a) {
        if (addressBook.containsKey(a.))
        
    }

    

}
