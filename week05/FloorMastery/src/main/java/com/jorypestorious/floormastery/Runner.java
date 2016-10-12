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
            case "Test": 
                System.out.println("Test Mode"); // can delete
                new Controller(new OrderDAOTest()).run();
                break;
            case "Prod":
                System.out.println("Production Mode"); // can delete
                new Controller(new OrderDAOProd()).run();
                break;
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
