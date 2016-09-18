package com.jorypestorious.fileio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LetterRevisited {
    public static void main(String[] args) throws IOException {
        PrintWriter write = new PrintWriter(new FileWriter("letter.txt"));
        
        write.println("+--------------------------------------------------+");
        write.println("|                                             #### |");
        write.println("|                                             #### |");
        write.println("|                                             #### |");
        write.println("|                                                  |");
        write.println("|               Jory Eugene Pestorious             |");
        write.println("|               101 Street Address                 |");
        write.println("|               St. Town, MN 55555                 |");
        write.println("|                                                  |");
        write.println("|                                                  |");
        write.println("+--------------------------------------------------+");
        write.flush();
        write.close();
    }
}
