package com.jorypestorious.addressbook.dao;

import com.jorypestorious.addressbook.dto.Address;
import java.util.List;
import java.util.Map;

public interface DAO {
    
    List<Address> getAddressBook();
    
    int getNumOfAddresses();
    
    boolean addAddress(Address a);
    
    void removeAddress(int index);
    
    void removeAll();
    
    void setAddressIds();
    
    void editAddress(int index, Address a);

    List searchAddressesByLastName(String lastName);
    
    List searchAddressesByCity(String city);
    
    Map searchAddressesByState(String state);
    
    List searchAddressesByZip(int zip);
    
    void save();

}
