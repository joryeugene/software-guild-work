package com.jorypestorious.dvdlibrarymvc3.dto;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class DVD {
    
    private int id;
    @NotEmpty(message="Enter a value for title.")
    @Length(max=50, message="Title must be no more than 50 characters in length.")
    private String title;
    @Pattern(regexp="^(19|20)\\d{2}$", message="Enter a valid year.")
    private String year;
    @Pattern(regexp="G|PG|PG-13|R|NC-17|X|U|NR|M|MA|g|pg|pg-13|r|nc-17|x|u|nr|m|ma", message="Enter a valid MPAA rating.")
    private String mpaa; // G|PG|PG-13|R|NC-17|X|U|NR|M|MA
    @NotEmpty(message="Enter a value for director.")
    @Length(max=50, message="Director must be no more than 50 characters in length.")
    private String director;
    @NotEmpty(message="Enter a value for studio.")
    @Length(max=50, message="Studio must be no more than 50 characters in length.")
    private String studio;
    @Length(max=250, message="Note must be no more than 250 characters in length.")
    private String note; // user rating or note
    private String image = "/DVDLibrary/img/dvd-placeholder.jpg"; // populated by web api
    private String overview = ""; // populated by web api
    
    public DVD() {}
    
    public DVD(String title, String year, String mpaa, String director, String studio, String note) {
        this.title = title;
        this.year = year;
        this.mpaa = mpaa.toUpperCase();
        this.director = director;
        this.studio = studio;
        this.note = note;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getYear() {
        return year;
    }
    
    public void setYear(String year) {
        this.year = year;
    }
    
    public String getMpaa() {
        return mpaa.toUpperCase();
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
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
    
}
