package com.jorypestorious.dvdlibrary.controller;

import com.jorypestorious.dvdlibrary.dao.DAO;
import com.jorypestorious.dvdlibrary.dto.DVD;
import com.jorypestorious.dvdlibrary.ui.ConsoleIO;
import com.jorypestorious.dvdlibrary.ui.UI;
import java.util.List;
import java.util.Map;

public class Controller {
    
    private final ConsoleIO io;
    private final DAO dao;
    private final UI ui;
    
    public Controller(DAO library) {
        dao = library;
        io = new ConsoleIO();
        ui = new UI();
    }
    
    public void run() throws InterruptedException {
        String menuPrompt = "\n                  DVD LIBRARY                  \n" +
                              "===============================================\n" +
                              "1. View Complete Library\n" +
                              "2. Search by Title\n" +
                              "3. Search by Studio\n" +
                              "4. Search by MPAA Rating\n" +
                              "5. Search by Director\n" +
                              "6. Find DVDs Released in the Last X Years\n" +
                              "7. Find the Newest DVD\n" +
                              "8. Find the Oldest DVD\n" +
                              "9. Find the Average Release Year of Collection\n" +
                              "10. Add a DVD\n" +
                              "11. Remove a DVD\n" +
                              "0. Exit\n\n" +
                              "> Selection: ";
                
        boolean keepRunning = true;
        
        while (keepRunning) {
            int selection = io.promptInt(menuPrompt, 0, 11);
            io.display(""); // line break
            
            switch (selection) {
                case 1:
                    ui.listLibrary(dao.getDVDLibrary());
                    break;
                case 2:
                    searchByTitle();
                    break;
                case 3:
                    searchByStudio();
                    break;
                case 4:
                    searchByMpaa();
                    break;
                case 5:
                    searchByDirector();
                    break;
                case 6:
                    findRecent();
                    break;
                case 7:
                    findNewest();
                    break;
                case 8:
                    findOldest();
                    break;
                case 9:
                    findAverageAge();
                    break;
                case 10:
                    addDVD();
                    break;
                case 11:
                    removeDVD();
                    break;
                case 0:
                    keepRunning = false;
            }
            
            Thread.sleep(1000);
        }
        
        io.display("Goodbye.");
        dao.save();
    }
    
    private void searchByTitle() {
        String title = io.promptString("Title to Search for: ");
        DVD d = dao.searchByTitle(title);
        if (d != null) {
            io.display("\n" + d);
        } else {
            io.display("! DVD Not Found");
        }
    }
    
    private void searchByStudio() {
        String studio = io.promptString("Studio to Search for: ");
        List<DVD> searchQuery = dao.searchByStudio(studio);
        if (searchQuery.size() > 0) {
            ui.displayListQuery(searchQuery);
        } else {
            io.display("! No Results Found");
        }
    }
    
    private void searchByMpaa() {
        String mpaa = io.promptString("MPAA Rating (G, PG, PG-13, R, NC-17): ");
        List<DVD> searchQuery = dao.searchByMpaa(mpaa);
        if (searchQuery.size() > 0) {
            ui.displayListQuery(searchQuery);
        } else {
            io.display("! No Results Found");
        }
    }
    
    private void searchByDirector() {
        String director = io.promptString("Director to Search for: ");
        Map<String, List<DVD>> searchQuery = dao.searchByDirector(director);
        if (searchQuery.size() > 0) {
            ui.displayListQuery(searchQuery);
        } else {
            io.display("! No Results Found");
        }
    }
    
    private void findRecent() {
        int years = io.promptInt("DVDs Released within the Last X Years: ", 1, 150);
        List<DVD> searchQuery = dao.findRecent(years);
        if (searchQuery.size() > 0) {
            ui.displayListQuery(searchQuery);
        } else {
            io.display("! No Results Found");
        }
    }
    
    private void findNewest() {
        DVD d = dao.findNewest();
        if (d != null) {
            ui.displayDVD(d);
        } else {
            io.display("! Not Found");
        }
    }
    
    private void findOldest() {
        DVD d = dao.findOldest();
        if (d != null) {
            ui.displayDVD(d);
        } else {
            io.display("! Not Found");
        }
    }
    
    private void findAverageAge() {
        int averageAge = dao.findAverageAge();
        io.display("Average Release Year is " + averageAge);
    }
    
    private void addDVD() {
        String title = io.promptString("Title: ");
        int year = io.promptInt("Year Released: ", 1900, 2020);
        String mpaa = io.promptString("MPAA Rating (G, PG, PG-13, R, NC-17): ").toUpperCase();
        String director = io.promptString("Director: ");
        String studio = io.promptString("Production Studio: ");
        String note = io.promptStringNoCase("User Rating or Note: ");
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
        
