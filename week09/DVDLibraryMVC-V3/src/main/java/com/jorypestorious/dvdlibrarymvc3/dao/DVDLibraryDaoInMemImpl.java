package com.jorypestorious.dvdlibrarymvc3.dao;

import com.jorypestorious.dvdlibrarymvc3.dto.DVD;
import com.jorypestorious.dvdlibrarymvc3.dto.MpaaDVDCount;
import com.jorypestorious.dvdlibrarymvc3.dto.YearDVDCount;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DVDLibraryDaoInMemImpl implements DVDLibraryDao {
    
    private final Map<Integer, DVD> dvdMap = new HashMap<>();
    private static int idCounter = 0;

    @Override
    public DVD addDVD(DVD dvd) {
        dvd.setId(idCounter);
        // increment the counter so it is ready for use for the next contact
        idCounter++;
        dvdMap.put(dvd.getId(), dvd);
        return dvd;
    }

    @Override
    public void removeDVD(int id) {
        dvdMap.remove(id);
    }

    @Override
    public void updateDVD(DVD dvd) {
        dvdMap.put(dvd.getId(), dvd);
    }

    @Override
    public List<DVD> getAllDVDs() {
        Collection<DVD> c = dvdMap.values();
        return new ArrayList(c);
    }

    @Override
    public DVD getDVDById(int id) {
        return dvdMap.get(id);
    }

    @Override
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria) {
        String titleCriteria = criteria.get(SearchTerm.TITLE);
        String yearCriteria = criteria.get(SearchTerm.YEAR);
        String mpaaCriteria = criteria.get(SearchTerm.MPAA);
        String directorCriteria = criteria.get(SearchTerm.DIRECTOR);
        String studioCriteria = criteria.get(SearchTerm.STUDIO);
        
        Predicate<DVD> titleMatches;
        Predicate<DVD> yearMatches;
        Predicate<DVD> mpaaMatches;
        Predicate<DVD> directorMatches;
        Predicate<DVD> studioMatches;
        
        Predicate<DVD> truePredicate = (c) -> {return true;};
        
        titleMatches = (titleCriteria == null || titleCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getTitle().equalsIgnoreCase(titleCriteria);

        yearMatches = (yearCriteria == null || yearCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getYear().equalsIgnoreCase(yearCriteria);

        mpaaMatches = (mpaaCriteria == null || mpaaCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getMpaa().equalsIgnoreCase(mpaaCriteria);

        directorMatches = (directorCriteria == null || directorCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getDirector().equalsIgnoreCase(directorCriteria);

        studioMatches = (studioCriteria == null || studioCriteria.isEmpty())
                ? truePredicate
                : (c) -> c.getStudio().equalsIgnoreCase(studioCriteria);
        
        return dvdMap.values().stream()
                .filter(titleMatches
                        .and(yearMatches)
                        .and(mpaaMatches)
                        .and(directorMatches)
                        .and(studioMatches))
                .collect(Collectors.toList());
    }

    @Override
    public List<MpaaDVDCount> getMpaaDVDCounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<YearDVDCount> getYearDVDCounts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
