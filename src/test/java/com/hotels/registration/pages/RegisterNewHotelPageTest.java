package com.hotels.registration.pages;


import com.hotels.registration.model.AccounBuilder;
import com.hotels.registration.model.Account;
import com.hotels.registration.utils.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.hotels.registration.utils.TestHelper.randomInt;

public class RegisterNewHotelPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private RegisterNewHotelPage registerNewHotelPage;
    private Account account;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tdoroshenko\\chromedriver\\chromedriver.exe");

        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.mainPage = new MainPage(this.driver);
        this.registerNewHotelPage = new RegisterNewHotelPage(this.driver);
        mainPage.openMainPage()
                .openRegisterNewHotelPage();
    }

    @BeforeMethod
    public void setUpHotel() {
        account = new AccounBuilder()
                .withNameOfNewHotel("Galiano" + randomInt())
                .withGlobalRating("2")
                .withDateOfConstruction("6/20/1993")
                .withCountry("USA")
                .withCity("Phoenix")
                .withShortDescription("not so bad")
                .withDescription("Or it is..")
                .build();
        registerNewHotelPage = new RegisterNewHotelPage(driver);
    }

    @Test
    public void checkNameFieldIsPresent() {
        Assert.assertEquals(true, registerNewHotelPage
                .nameFieldIsPresent());
    }

    @Test
    public void checkNameFieldIsMarkedWithAsterisk() {
        Assert.assertEquals(true, registerNewHotelPage
                .nameFieldIsMarkedWithAsterisk());
    }

    @Test
    public void checkNameFieldIsEditable() {
        Assert.assertEquals(false, registerNewHotelPage
                .nameFieldIsEditable());
    }

    @Test
    public void checkNameFieldCanBeFilledWithAlphanumericCharacters() {
        registerNewHotelPage.nameFieldCanBeFilledWithAlphanumericCharacters();
        String actualResult = this.driver.findElement(By.id("add_hotel:name")).getAttribute("value"); ;
        String expectedResult = "1234567890qwertyuiopasdfghjklzxcvbnm@$#&* {}[],=-().+;'/";
        Assert.assertTrue(actualResult.contains(expectedResult), "If test failed then not all AlphanumericCharacters are allowed");
    }

    @Test
    public void checkNameFieldCanNotBeSavedEmpty() {
        registerNewHotelPage.nameFieldEmptySave();
        String actualResult = this.driver.findElement(By.cssSelector("#add_hotel\\:j_idt43 > span.ui-message-error-detail")).getText(); ;
        String expectedResult = "Name: Validation Error: Value is required.";
        Assert.assertTrue(actualResult.contains(expectedResult), "If test failed then empty name can be saved");
    }

    @Test
    public void checkNameFieldWithValidDataCanBeSaved() {
        registerNewHotelPage.nameFieldValidData();
        String actualResult = this.driver.findElement(By.id("add_hotel:name")).getAttribute("value"); ;
        String expectedResult = "Rosko";
        Assert.assertTrue(actualResult.contains(expectedResult), "If test failed then empty name can be saved");
    }

    @Test
    public void checkGlobalRateFieldIsPresent() {
        Assert.assertEquals(true, registerNewHotelPage
                .globalRatingFieldIsPresent());
    }

//    @Test
//    public void globalRatingFieldCanBeFilled() {
//        int i = 5;
//        String iString = Integer.toString(i);
//        while (i < 5) {
//            registerNewHotelPage.selectGlobalRating(iString);
//            i++;
//        }
//    }


//    @Test
//    public void checkGlobalRateFieldWithValidDataCanBeSaved() {
//        registerNewHotelPage.selectGlobalRating("2");
//        this.driver.findElement(By.id("add_hotel:j_idt62")).click();;
//        Boolean actualResult = this.driver.findElement(By.cssSelector("#add_hotel\\:rate > div:nth-child(3) > a")).isSelected();
//        Boolean expectedResult = true;
//        Assert.assertTrue(actualResult.equals(expectedResult), "If test failed then empty name can be saved");
//    }


    @Test
    public void checkDateOfConstructionFieldIsPresent() {
        Assert.assertEquals(true, registerNewHotelPage
                .dateOfConstructionFieldIsPresent());
    }


    @Test
    public void checkDateOfConstructionFieldIsMarkedWithAsterisk() {
        Assert.assertEquals(true, registerNewHotelPage
                .dateOfConstructionFieldIsMarkedWithAsterisk());
    }

    @Test
    public void checkDateOfConstructionFieldIsEditable() {
        Assert.assertEquals(false, registerNewHotelPage
                .dateOfConstructionFieldIsEditable());
    }

    @Test
    public void checkDateOfConstructionFieldCanBeFilledWithDateFormat() {
        registerNewHotelPage.dateOfConstructionFieldCanBeFilledWithDateFormat();
        String actualResult = this.driver.findElement(By.id("add_hotel:dateOfConstruction_input")).getAttribute("value"); ;
        String expectedResult = "9/4/20";
        Assert.assertTrue(actualResult.contains(expectedResult), "If test failed then not all date formats are allowed.");
    }

    @Test
    public void checkDateOfConstructionFieldCanNotBeFilledWithWrongDateFormat() {
        registerNewHotelPage.dateOfConstructionFieldCanNotBeFilledWithWrongDateFormat();
        String actualResult = this.driver.findElement(By.cssSelector("#add_hotel\\:j_idt47 > span.ui-message-error-detail")).getAttribute("class"); ;
        String expectedResult = "ui-message-error-detail";
        Assert.assertTrue(actualResult.contains(expectedResult), "If test failed then all date formats are allowed.");
    }

    @Test
    public void checkDateOfConstructionFieldCanNotBeEmpty() {
        registerNewHotelPage.dateOfConstructionFieldCanNotBeEmpty();
        String actualResult = this.driver.findElement(By.cssSelector("#add_hotel\\:j_idt47 > span.ui-message-error-detail")).getText(); ;
        String expectedResult = "Date of Construction: Validation Error: Value is required.";
        Assert.assertTrue(actualResult.contains(expectedResult), "If test failed then all date formats are allowed.");
    }

    @Test
    public void checkCountryFieldIsPresentFieldIsPresent() {
        Assert.assertEquals(true, registerNewHotelPage
                .countryFieldIsPresent());
    }

    @Test
    public void checkCountryFieldIsMarkedWithAsterisk() {
        Assert.assertEquals(true, registerNewHotelPage
                .countryFieldIsMarkedWithAsterisk());
    }

    @Test
    public void checkCountryFieldIsEditable() {
        Assert.assertEquals(false, registerNewHotelPage
                .countryFieldIsEditable());
    }




    @Test
    public void checkCountryFieldCanNotBeEmptyOrDefault() {
        registerNewHotelPage.countryFieldCanNotBeEmptyOrDefault();
        String actualResult = this.driver.findElement(By.cssSelector("#add_hotel\\:j_idt51 > span.ui-message-error-detail")).getText(); ;
        String expectedResult = "Country: Validation Error: Value is required.";
        Assert.assertTrue(actualResult.contains(expectedResult), "If test failed then all date formats are allowed.");
    }







    @AfterMethod
    public void cleanup() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            TestHelper.sleep3Seconds();
            driver.close();
        }
    }

}
