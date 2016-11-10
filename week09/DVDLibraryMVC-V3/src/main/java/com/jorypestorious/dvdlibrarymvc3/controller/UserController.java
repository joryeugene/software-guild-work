package com.jorypestorious.dvdlibrarymvc3.controller;

import com.jorypestorious.dvdlibrarymvc3.dao.UserDao;
import com.jorypestorious.dvdlibrarymvc3.dto.User;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserDao dao;

    @Inject
    public UserController(UserDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/displayUserList", method = RequestMethod.GET)
    public String displayUserList(Map<String, Object> model) {
        List users = dao.getAllUsers();
        model.put("users", users);
        return "displayUserList";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(HttpServletRequest req) {
        User newUser = new User();

        newUser.setUsername(req.getParameter("username"));
        newUser.setPassword(req.getParameter("password"));

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
