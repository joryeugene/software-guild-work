package com.jorypestorious.fileio;

import java.net.URL;
import java.util.Scanner;

public class SimpleWebInput {
    
    public static void main(String[] args) throws Exception {
        URL mcool = new URL("https://cs.leanderisd.org/mitchellis.txt");
        Scanner scanWeb = new Scanner(mcool.openStream());
        
        while (scanWeb.hasNextLine()) {
            String one = scanWeb.nextLine();
            System.out.println(one);
        }
        
        scanWeb.close();
    }
}
