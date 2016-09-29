package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.util.Map;

public interface DAO {
    
    Map getAddressBook();
    
    int getNumOfAddresses();
    
    boolean addAddress(Address a);
    
    boolean removeAddress(String name);
    
    void editAddress(String fullName, Address a);

    Map findAddress(String lastName);
    
    void save();

}
