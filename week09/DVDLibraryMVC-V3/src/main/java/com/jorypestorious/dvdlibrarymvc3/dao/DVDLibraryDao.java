package com.jorypestorious.dvdlibrarymvc3.dao;

import com.jorypestorious.dvdlibrarymvc3.dto.DVD;
import com.jorypestorious.dvdlibrarymvc3.dto.MpaaDVDCount;
import com.jorypestorious.dvdlibrarymvc3.dto.YearDVDCount;
import java.util.List;
import java.util.Map;

public interface DVDLibraryDao {

    public DVD addDVD(DVD dvd);

    public void removeDVD(int id);

    public void updateDVD(DVD dvd);

    public List<DVD> getAllDVDs();

    public DVD getDVDById(int id);

    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria);
    
    public List<MpaaDVDCount> getMpaaDVDCounts();
    
    public List<YearDVDCount> getYearDVDCounts();
    
}
