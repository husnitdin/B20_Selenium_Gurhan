package com.cybertek.tests.Day07_WebTables;
import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class P05_printNameAndCity {

    // • Create a method named printNamesAndCities in SmartBearUtils class.
    //• Method takes WebDriver object.
    //• This method should simply print all the names in the List of All Orders.
    //• Create a new TestNG test to test if the method is working as expected.
    //• Output should be like:
    //• Name1: name , City1: city
    //• Name2: name , City2: city

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtilities.loginToSmartBear(driver);
    }

    @Test
    public void nameVerify(){
        SmartBearUtilities.printNamesAndCities(driver);
    }
}
