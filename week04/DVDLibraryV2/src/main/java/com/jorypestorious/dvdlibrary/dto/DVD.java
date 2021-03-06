package com.jorypestorious.dvdlibrary.dto;

public class DVD {
    
    private String title;
    private int year;
    private String mpaa; // g, pg, pg-13, r, nc-17
    private String director;
    private String studio;
    private String note; // user rating or note
    
    public DVD(String title, int year, String mpaa, String director, String studio, String note) {
        this.title = title;
        this.year = year;
        this.mpaa = mpaa;
        this.director = director;
        this.studio = studio;
        this.note = note;
    }
    
    @Override
    public String toString() {
        return "\"" + title + "\" (" + year + ") Rated " + mpaa + 
                "\nDirected by " + director + " and Produced by " +
                studio + "\nNote: " + note;
    }
    
    //“Spring, Summer, Fall, Winter... and Spring” (2003) Rated R
    //Directed by Ki-duk Kim and Produced by Korea Pictures 
    //Note: 

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMpaa() {
        return mpaa;
    }

    public void setMpaa(String mpaa) {
        this.mpaa = mpaa;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}

    
    

