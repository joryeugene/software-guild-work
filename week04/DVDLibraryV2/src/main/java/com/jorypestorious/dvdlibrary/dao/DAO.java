package com.jorypestorious.dvdlibrary.dao;

import com.jorypestorious.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.Map;

public interface DAO {
    
    void save();
    
    Map<String, DVD> getDVDLibrary();
    
    DVD searchByTitle(String title);
    
    List<DVD> searchByStudio(String studio);
    
    List<DVD> searchByMpaa(String mpaa);
    
    Map<String, List<DVD>> searchByDirector(String director);
    
    List<DVD> findRecent(int years);
    
    DVD findNewest();
    
    DVD findOldest();
    
    int findAverageAge();
    
    boolean addDVD(DVD d);
    
    boolean removeDVD(String title);

}
