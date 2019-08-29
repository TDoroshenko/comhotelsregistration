package com.hotels.registration.model;

public class AccounBuilder {
    private String nameOfNewHotel;
    private String globalRating;
    private String dateOfConstruction;
    private String country;
    private String city;
    private String shortDescription;
    private String description;


    public AccounBuilder withNameOfNewHotel(String nameOfNewHotel){
        this.nameOfNewHotel = nameOfNewHotel;
        return this;
    }
    public AccounBuilder withGlobalRating(String globalRating){
        this.globalRating = globalRating;
        return this;
    }
    public AccounBuilder withDateOfConstruction(String dateOfConstruction){
        this.dateOfConstruction = dateOfConstruction;
        return this;
    }
    public AccounBuilder withCountry(String country){
        this.country = country;
        return this;
    }
    public AccounBuilder withCity(String city){
        this.city = city;
        return this;
    }
    public AccounBuilder withShortDescription(String shortDescription){
        this.shortDescription = shortDescription;
        return this;
    }

    public AccounBuilder withDescription(String description){
        this.description = description;
        return this;
    }


    public  Account build(){
        return new Account(nameOfNewHotel,globalRating,dateOfConstruction,country,city,shortDescription,description);
    }
}
