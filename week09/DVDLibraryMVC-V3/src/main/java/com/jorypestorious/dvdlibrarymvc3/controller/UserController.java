package com.jorypestorious.dvdlibrarymvc3.controller;

import com.jorypestorious.dvdlibrarymvc3.dao.UserDao;
import com.jorypestorious.dvdlibrarymvc3.dto.User;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserDao dao;
    private final PasswordEncoder encoder;

    @Inject
    public UserController(UserDao dao, PasswordEncoder encoder) {
        this.dao = dao;
        this.encoder = encoder;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String displayUserList(Map<String, Object> model) {
        List users = dao.getAllUsers();
        model.put("users", users);
        return "displayUserList";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(HttpServletRequest req, Model model) {
        String userNm = req.getParameter("username");
        String clearPw = req.getParameter("password");
        
        List<User> users = dao.getAllUsers();
        
        boolean unAlreadyUsed = users.stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(userNm));

        if (unAlreadyUsed) {
            model.addAttribute("users", users);
            model.addAttribute("unAlreadyUsed", unAlreadyUsed);

            return "displayUserList";
            
        } else if (userNm.length() < 1 || clearPw.length() < 1) {

            boolean pwError = clearPw.length() < 1;
            boolean unError = userNm.length() < 1;

            model.addAttribute("users", users);
            model.addAttribute("pwError", pwError);
            model.addAttribute("unError", unError);

            return "displayUserList";

        } else {
            User newUser = new User();
            newUser.setUsername(userNm);
            newUser.setPassword(encoder.encode(clearPw));

            if (null != req.getParameter("isAdmin")) {
                newUser.addAuthority("ROLE_ADMIN");
            } else {
                newUser.addAuthority("ROLE_USER");
            }

            dao.addUser(newUser);

            return "redirect:admin";
        }
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("username") String username, Map<String, Object> model) {
        dao.deleteUser(username);
        return "redirect:admin";
    }
}
