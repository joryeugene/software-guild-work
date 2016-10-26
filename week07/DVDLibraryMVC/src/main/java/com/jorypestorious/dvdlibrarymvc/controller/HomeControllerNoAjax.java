package com.jorypestorious.dvdlibrarymvc.controller;

import com.jorypestorious.dvdlibrarymvc.dao.DVDLibraryDao;
import com.jorypestorious.dvdlibrarymvc.dto.DVD;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeControllerNoAjax {

    // Reference to our DAO
    private final DVDLibraryDao dao;

    @Inject
    public HomeControllerNoAjax(DVDLibraryDao dao) {
        this.dao = dao;
        dao.addDVD(new DVD("Finding Nemo", "2003", "G", "Andrew Stanton", "Pixar", "Stupid fish swims around aimlessly"));
        dao.addDVD(new DVD("Spirited Away", "2001", "PG", "Hayao Miyazaki", "Studio Ghibli", "Young girl does some dirty work at a bathhouse"));
    }

    @RequestMapping(value = "/displayDVDLibraryNoAjax", method = RequestMethod.GET)
    public String displayDVDLibraryNoAjax(Model model) {
        List<DVD> dvdList = dao.getAllDVDs();
        model.addAttribute("dvdList", dvdList);
        return "displayDVDLibraryNoAjax";
    }

    @RequestMapping(value = "/displayNewDVDFormNoAjax", method = RequestMethod.GET)
    public String displayNewDVDFormNoAjax(Model model) {
        DVD dvd = new DVD("", "", "", "", "", "");
        model.addAttribute("dvd", dvd);
        return "newDVDFormNoAjax";
    }

    @RequestMapping(value = "/addNewDVDNoAjax", method = RequestMethod.POST)
    public String addNewDVDNoAjax(@Valid @ModelAttribute("dvd") DVD dvd, BindingResult result) {
        if (result.hasErrors()) {
            return "newDVDFormNoAjax";
        }
        
        dao.addDVD(dvd);
        return "redirect:displayDVDLibraryNoAjax";
    }

    @RequestMapping(value = "/deleteDVDNoAjax", method = RequestMethod.GET)
    public String deleteDVDNoAjax(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.removeDVD(id);
        return "redirect:displayDVDLibraryNoAjax";
    }

    @RequestMapping(value = "/displayEditDVDFormNoAjax", method = RequestMethod.GET)
    public String displayEditDVDFormNoAjax(HttpServletRequest req, Model model) {
        int id = Integer.parseInt(req.getParameter("id"));
        DVD dvd = dao.getDVDById(id);
        model.addAttribute("dvd", dvd);
        return "editDVDFormNoAjax";
    }

    @RequestMapping(value = "/editDVDNoAjax", method = RequestMethod.POST)
    public String editCDVDNoAjax(@Valid @ModelAttribute("dvd") DVD dvd, BindingResult result) {
        if (result.hasErrors()) {
            return "editDVDFormNoAjax";
        }
        
        dao.updateDVD(dvd);
        return "redirect:displayDVDLibraryNoAjax";
    }

}
