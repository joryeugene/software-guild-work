package com.jorypestorious.dvdlibrarymvc3.controller;

import com.jorypestorious.dvdlibrarymvc3.dao.DVDLibraryDao;
import com.jorypestorious.dvdlibrarymvc3.dao.SearchTerm;
import com.jorypestorious.dvdlibrarymvc3.dto.DVD;
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

    @RequestMapping(value = "search/dvds", method = RequestMethod.POST)
    @ResponseBody
    public List<DVD> searchDVDs(@RequestBody Map<String, String> searchMap) {
        Map<SearchTerm, String> criteriaMap = new HashMap<>();
        criteriaMap.put(SearchTerm.TITLE, searchMap.get("title"));
        criteriaMap.put(SearchTerm.YEAR, searchMap.get("year"));
        criteriaMap.put(SearchTerm.MPAA, searchMap.get("mpaa"));
        criteriaMap.put(SearchTerm.STUDIO, searchMap.get("studio"));
        criteriaMap.put(SearchTerm.DIRECTOR, searchMap.get("director"));

        for (String currentTerm : criteriaMap.values()) {
            if (currentTerm.isEmpty() || currentTerm == null) {
                currentTerm = "";
            }
        }

        return dao.searchDVDs(criteriaMap);
    }
}
