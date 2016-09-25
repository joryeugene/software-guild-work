package com.jorypestorious.junitdrills.strings;

public class HasBad {
//Given a String, return true if "bad" appears starting at index 0 or 1 in the String, 
    //such as with "badxxx" or "xbadxx" but not "xxbadxx". The String may be any length, including 0.
//
//hasBad("badxx") -> true
//hasBad("xbadxx") -> true
//hasBad("xxbadxx") -> false

    public boolean hasBad(String str) {
        if (str.length() < 3) return false;
        if (str.indexOf("bad") == 0 || str.indexOf("bad") == 1) return true;
        return false;
    }

}
