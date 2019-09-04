package com.hotels.registration.pages;

import com.hotels.registration.model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterNewHotelPage {
    private WebDriver driver;
    Account account = new Account(driver);

    public RegisterNewHotelPage(WebDriver driver) {
        this.driver = driver;
    }

    private void typeNameOfNewHotel(String nameOfNewHotel) {
        driver.findElement(By.id("add_hotel:name"));
    }

    boolean selectGlobalRating(String globalRating) {
        if (globalRating.equals("1")) {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(2) > a")).click();
            return driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(2) > a")).isEnabled();
        } else if (globalRating.equals("2")) {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(3) > a")).click();
            return driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(3) > a")).isSelected();
        } else if (globalRating.equals("3")) {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(4) > a")).click();
            return driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(4) > a")).isSelected();
        } else if (globalRating.equals("4")) {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(5) > a")).click();
            return driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(5) > a")).isSelected();
        } else if (globalRating.equals("5")) {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(6) > a")).click();
            return driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(6) > a")).isSelected();
        } else {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div.ui-rating-cancel > a")).click();
            return driver.findElement(By.cssSelector("#add_hotel\\:rate > div.ui-rating-cancel > a")).isSelected();
        }


    }

    private void chooseDateOfConstruction(String dateOfConstruction) {
        driver.findElement(By.id("add_hotel:dateOfConstruction_input")).sendKeys(dateOfConstruction);
    }

    private void selectCountry(String country) {
        WebElement countryDropdown = driver.findElement(By.cssSelector("#add_hotel\\:country_label"));
        Select value = new Select(countryDropdown);
        value.selectByValue(country);

    }


    private void selectCity(String city) {
        WebElement cityDropdown = driver.findElement(By.id("add_hotel:country_label"));
        Select value = new Select(cityDropdown);
        value.selectByValue(city);
    }

    private void typeShortDescription(String shortDescription) {
        driver.findElement(By.id("add_hotel:short_description")).sendKeys(shortDescription);
    }

    private void typeDescription(String description) {
        driver.findElement(By.id("add_hotel:description")).sendKeys(description);
    }

    void clickSave() {
        WebElement element = driver.findElement(By.id("add_hotel:j_idt62"));
        element.click();
    }

    private void fillRegistrationForm(Account account) {
        typeNameOfNewHotel(account.getNameOfNewHotel());
        selectGlobalRating(account.getGlobalRating());
        chooseDateOfConstruction(account.getDateOfConstruction());
        selectCountry(account.getCountry());
        selectCity(account.getCity());
        typeShortDescription(account.getShortDescription());
        typeDescription(account.getDescription());
    }

    public RegisterNewHotelPage fillAndSaveHotelRegistrationForm(Account account) {
        this.fillRegistrationForm(account);
        this.clickSave();
        return new RegisterNewHotelPage(driver);
    }

    public boolean nameFieldIsPresent() {
        return this.driver.findElement(By.id("add_hotel:name")).isDisplayed();
    }

    public boolean nameFieldIsMarkedWithAsterisk() {
        return this.driver.findElement(By.xpath("//*[@id=\"add_hotel:j_idt42\"]/span")).isDisplayed();
    }

    public boolean nameFieldIsEditable() {
        Boolean disabled = Boolean.valueOf(this.driver.findElement(By.id("add_hotel:name")).getAttribute("aria-disabled"));
        Boolean readonly = Boolean.valueOf(this.driver.findElement(By.id("add_hotel:name")).getAttribute("aria-readonly"));
        if (disabled == false && readonly == false) {
            return false;
        } else {
            return true;
        }
    }

    public void nameFieldCanBeFilledWithAlphanumericCharacters() {
        this.driver.findElement(By.id("add_hotel:name")).sendKeys("1234567890qwertyuiopasdfghjklzxcvbnm@$#&* {}[],=-().+;'/");
        clickSave();
    }

    public void nameFieldEmptySave() {
        this.driver.findElement(By.id("add_hotel:name")).sendKeys("");
        clickSave();
    }

    public void nameFieldValidData() {
        this.driver.findElement(By.id("add_hotel:name")).sendKeys("Rosko");
        clickSave();
    }

    public boolean globalRatingFieldIsPresent() {
        return this.driver.findElement(By.id("add_hotel:j_idt44")).isDisplayed();
    }
//
//    public globalRatingFieldCanBeFilled() {
//        int i = 5;
//        String iString = Integer.toString(i);
//        while (i < 5) {
//            selectGlobalRating(iString);
//            i++;
//        }
//        return ;
//    }

    public boolean dateOfConstructionFieldIsPresent() {
        return this.driver.findElement(By.id("add_hotel:dateOfConstruction_input")).isDisplayed();
    }

    public boolean dateOfConstructionFieldIsMarkedWithAsterisk() {
        return this.driver.findElement(By.xpath("//*[@id=\"add_hotel:j_idt46\"]/span")).isDisplayed();
    }

    public boolean dateOfConstructionFieldIsEditable() {
        Boolean disabled = Boolean.valueOf(this.driver.findElement(By.id("add_hotel:dateOfConstruction_input")).getAttribute("aria-disabled"));
        Boolean readonly = Boolean.valueOf(this.driver.findElement(By.id("add_hotel:dateOfConstruction_input")).getAttribute("aria-readonly"));
        if (disabled == false && readonly == false) {
            return false;
        } else {
            return true;
        }
    }

    public void dateOfConstructionFieldCanBeFilledWithDateFormat() {
        this.driver.findElement(By.id("add_hotel:dateOfConstruction_input")).sendKeys("9/4/20");
        clickSave();
    }

    public void dateOfConstructionFieldCanNotBeFilledWithWrongDateFormat() {
        this.driver.findElement(By.id("add_hotel:dateOfConstruction_input")).sendKeys("2019-05-12");
        clickSave();
    }

    public void dateOfConstructionFieldCanNotBeEmpty() {
        this.driver.findElement(By.id("add_hotel:dateOfConstruction_input")).sendKeys("");
        clickSave();
    }

    public boolean countryFieldIsPresent() {
        return this.driver.findElement(By.id("add_hotel:country_label")).isDisplayed();
    }

    public boolean countryFieldIsMarkedWithAsterisk() {
        return this.driver.findElement(By.xpath("/#add_hotel\\:j_idt48 > span")).isDisplayed();
    }

    public boolean countryFieldIsEditable() {
        Boolean disabled = Boolean.valueOf(this.driver.findElement(By.id("add_hotel:country_label")).getAttribute("aria-disabled"));
        Boolean readonly = Boolean.valueOf(this.driver.findElement(By.id("add_hotel:country_label")).getAttribute("aria-readonly"));
        if (disabled == false && readonly == false) {
            return false;
        } else {
            return true;
        }
    }

    public void canSelectCountry(String country){
        selectCountry(country);
        clickSave();
    }



}
