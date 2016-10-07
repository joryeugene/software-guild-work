package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.util.List;

public interface DAO {
    
    List getAddressBook();
    
    int getNumOfAddresses();
    
    boolean addAddress(Address a);
    
    void removeAddress(int index);
    
    void editAddress(int index, Address a);

    List findAddress(String lastName);
    
    void save();

}
