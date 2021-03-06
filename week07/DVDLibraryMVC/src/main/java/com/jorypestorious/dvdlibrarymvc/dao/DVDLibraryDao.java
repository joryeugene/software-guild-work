package com.jorypestorious.dvdlibrarymvc.dao;

import com.jorypestorious.dvdlibrarymvc.dto.DVD;
import java.util.List;
import java.util.Map;

public interface DVDLibraryDao {

    public DVD addDVD(DVD dvd);

    public void removeDVD(int id);

    public void updateDVD(DVD dvd);

    public List<DVD> getAllDVDs();

    public DVD getDVDById(int id);

    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria);
    
}
