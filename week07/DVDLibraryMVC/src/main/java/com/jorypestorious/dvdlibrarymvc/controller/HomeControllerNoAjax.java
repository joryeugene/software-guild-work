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

    private final DVDLibraryDao dao;
    private boolean firstStart = true;

    @Inject
    public HomeControllerNoAjax(DVDLibraryDao dao) {
        this.dao = dao;
    }
    
    private void populateLibrary() {
        dao.addDVD(new DVD("Finding Nemo", "2003", "G", "Andrew Stanton", "Pixar", "Stupid fish swims around aimlessly"));
        dao.addDVD(new DVD("Spirited Away", "2001", "PG", "Hayao Miyazaki", "Studio Ghibli", "Girl does some dirty work at a bathhouse"));
        dao.addDVD(new DVD("Mr. Nobody", "2009", "R", "Jaco Van Dormael", "Pan Européenne", "Future guy with face tattoos interviews old crazy man"));
        dao.addDVD(new DVD("Inside Out", "2015", "PG", "Pete Docter", "Pixar", "Lunatics inside our heads and drive all our actions"));
        dao.addDVD(new DVD("Howl's Moving Castle", "2004", "PG", "Hayao Miyazaki", "Studio Ghibli", "Crazy guy with cool mobile home"));
        dao.addDVD(new DVD("My Neighbor Totoro", "1988", "G", "Hayao Miyazaki", "Studio Ghibli", "Scary monsters try to eat two kids"));
        dao.addDVD(new DVD("Spring, Summer, Fall, Winter... and Spring", "2003", "R", "Ki-duk Kim", "Korea Pictures", "Buddhist gets horny and goes to town"));
        dao.addDVD(new DVD("Princess Mononoke", "1997", "PG-13", "Hayao Miyazaki", "Studio Ghibli", "Cute little forest spirits get mad"));
        dao.addDVD(new DVD("Amélie", "2001", "R", "Jean-Pierre Jeunet", "Claudie Ossard Productions", "Weird cute French girl does things around town"));
        dao.addDVD(new DVD("Kiki's Delivery Service", "1989", "G", "Hayao Miyazaki", "Studio Ghibli", "Young witch leads on nerd boy while starting a business"));
    }
    
    @RequestMapping(value = "/displayDVDLibraryNoAjax", method = RequestMethod.GET)
    public String displayDVDLibraryNoAjax(Model model) {
        if (firstStart) {
            populateLibrary();
            firstStart = false;
        }
        
        model.addAttribute("dvd", new DVD());
        model.addAttribute("dvdList", dao.getAllDVDs());
        return "displayDVDLibraryNoAjax";
    }
    
    @RequestMapping(value = "/addNewDVDNoAjax", method = RequestMethod.POST)
    public String addNewDVDNoAjax(@Valid @ModelAttribute("dvd") DVD dvd, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("dvdList", dao.getAllDVDs());
            return "displayDVDLibraryNoAjax";
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
