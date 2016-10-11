package com.jorypestorious.floormastery;

import com.jorypestorious.floormastery.controller.Controller;
import com.jorypestorious.floormastery.dao.OrderDAOProd;
import com.jorypestorious.floormastery.dao.OrderDAOTest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    
    public static void main(String[] args) throws InterruptedException {
        switch(readConfigFile()) {
            case "Test": new Controller(new OrderDAOTest()).run();
            case "Prod": new Controller(new OrderDAOProd()).run();
            default: System.out.println("! Error Reading Configuration File");
        }
    }
    
    private static String readConfigFile() {
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader("Data/Config.txt")));
            return scanFile.nextLine().trim();
        } catch (FileNotFoundException ex) {
            return "Test"; // or change to "Prod"
        }
    }

}
