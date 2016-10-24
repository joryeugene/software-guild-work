package com.jorypestorious.floormastery;

import com.jorypestorious.floormastery.controller.Controller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Runner {
    
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        switch(readConfigFile()) {
            case "Test": 
                System.out.println("Test Mode - Data Not Saved"); // can delete or leave to inform user that data will not be saved
                Controller controllerUsingTestDAO = (Controller) ctx.getBean("controllerUsingTestDAO");
                controllerUsingTestDAO.run();
                break;
            case "Prod":
                Controller controllerUsingProdDAO = (Controller) ctx.getBean("controllerUsingProdDAO");
                controllerUsingProdDAO.run();
                break;
        }
    }
    
    private static String readConfigFile() {
        try {
            Scanner scanFile = new Scanner(new BufferedReader(new FileReader("Data/Config.txt")));
            return scanFile.nextLine().trim();
        } catch (FileNotFoundException ex) {
            return "Test"; // or change to "Prod" as default if no config file found
        }
    }

}
