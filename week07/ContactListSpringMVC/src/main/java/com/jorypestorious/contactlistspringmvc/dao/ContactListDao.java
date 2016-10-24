package com.jorypestorious.contactlistspringmvc.dao;

import com.jorypestorious.contactlistspringmvc.dto.Contact;
import java.util.List;
import java.util.Map;

public interface ContactListDao {

    public Contact addContact(Contact contact);

    public void removeContact(int contactId);

    public void updateContact(Contact contact);

    public List<Contact> getAllContacts();

    public Contact getContactById(int contactId);

    public List<Contact> searchContacts(Map<SearchTerm, String> criteria);
    
}
