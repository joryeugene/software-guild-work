package com.jorypestorious.dvdlibrary.ui;

import com.jorypestorious.dvdlibrary.dto.DVD;
import java.util.HashMap;

public class UI {
    
    public void listLibrary(HashMap<String, DVD> dvdLibrary) {
        System.out.println("\n                               DVDs                               \n" +
                           "------------------------------------------------------------------\n");
        
        for (String title : dvdLibrary.keySet()) {
            System.out.println(dvdLibrary.get(title) + "\n");
        }
        
        System.out.println("------------------------------------------------------------------\n");
    }
    
    public void displayDVD(DVD d) {
        System.out.println("\n" + d);
    }

}
