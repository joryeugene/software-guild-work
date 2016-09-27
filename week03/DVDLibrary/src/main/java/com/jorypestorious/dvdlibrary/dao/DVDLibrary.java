package com.jorypestorious.dvdlibrary.dao;

import com.jorypestorious.dvdlibrary.dto.DVD;
import java.util.HashMap;

public class DVDLibrary {
    
    private final HashMap<String, DVD> dvdLibrary;
    private final DataPersistence dao;
    private final String filename;
    
    public DVDLibrary(String filename) {
        this.filename = filename;
        dao = new DataPersistence();
        dvdLibrary = dao.fileToHashMap(filename);
    }
    
    public void save() {
        dao.saveToFile(dvdLibrary, filename);
    }
    
    public HashMap getDVDLibrary() {
        return new HashMap<>(dvdLibrary);
    }
    
    public DVD findDVD(String title) {
        DVD d;
        if (dvdLibrary.containsKey(title)) return d = dvdLibrary.get(title);
        else return d = null;
    }
    
    public boolean addDVD(DVD d) {
        if (dvdLibrary.containsKey(d.getTitle())) {
            return false;
        } else {
            dvdLibrary.put(d.getTitle(), d);
            dao.saveToFile(dvdLibrary, filename);
            return true;
        }
    }
    
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
