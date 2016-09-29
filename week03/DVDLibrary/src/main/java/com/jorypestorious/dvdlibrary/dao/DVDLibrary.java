package com.jorypestorious.dvdlibrary.dao;

import com.jorypestorious.dvdlibrary.dto.DVD;
import java.util.HashMap;
import java.util.Map;

public class DVDLibrary implements DAO {
    
    private final Map<String, DVD> dvdLibrary;
    private final DataPersistence dao;
    private final String filename;
    
    public DVDLibrary(String filename) {
        this.filename = filename;
        dao = new DataPersistence();
        dvdLibrary = dao.fileToHashMap(filename);
    }
    
    @Override
    public void save() {
        dao.saveToFile(dvdLibrary, filename);
    }
    
    @Override
    public Map getDVDLibrary() {
        return new HashMap<>(dvdLibrary);
    }
    
    @Override
    public DVD findDVD(String title) {
        DVD d;
        if (dvdLibrary.containsKey(title)) return d = dvdLibrary.get(title);
        else return d = null;
    }
    
    @Override
    public boolean addDVD(DVD d) {
        if (dvdLibrary.containsKey(d.getTitle())) {
            return false;
        } else {
            dvdLibrary.put(d.getTitle(), d);
            dao.saveToFile(dvdLibrary, filename);
            return true;
        }
    }
    
    @Override
    public boolean removeDVD(String title) {
        if (dvdLibrary.containsKey(title)) {
            dvdLibrary.remove(title);
            dao.saveToFile(dvdLibrary, filename);
            return true;
        } else {
            return false;
        }
    }

}
