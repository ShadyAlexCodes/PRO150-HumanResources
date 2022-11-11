package com.example.pro355humanresources.Models;

import org.springframework.data.mongodb.core.mapping.Field;


public class Address {
    private String streetNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipcode;

    public Address() {

    }

    public Address(String streetNumber, String streetName, String city, String state, String zipcode) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public Address(Address employeeAddress) {
        this.streetNumber = employeeAddress.streetNumber;
        this.streetName = employeeAddress.streetName;
        this.city = employeeAddress.city;
        this.state = employeeAddress.state;
        this.zipcode = employeeAddress.zipcode;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetName = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        zipcode = zipcode;
    }

}
