package com.hotels.registration.pages;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;


public class MainPageTest {

 private WebDriver driver;
 private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tdoroshenko\\chromedriver\\chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        this.mainPage = new MainPage(this.driver);
    }

    @Test
    public void canOpenCreateNewHotelPage() {
        Assert.assertTrue(this.mainPage.openMainPage()
        .mainPageIsOpened());
//                        .openCreateNewHotelPage();

    }


}
