package com.jorypestorious.classmodeling;

public class Employee {
    
    private static int currentId = 100000;
    
    private int id;
    private String name;
    private String department;
    private String jobTitle;
    
    Employee () {
        this.id = currentId;
        currentId++;
    }
    
    Employee (String name) {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

}
