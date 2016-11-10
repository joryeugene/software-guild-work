package com.jorypestorious.dvdlibrarymvc3.dao;

import com.jorypestorious.dvdlibrarymvc3.dto.User;
import java.util.List;

public interface UserDao {

    User addUser(User newUser);

    void deleteUser(String username);
    
    List<User> getAllUsers();

}
