package com.jorypestorious.classmodeling;

public class Student {
    
    private static int currentId = 100000;
    
    private int id;
    private String name;
    
    Student () {
        this.id = currentId;
        currentId++;
    }
    
    Student (String name) {
        this();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
