package com.jorypestorious.addressbook.dto;

public class Address {
    
    private String firstName;
    private String lastName;
    private String street;
    private String state;
    private String city;
    private int zipcode;
    
    public Address(String firstName, String lastName, String street, String city, String state, int zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    @Override
    public String toString() {
        return firstName + " " + lastName + "\n" +
               street + "\n" +
               city+ ", " + state + " " + zipcode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

}
