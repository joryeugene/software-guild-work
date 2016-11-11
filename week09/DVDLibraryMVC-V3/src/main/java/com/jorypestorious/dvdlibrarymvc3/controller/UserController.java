package com.jorypestorious.dvdlibrarymvc3.controller;

import com.jorypestorious.dvdlibrarymvc3.dao.UserDao;
import com.jorypestorious.dvdlibrarymvc3.dto.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserDao dao;
    private PasswordEncoder encoder;

    @Inject
    public UserController(UserDao dao, PasswordEncoder encoder) {
        this.dao = dao;
        this.encoder = encoder;
        
        populate();
    }
    
    private void populate() {
        List users = dao.getAllUsers();
        
        if (users.size() < 1) {
            User user = new User();
            List<String> authorities = new ArrayList<>();
            authorities.add("ROLE_ADMIN");
            user.setAuthorities(authorities);
            String hashPw = encoder.encode("password");
            user.setPassword(hashPw);
            user.setUsername("admin");
            dao.addUser(user);
        }
    }

    @RequestMapping(value = "/displayUserList", method = RequestMethod.GET)
    public String displayUserList(Map<String, Object> model) {
        List users = dao.getAllUsers();
        
        if (users.size() < 1) {
            User user = new User();
            List<String> authorities = new ArrayList<>();
            authorities.add("ROLE_ADMIN");
            user.setAuthorities(authorities);
            String hashPw = encoder.encode("password");
            user.setPassword(hashPw);
            user.setUsername("admin");
            dao.addUser(user);
        }
        model.put("users", users);
        return "displayUserList";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(HttpServletRequest req) {
        User newUser = new User();

        String clearPw = req.getParameter("password");
        String hashPw = encoder.encode(clearPw);
        newUser.setPassword(hashPw);
        newUser.setUsername(req.getParameter("username"));

        if (null != req.getParameter("isAdmin")) {
            newUser.addAuthority("ROLE_ADMIN");
        } else {
            newUser.addAuthority("ROLE_USER");
        }

        dao.addUser(newUser);

        return "redirect:displayUserList";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("username") String username, Map<String, Object> model) {
        dao.deleteUser(username);
        return "redirect:displayUserList";
    }
}
