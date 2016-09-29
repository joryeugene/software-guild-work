package com.jorypestorious.dvdlibrary.dao;

import com.jorypestorious.dvdlibrary.dto.DVD;
import java.util.Map;

public interface DAO {
    
    void save();
    
    Map getDVDLibrary();
    
    DVD findDVD(String title);
    
    boolean addDVD(DVD d);
    
    boolean removeDVD(String title);

}
