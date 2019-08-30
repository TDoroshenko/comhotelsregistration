package com.hotels.registration.pages;

import com.hotels.registration.model.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterNewHotelPage {
    private WebDriver driver;

    public RegisterNewHotelPage(WebDriver driver) {
        this.driver = driver;
    }

    private void typeNameOfNewHotel(String nameOfNewHotel) {
        driver.findElement(By.id("add_hotel:name"));
    }

    private void selectGlobalRating(String globalRating) {
        if (globalRating.equals("1")) {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(2) > a"));
        } else if (globalRating.equals("2")) {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(3) > a"));
        } else if (globalRating.equals("3")) {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(4) > a"));
        } else if (globalRating.equals("4")) {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(5) > a"));
        } else if (globalRating.equals("5")) {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(6) > a"));
        } else {
            driver.findElement(By.cssSelector("#add_hotel\\:rate > div.ui-rating-cancel > a"));
        }
    }

    private void chooseDateOfConstruction(String dateOfConstruction) {
        driver.findElement(By.id("add_hotel:dateOfConstruction_input")).sendKeys(dateOfConstruction);
    }

    private void selectCountry(String country) {
        WebElement countryDropdown = driver.findElement(By.id("add_hotel:country_label"));
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

    private void clickSave() {
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

//    public boolean nameFieldIsEditabale(){
//        this.driver.findElement(By.id("add_hotel:name")).sendKeys("aaa");
//        String text = this.driver.findElement(By.id("add_hotel:name")).getAttribute("Text content");
//        Boolean result = (text.contains("aaa"));
//        return result;
//    }

    public boolean nameFieldIsEditable() {
        Boolean disabled = Boolean.valueOf(this.driver.findElement(By.id("add_hotel:name")).getAttribute("aria-disabled"));
        Boolean readonly = Boolean.valueOf(this.driver.findElement(By.id("add_hotel:name")).getAttribute("aria-readonly"));
        if (disabled == false && readonly == false) {
            return false;
        } else {
            return true;
        }
    }


    public void nameFieldCanBeFilledWithAlphanumericCharacters(){
        this.driver.findElement(By.id("add_hotel:name")).sendKeys("1234567890qwertyuiopasdfghjklzxcvbnm@$#&* {}[],=-().+;'/");
        this.driver.findElement(By.id("add_hotel:j_idt62")).click();

    }
}
