package com.hotels.registration.pages;

import com.hotels.registration.model.Account;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class RegisterNewHotelPageTest {
    private WebDriver driver;
    private MainPage mainPage;
    private RegisterNewHotelPage registerNewHotelPage;
    private Account account;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tdoroshenko\\chromedriver\\chromedriver.exe");

        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.mainPage = new MainPage(this.driver);
        this.registerNewHotelPage = new RegisterNewHotelPage(this.driver);
    }

//    @BeforeMethod
//    public void setUpHotel() {
//        account = new AccounBuilder()
//                .withNameOfNewHotel("Galiano" + randomInt())
//                .withGlobalRating("2")
//                .withDateOfConstruction("6/20/1993")
//                .withCountry("USA")
//                .withCity("Phoenix")
//                .withShortDescription("not so bad")
//                .withDescription("Or it is..")
//                .build();
//        registerNewHotelPage = new RegisterNewHotelPage(driver);
//    }


//    @Test
//    public void nameFieldIsPresent() {
//        mainPage.openMainPage()
//                .openRegisterNewHotelPage();
//        WebElement nameField = driver.findElement(By.id("add_hotel:name"));
//
//        Assert.assertTrue(nameField.isDisplayed());
//    }


    @Test
    public void checkNameFieldIsPresent() {
        mainPage.openMainPage()
                .openRegisterNewHotelPage();
        Assert.assertEquals(true, registerNewHotelPage
                .nameFieldIsPresent());
    }

    @Test
    public void checkNameFieldIsMarkedWithAsterisk() {
        mainPage.openMainPage()
                .openRegisterNewHotelPage();
        Assert.assertEquals(true, registerNewHotelPage
                .nameFieldIsMarkedWithAsterisk());
    }

    @Test
    public void checkNameFieldIsEditable() {
        mainPage.openMainPage()
                .openRegisterNewHotelPage();
        Assert.assertEquals(false, registerNewHotelPage
                .nameFieldIsEditable());
    }

    @Test
    public void checkNameFieldCanBeFilledWithAlphanumericCharacters() {
        mainPage.openMainPage()
                .openRegisterNewHotelPage();
        registerNewHotelPage.nameFieldCanBeFilledWithAlphanumericCharacters();
        String actualResult = this.driver.findElement(By.id("add_hotel:name")).getAttribute("value"); ;
        String expectedResult = "1234567890qwertyuiopasdfghjklzxcvbnm@$#&* {}[],=-().+;'/";
        Assert.assertTrue(actualResult.contains(expectedResult), "If test failed then not all AlphanumericCharacters are allowed");
    }

}
