package com.jorypestorious.dvdlibrary.dao;

import com.jorypestorious.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.Map;

public interface DAO {
    
    void save();
    
    Map getDVDLibrary();
    
    DVD searchByTitle(String title);
    
    List<DVD> searchByStudio(String studio);
    
    List<DVD> searchByMpaa(String mpaa);
    
    List<DVD> searchByDirector(String director);
    
    List<DVD> findRecent(int years);
    
    DVD findNewest();
    
    DVD findOldest();
    
    int findAverageAge();
    
    boolean addDVD(DVD d);
    
    boolean removeDVD(String title);

}
