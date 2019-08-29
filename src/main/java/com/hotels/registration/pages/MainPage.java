package com.hotels.registration.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class MainPage {

    private static final String MAIN_PAGE_URL = "http://localhost:8080/article/faces/welcome.xhtml";
    private static WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/a")
    private WebElement article;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[1]/a")
    private WebElement articleNew;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[1]/ul/li[1]/a")
    private WebElement newHotel;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[1]/ul/li[2]/a/span")
    private WebElement newCountry;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[1]/ul/li[3]/a")
    private WebElement newCity;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[1]/ul/li[4]/a/span")
    private WebElement newOther;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[2]/a")
    private WebElement articleView;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[2]/ul/li[1]/a/span")
    private WebElement viewHotels;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[2]/ul/li[2]/a")
    private WebElement viewCountries;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[2]/ul/li[3]/a")
    private WebElement viewCities;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[2]/ul/li[4]/a/span")
    private WebElement viewStatistic;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[3]/a/span")
    private WebElement articleImportData;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[1]/ul/li[5]/a")
    private WebElement articleQuit;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[2]/a/span[2]")
    private WebElement edit;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[2]/a/span[2]")
    private WebElement editUndo;

    @FindBy(xpath = "//*[@id=\"header_form:j_idt9\"]/ul/li[2]/ul/li[2]/a/span[2]")
    private WebElement editRedo;

    Actions actions = new Actions(driver);


    public MainPage openMainPage() {
        this.driver.navigate().to(MAIN_PAGE_URL);
        return this;
    }

    public boolean mainPageIsOpened() {
        return this.driver.findElement(By.xpath("//*[@id=\"header_form:j_idt9\"]/ul/li[1]/a/span[2]")).isDisplayed();

//    public MainPage openCreateNewHotelPage() {
//        action.moveToElement(newHotel).click().build().perform();
//        return this;
//    }


    }
}
