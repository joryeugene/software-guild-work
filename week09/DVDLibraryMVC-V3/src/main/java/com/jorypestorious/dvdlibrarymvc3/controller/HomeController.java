package com.jorypestorious.dvdlibrarymvc3.controller;

import com.jorypestorious.dvdlibrarymvc3.dao.DVDLibraryDao;
import com.jorypestorious.dvdlibrarymvc3.dto.DVD;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class HomeController {

    private final DVDLibraryDao dao;

    @Inject
    public HomeController(DVDLibraryDao dao) {
        this.dao = dao;
    }

//    private void populateLibrary() {
//        if (dao.getAllDVDs().size() < 1) {
//            dao.addDVD(new DVD("Finding Nemo", "2003", "G", "Andrew Stanton", "Pixar", "Stupid fish swims around aimlessly"));
//            dao.addDVD(new DVD("Spirited Away", "2001", "PG", "Hayao Miyazaki", "Studio Ghibli", "Girl does some dirty work at a bathhouse"));
//            dao.addDVD(new DVD("Mr. Nobody", "2009", "R", "Jaco Van Dormael", "Pan Européenne", "Future guy with face tattoos interviews old crazy man"));
//            dao.addDVD(new DVD("Inside Out", "2015", "PG", "Pete Docter", "Pixar", "Lunatics inside our heads drive all our actions"));
//            dao.addDVD(new DVD("10 Cloverfield Lane", "2016", "PG-13", "Dan Trachtenberg", "Paramount Pictures", "Aliens are real"));
//            dao.addDVD(new DVD("My Neighbor Totoro", "1988", "G", "Hayao Miyazaki", "Studio Ghibli", "Scary monsters try to eat two kids"));
//            dao.addDVD(new DVD("Spring, Summer, Fall, Winter... and Spring", "2003", "R", "Ki-duk Kim", "Korea Pictures", "Buddhist gets horny and goes to town"));
//            dao.addDVD(new DVD("Princess Mononoke", "1997", "PG-13", "Hayao Miyazaki", "Studio Ghibli", "Cute little forest spirits get mad"));
//            dao.addDVD(new DVD("Howl's Moving Castle", "2004", "PG", "Hayao Miyazaki", "Studio Ghibli", "Crazy guy with cool mobile home"));
//            dao.addDVD(new DVD("Amélie", "2001", "R", "Jean-Pierre Jeunet", "Claudie Ossard Productions", "Weird cute French girl does things around town"));
//            dao.addDVD(new DVD("Kiki's Delivery Service", "1989", "G", "Hayao Miyazaki", "Studio Ghibli", "Young witch leads on nerd boy while starting a business"));
//        }
//    }
    
    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String displayHomePage() {
        return "index";
    }

    @RequestMapping(value = {"/library"}, method = RequestMethod.GET)
    public String displayMainAjaxPage() {
        return "library";
    }

    @RequestMapping(value = "/getdvd/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DVD getContact(@PathVariable("id") int id) {
        return dao.getDVDById(id);
    }

    @RequestMapping(value = "/dvd", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public DVD createDVD(@Valid @RequestBody DVD dvd) {
        dao.addDVD(dvd);
        return dvd;
    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDVD(@PathVariable("id") int id) {
        dao.removeDVD(id);
    }

    @RequestMapping(value = "/dvd/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void putDVD(@PathVariable("id") int id, @Valid @RequestBody DVD dvd) {
        dvd.setId(id);
        dao.updateDVD(dvd);
    }

    @RequestMapping(value = "/dvds", method = RequestMethod.GET)
    @ResponseBody
    public List<DVD> getAllDVDs() {
        return dao.getAllDVDs();
    }
}
