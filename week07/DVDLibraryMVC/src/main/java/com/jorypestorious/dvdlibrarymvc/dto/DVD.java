package com.jorypestorious.dvdlibrarymvc.dto;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class DVD {
    
    private int id;
    @NotEmpty(message="You must supply a value for Title.")
    @Length(max=50, message="Title must be no more than 50 characters in length.")
    private String title;
    @Pattern(regexp="^(19|20)\\d{2}$", message="Enter a valid year.")
    private String year;
    @Pattern(regexp="[GMNPRUX][ACGR]?(?:-\\d{2})?", message="Enter a valid MPAA Rating.")
    private String mpaa; // G|PG|PG-13|R|NC-17|X|U|NR|M|MA
    @NotEmpty(message="You must supply a value for Director.")
    @Length(max=50, message="Director must be no more than 50 characters in length.")
    private String director;
    @NotEmpty(message="You must supply a value for Studio.")
    @Length(max=50, message="Studio must be no more than 50 characters in length.")
    private String studio;
    private String note; // user rating or note
    
    public DVD() {}
    
    public DVD(String title, String year, String mpaa, String director, String studio, String note) {
        this.title = title;
        this.year = year;
        this.mpaa = mpaa;
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
