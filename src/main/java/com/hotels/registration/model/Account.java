package com.hotels.registration.model;

public class Account {
    private String nameOfNewHotel;
    private String globalRating;
    private String dateOfConstruction;
    private String country;
    private String city;
    private String shortDescription;
    private String description;

    public Account() {
    }

    public Account(String nameOfNewHotel, String globalRating, String dateOfConstruction, String country, String city, String shortDescription, String description) {
        this.nameOfNewHotel = nameOfNewHotel;
        this.globalRating = globalRating;
        this.dateOfConstruction = dateOfConstruction;
        this.country = country;
        this.city = city;
        this.shortDescription = shortDescription;
        this.description = description;
    }

    public String getNameOfNewHotel() {
        return nameOfNewHotel;
    }

    public void setNameOfNewHotel(String nameOfNewHotel) {
        this.nameOfNewHotel = nameOfNewHotel;
    }

    public String getGlobalRating() {
        return globalRating;
    }

    public void setGlobalRating(String globalRating) {
        this.globalRating = globalRating;
    }

    public String getDateOfConstruction() {
        return dateOfConstruction;
    }

    public void setDateOfConstruction(String dateOfConstruction) {
        this.dateOfConstruction = dateOfConstruction;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
