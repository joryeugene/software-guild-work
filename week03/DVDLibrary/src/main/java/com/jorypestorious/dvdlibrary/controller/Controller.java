package com.jorypestorious.dvdlibrary.controller;

import com.jorypestorious.dvdlibrary.dao.DVDLibrary;
import com.jorypestorious.dvdlibrary.dto.DVD;
import com.jorypestorious.dvdlibrary.ui.ConsoleIO;
import com.jorypestorious.dvdlibrary.ui.UI;

public class Controller {
    
    private final ConsoleIO io;
    private final DVDLibrary dao;
    private final UI ui;
    
    public Controller(String filename) {
        dao = new DVDLibrary(filename);
        io = new ConsoleIO();
        ui = new UI();
    }
    
    public void run() throws InterruptedException {
        String menuPrompt = "\n       DVD LIBRARY\n" +
                            "===========================\n" +
                            "1. View Complete Library\n" +
                            "2. Find DVD by Title\n" +
                            "3. Add a DVD\n" +
                            "4. Remove a DVD\n" +
                            "5. Exit\n\n" +
                            "> Selection: ";
        
        boolean keepRunning = true;
        
        while (keepRunning) {
            int selection = io.promptInt(menuPrompt, 1, 5);
            io.display(""); // line break
            
            switch (selection) {
                case 1:
                    ui.listLibrary(dao.getDVDLibrary());
                    break;
                case 2:
                    findDVD();
                    break;
                case 3:
                    addDVD();
                    break;
                case 4:
                    removeDVD();
                    break;
                case 5:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
        
        dao.save();
    }
    
    private void findDVD() {
        String title = io.promptString("Title to Search for: ");
        DVD d = dao.findDVD(title);
        if (d != null) {
            ui.displayDVD(d);
        } else {
            io.display("! DVD Not Found");
        }
    }
    
    private void addDVD() {
        String title = io.promptString("Title: ");
        int year = io.promptInt("Year Released: ", 1900, 2020);
        String mpaa = io.promptString("MPAA Rating (G, PG, PG-13, R, NC-17): ").toUpperCase();
        String director = io.promptString("Director: ");
        String studio = io.promptString("Production Studio: ");
        String note = io.promptString("User Rating or Note: ");
        if (dao.addDVD(new DVD(title, year, mpaa, director, studio, note))) {
            io.display("* Successfully added \"" + title + "\"");
        } else {
            io.display("! Entry Already Exists for this Title");
        }
    }
    
    private void removeDVD() {
        String title = io.promptString("Title to Remove: ");
        if (dao.removeDVD(title)) {
            io.display("* Successfully removed " + title);
        } else {
            io.display("! DVD Not Found");
        }
    }

}
        
