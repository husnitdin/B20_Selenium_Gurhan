package com.cybertek.tests.Day05_TestNG_DropdownsIntro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Practices {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @Test
    public void google_title_verification(){

        // 2. verify if the title is Google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Titles are not matching!");
    }

    @Test
    public void google_search_title_verification(){

        // 2. search apple
        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);

        // 2. make sure title contains apple
        String expectedSearch = "apple";
        String actualSearch = driver.getTitle();

        Assert.assertTrue(actualSearch.contains(expectedSearch), "Search item not contained in the title");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
    }

}
