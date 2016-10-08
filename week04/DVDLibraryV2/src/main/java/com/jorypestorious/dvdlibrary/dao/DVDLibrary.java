package com.jorypestorious.dvdlibrary.dao;

import com.jorypestorious.dvdlibrary.dto.DVD;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DVDLibrary implements DAO {
    
    private final Map<String, DVD> dvdLibrary;
    private final DataPersistence dao;
    private final String filename;
    int year;
    
    public DVDLibrary(String filename) {
        this.filename = filename;
        dao = new DataPersistence();
        dvdLibrary = dao.fileToHashMap(filename);
        Calendar now = Calendar.getInstance();
        year = now.get(Calendar.YEAR);
    }
    
    @Override
    public void save() {
        dao.saveToFile(dvdLibrary, filename);
    }
    
    @Override
    public Map<String, DVD> getDVDLibrary() {
        return new HashMap<>(dvdLibrary);
    }
    
    @Override
    public DVD searchByTitle(String title) {
        DVD d = dvdLibrary.get(title);
        return d;
    }
    
    @Override
    public List<DVD> searchByStudio(String studio) {
        List<DVD> searchQuery = dvdLibrary.values().stream()
                .filter(dvd -> dvd.getStudio().equalsIgnoreCase(studio))
                .collect(Collectors.toList());
        
        return searchQuery;
    }
    
    @Override
    public List<DVD> searchByMpaa(String mpaa) {
        List<DVD> searchQuery = dvdLibrary.values().stream()
                .filter(dvd -> dvd.getMpaa().equalsIgnoreCase(mpaa))
                .collect(Collectors.toList());
        
        return searchQuery;
    }
    
    @Override
    public Map<String, List<DVD>> searchByDirector(String director) {        
        Map<String, List<DVD>> searchQuery = dvdLibrary.values().stream()
                .filter( dvd -> dvd.getDirector().equalsIgnoreCase(director) )
                .collect(Collectors.groupingBy(DVD::getMpaa));
        
        return searchQuery;
    }
    
    @Override
    public List<DVD> findRecent(int years) {
        List<DVD> searchQuery = dvdLibrary.values().stream()
                .filter(dvd -> dvd.getYear() >= year - years)
                .collect(Collectors.toList());
        
        return searchQuery;
    }
    
    @Override
    public DVD findNewest() {
        DVD d = null;
        if (dvdLibrary.size() > 0) d = dvdLibrary.values().stream()
                .max((dvd1, dvd2) -> dvd1.getYear() > dvd2.getYear() ? 1 : -1).get();
        
        return d;
    }
    
    @Override
    public DVD findOldest() {
        DVD d = null;
        if (dvdLibrary.size() > 0) d = dvdLibrary.values().stream()
                .min((dvd1, dvd2) -> dvd1.getYear() < dvd2.getYear() ? -1 : 1).get();
        
        return d;
    }
    
    @Override
    public int findAverageAge() {
        double averageAge = dvdLibrary.values().stream().mapToInt(dvd -> dvd.getYear()).average().getAsDouble();
        int truncatedAverage = (int) Math.round(averageAge);
        return truncatedAverage;
    }
    
    @Override
    public boolean addDVD(DVD d) {
        if (dvdLibrary.containsKey(d.getTitle())) {
            return false;
        } else {
            dvdLibrary.put(d.getTitle(), d);
            save();
            return true;
        }
    }
    
    @Override
    public boolean removeDVD(String title) {
        if (dvdLibrary.containsKey(title)) {
            dvdLibrary.remove(title);
            save();
            return true;
        } else {
            return false;
        }
    }
    
}
