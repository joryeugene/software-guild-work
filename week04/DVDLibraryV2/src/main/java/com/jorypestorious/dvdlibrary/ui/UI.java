package com.jorypestorious.dvdlibrary.ui;

import com.jorypestorious.dvdlibrary.dto.DVD;
import java.util.List;
import java.util.Map;

public class UI {
    
    public void listLibrary(Map<String, DVD> dvdLibrary) {
        System.out.println("\n                           (" + dvdLibrary.size() + ") DVDs                               \n" +
                           "------------------------------------------------------------------\n");
        
        for (String title : dvdLibrary.keySet()) {
            System.out.println(dvdLibrary.get(title) + "\n");
        }
        
        System.out.println("------------------------------------------------------------------\n");
    }
    
    public void displayDVD(DVD d) {
        System.out.println(d);
    }
    
    public void displayListQuery(List<DVD> dvds) {
        String results = "results";
        if (dvds.size() == 1) results = "result";
        
        System.out.println("\n                            " + dvds.size() + " " + results + "                           \n" +
                             "------------------------------------------------------------------\n");
        
        dvds.stream().forEach( dvd -> System.out.println(dvd + "\n") );
        
        System.out.println("------------------------------------------------------------------\n");
    }
    
    public void displayListQuery(Map<String, List<DVD>> dvds) {        
        System.out.println("\n------------------------------------------------------------------\n");
        
        for (String mpaa : dvds.keySet()) {
            System.out.println(">>>> " + mpaa + " <<<<");
            
            for (int i = 0; i < dvds.get(mpaa).size(); i++) {
                System.out.print(dvds.get(mpaa).get(i) + "\n\n");
            }
        }
        
        System.out.println("------------------------------------------------------------------\n");
    }

}
