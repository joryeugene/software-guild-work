package com.jorypestorious.pbd.records;

import java.net.URL;
import java.util.Scanner;

//class Address {
//
//    String street;
//    String city;
//    String state;
//    int zip;
//}

public class WebAddresses {

    public static void main(String[] args) throws Exception {
        URL addys = new URL("https://cs.leanderisd.org/txt/fake-addresses.txt");
        Scanner fin = new Scanner(addys.openStream());

        Address uno = new Address();
        uno.street = fin.nextLine();
        uno.city = fin.nextLine();
        uno.state = fin.next();
        uno.zip = fin.nextInt();
        fin.skip("\n");

        Address dos = new Address();
        dos.street = fin.nextLine();
        dos.city = fin.nextLine();
        dos.state = fin.next();
        dos.zip = fin.nextInt();
        fin.skip("\n");

        Address tre = new Address();
        tre.street = fin.nextLine();
        tre.city = fin.nextLine();
        tre.state = fin.next();
        tre.zip = fin.nextInt();
        fin.skip("\n");
        
        Address cua = new Address();
        cua.street = fin.nextLine();
        cua.city = fin.nextLine();
        cua.state = fin.next();
        cua.zip = fin.nextInt();
        fin.skip("\n");

        Address cin = new Address();
        cin.street = fin.nextLine();
        cin.city = fin.nextLine();
        cin.state = fin.next();
        cin.zip = fin.nextInt();
        fin.skip("\n");

        Address sei = new Address();
        sei.street = fin.nextLine();
        sei.city = fin.nextLine();
        sei.state = fin.next();
        sei.zip = fin.nextInt();

        fin.close();

        System.out.println(uno.street + ", " + uno.city + ", " + uno.state + "  " + uno.zip);
        System.out.println(dos.street + ", " + dos.city + ", " + dos.state + "  " + dos.zip);
        System.out.println(tre.street + ", " + tre.city + ", " + tre.state + "  " + tre.zip);
        System.out.println(cua.street + ", " + cua.city + ", " + cua.state + "  " + cua.zip);
        System.out.println(cin.street + ", " + cin.city + ", " + cin.state + "  " + cin.zip);
        System.out.println(sei.street + ", " + sei.city + ", " + sei.state + "  " + sei.zip);
    }
}
