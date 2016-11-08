package com.jorypestorious.dvdlibrarymvc.controller;

import com.jorypestorious.dvdlibrarymvc.dao.DVDLibraryDao;
import com.jorypestorious.dvdlibrarymvc.dao.SearchTerm;
import com.jorypestorious.dvdlibrarymvc.dto.DVD;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {
    
    private final DVDLibraryDao dao;

    @Inject
    public SearchController(DVDLibraryDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "search";
    }

    @RequestMapping(value = "search/dvds", method = RequestMethod.POST)
    @ResponseBody
    public List<DVD> searchDVDs(@RequestBody Map<String, String> searchMap) {
        Map<SearchTerm, String> criteriaMap = new HashMap<>();

        String currentTerm = searchMap.get("title");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.TITLE, currentTerm);
        }
        currentTerm = searchMap.get("year");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.YEAR, currentTerm);
        }
        currentTerm = searchMap.get("mpaa");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.MPAA, currentTerm);
        }
        currentTerm = searchMap.get("studio");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.STUDIO, currentTerm);
        }
        currentTerm = searchMap.get("director");
        if (!currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.DIRECTOR, currentTerm);
        }

        return dao.searchDVDs(criteriaMap);
    }
}
