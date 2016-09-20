package com.jorypestorious.classmodeling;

public class Manager {
    
    private String department;
    private String name;
    private int numOfUnderlings;
    
    Manager(String name, String department) {
        this.name = name;
        this.department = department;
    }
    
    public void addUnderling(int num) {
        this.setNumOfUnderlings(this.getNumOfUnderlings() + num);
    }
    
    public void subtractUnderling(int num) {
        this.setNumOfUnderlings(this.getNumOfUnderlings() - num);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfUnderlings() {
        return numOfUnderlings;
    }

    public void setNumOfUnderlings(int numOfUnderlings) {
        this.numOfUnderlings = numOfUnderlings;
    }

}
